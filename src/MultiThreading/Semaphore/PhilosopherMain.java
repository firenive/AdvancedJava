package MultiThreading.Semaphore;

import java.util.concurrent.Semaphore;

public class PhilosopherMain {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        new Philosopher(sem, "Sokrat").start();
        new Philosopher(sem, "Diogen").start();
        new Philosopher(sem, "Aristotel").start();
        new Philosopher(sem, "Demoklit").start();
        new Philosopher(sem, "Safokol").start();
    }
}
