package taskTwo;

import Account.Account;

public class ThreadExecutor extends Thread {
    private Account account;

    public void showAccountFilling(final long millis) {
        account = new Account(0);
        Thread thread1 = new Thread(createTask(2));
        Thread thread2 = new Thread(createTask(-2));
        Thread thread3 = new Thread(createTask(1));

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        while (thread1.isAlive() && thread2.isAlive() && thread3.isAlive()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(account.toString());
    }

    private Runnable createTask(final int value) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                while (!Thread.interrupted()) {
                    try {
                        ThreadExecutor.this.account.addToBalance(value);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " finish");
            }
        };
    }
}
