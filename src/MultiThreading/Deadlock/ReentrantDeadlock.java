package MultiThreading.Deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDeadlock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantRunner reentrantRunner = new ReentrantRunner();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantRunner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantRunner.secondThread();
            }
        });

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        reentrantRunner.finished();

    }
}

class ReentrantRunner {
    private ReentrantAccount acc1 = new ReentrantAccount();
    private ReentrantAccount acc2 = new ReentrantAccount();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void firstThread() {
        Random amount = new Random();
        for (int i = 0; i < 10000; i++) {
//            lock1.lock(); // заблокировали lock1
//            lock2.lock(); // Этот код не выполняется так как lock2() заблокирован вторым потоком в методе secondThread

            takeLocks(lock1, lock2);
            // будем перемещать случайное количество денег с первого счета на второй
            try {
                ReentrantAccount.transfer(acc1, acc2, amount.nextInt(100));
            } finally { // открытие потоков необходимо всегда производить в блоке finally на случай возникновения ошибки
                // в основном коде. Так получается гарантия, что потоки всегда будут освобождены
                lock1.unlock();
                lock2.unlock();
            }

        }
    }
    /* Для синхронизации потоков исполтзуем reentrantLock, что позволяет избежать использования synchronized вложенных блоков
    *  Так как сизронизация происходит на двух объектах необходимо сначала заблокировать мониторы обоих объектов и
    * только потом произвести операцию. После этого оба монитора открываем обратно.
    *
    * Если возникает ситуация при которой два или несколько потоков блокируют все lock (Deadlock), как например в этом классе, где
    * lock1 заблокирован методом firstThread, а lock2 Заблокирован методом secondThread. Способы избежания Deadlock^
    * 1) Не допускать ситуации при которой lock забираются в разных потоках в разном порядке
    * 2) Использовать метод tryLock() в классе ReentrantLock. Реализация будет произведена в методе takeLocks*/

    public void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false; // показывают занятость первого и второго lock
        boolean secondLockTaken = false;
        /* Метод tryLock() пытается забрать lock, Если lock не занят он его забирает и возвращает true, Если lock
        * занят другим объектом он его не забирает и возвращает false*/
        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) return; // Если оба лока успешно забрали выходим из метода
            } // Если же один из lock был занят, а второй нет необходимо освободить занятый lock и повторить процедуру
            // забора lock. Так как все выполняется в бесконечном цикле из метода выйдем только тогда, когда потокам
            // потоки заберут оба lock
            if (firstLockTaken) lock1.unlock();
            if (secondLockTaken) lock2.unlock();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void secondThread() {
        Random amount = new Random();
        for (int i = 0; i < 10000; i++) {
//            lock2.lock(); // Заблокирован lock 2
//            lock1.lock(); // Этот код не выполняется так как lock1() уже заблокирован в методе firstThread
            takeLocks(lock2, lock1);
            try {
                ReentrantAccount.transfer(acc2, acc1, amount.nextInt(100));
            } finally {
                lock2.unlock();
                lock2.unlock();
            }
        }
    }


    /* В результате рандомных перемещений денежных средств с первого счета на второй получаем, что общая сумма перестает
    * быть равной 20000 тысячам. Пример:
    * Баланс первого счета 13776
      Баланс второго счета 7134
      Общий баланс 20910*/
    public void finished() {
        System.out.println("Баланс первого счета " + acc1.getBalance());
        System.out.println("Баланс второго счета " + acc2.getBalance());
        System.out.println("Общий баланс " + (acc1.getBalance() + acc2.getBalance()));
    }
}

class ReentrantAccount {
    private int balance = 10000; // баланс на момент создания счета

    public static void transfer(ReentrantAccount reentrantAccount1, ReentrantAccount reentrantAccount2, int amount) {
        // позволяет перемещать средства с одного расчетного счета на другой
        reentrantAccount1.withdraw(amount); // списываем с одного счета
        reentrantAccount2.deposite(amount); // кладем на другой
    }

    public void deposite(int amount) { // процедура пополнения счета
        balance += amount;
    }

    public void withdraw(int amount) { // списание денег со счета
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
