package com.dkit.sd2;

/**
 * This program runs threads that deposit and withdraw
 * money from the same bank account. Adapted from Section 20.3 in Book
 * See two versions of main()
 */


public class BankAccountSynchronizedApp
{
    public static void main(String[] args) throws InterruptedException
    {
        BankAccount account = new BankAccount();  // default balance is zero

        DepositRunnable d = new DepositRunnable(account, 2, 100);  // Deposit:€2x100=€200
        WithdrawRunnable w = new WithdrawRunnable(account, 2, 100); // Withdraw:€2x100=€200

        Thread dt = new Thread(d);
        Thread wt = new Thread(w);

        dt.start();
        wt.start();

        dt.join();
        wt.join();

        // Starting with an initial balance of 0.00;
        // If we deposit 200 and withdraw 200, we would expect the final balance to be 0.00
        // But what actually happens?   Run the code and check the results.
        // If expected and actual results are different, then explain why are they different.

        System.out.println("-------------------**************-----------------------");
        System.out.println("Expected final BankAccount balance: 0.00");
        System.out.println("Actual  final  BankAccount balance: " + account.getBalance());
        System.out.println("-------------------**************-----------------------");

    }
}

/*
    This version of main() shows a SIMPLE usage of DepositRunnable & WithdrawRunnable
   running two threads sequentially rather than concurrently
*/
//
//    public static void main(String[] args) throws InterruptedException
//    {
//        BankAccount account = new BankAccount();  // default balance is zero
//
//        DepositRunnable d = new DepositRunnable(account, 2, 10);  // Deposit:€2x10=€20
//        Thread dt = new Thread(d);
//        dt.start();
//        System.out.println("After deposits the BankAccount balance: " + account.getBalance());
//
//////        dt.join();
////        WithdrawRunnable w = new WithdrawRunnable(account, 2, 10); // Withdraw:€2x10=€200
///        Thread wt = new Thread(w);
////        wt.start();
////        System.out.println("After withdrawals the BankAccount balance: " + account.getBalance());
////
//    }
//}