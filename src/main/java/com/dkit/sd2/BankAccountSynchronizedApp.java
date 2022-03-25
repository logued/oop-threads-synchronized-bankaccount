package com.dkit.sd2;           // March 2022   OOP

/**
 * This program creates a BankAccount object that will be located on the Heap.
 * We will create two Runnable objects and pass a reference to the BankAccount
 * object into each Runnable - so that the BankAccount can be accessed by both
 * Runnables.
 *
 * A WithdrawRunnable is created to make withdrawals, and a DepositRunnable
 * is created to make withdrawals from a single bank account. A reference to
 * the BankAccount object is passed into both Runnables, so that they can
 * call the withdraw() and deposit() methods in the BankAccount.
 */

public class BankAccountSynchronizedApp
{
    public static void main(String[] args) throws InterruptedException {
        BankAccountSynchronizedApp app = new BankAccountSynchronizedApp();
        app.start();
    }

    public void start() {

        BankAccount account = new BankAccount();  // a single, shared BankAccount

        DepositRunnable depositRunnable = new DepositRunnable(account, 2, 100);  // Deposit:€2x100=€200
        WithdrawRunnable withdrawRunnable = new WithdrawRunnable(account, 2, 100); // Withdraw:€2x100=€200

        Thread depositThread = new Thread(depositRunnable);
        Thread withdrawThread = new Thread(withdrawRunnable);

        depositThread.start();
        withdrawThread.start();

        try {

            depositThread.join();       // pause main thread, until depositThread is finished
            withdrawThread.join();      // pause main thread, until withdrawThread is finished

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Starting with an initial balance of 0.00;
        // If we deposit 200.00 and withdraw 200.00, we would expect the final balance to be 0.00
        // But what actually happens?   Run the code and check the results.
        // If expected and actual results are different, then explain why they are different.

        System.out.println("-------------------**************-----------------------");
        System.out.println("Expected final BankAccount balance: 0.00");
        System.out.println("Actual  final  BankAccount balance: " + account.getBalance());
        System.out.println("-------------------**************-----------------------");

    }
}
