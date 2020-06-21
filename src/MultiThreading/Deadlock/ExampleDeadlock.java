package MultiThreading.Deadlock;

import java.util.Random;

public class ExampleDeadlock {
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

class Runner {
    private ReentrantAccount acc1 = new ReentrantAccount();
    private ReentrantAccount acc2 = new ReentrantAccount();
    /* Для того чтобы сихронизировать 2 потока для двух разных объектов можно использовать 3 блока synchronized()
    * один из которых вложен в другой. Это позволит устранить ситуацию с нарушением суммы общего баланса*/

    /* !!!Такая вложенность является нежелательной. Лучше для реализации этой задачи использовать reentrantLock
    * Реализуем в отдельном классе ReentrantDeadlock*/
    public void firstThread() {
        Random amount = new Random();
        for (int i = 0; i < 10000; i++) {
            synchronized (acc1) {
                synchronized (acc2) {
                // будем перемещать случайное количество денег с первого счета на второй
                    ReentrantAccount.transfer(acc1, acc2, amount.nextInt(100));
                }
            }
        }

    }
    public void secondThread() {
        Random amount = new Random();
        for (int i = 0; i < 10000; i++) {
            synchronized (acc1) {
                synchronized (acc2) {
                    // будем перемещать случайное количество денег со второго счета на первый
                    ReentrantAccount.transfer(acc2, acc1, amount.nextInt(100));
                }
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

class Account {
    private int balance = 10000; // баланс на момент создания счета

    public void deposite(int amount) { // процедура пополнения счета
        balance+=amount;
    }
    public void withdraw(int amount) { // списание денег со счета
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }
    public static void transfer(ReentrantAccount reentrantAccount1, ReentrantAccount reentrantAccount2, int amount) {
        // позволяет перемещать средства с одного расчетного счета на другой
        reentrantAccount1.withdraw(amount); // списываем с одного счета
        reentrantAccount2.deposite(amount); // кладем на другой
    }
}
