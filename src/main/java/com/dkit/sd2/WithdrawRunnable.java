package com.dkit.sd2;

/**
 * This Runnable task makes a withdrawal of an amount of money from
 * the shared BankAccount at 'delay' number of seconds intervals.
 * (DELAY_MILLISECONDS=00 milliseconds)
 * Ii is executed in a Thread in this sample.
 */
public class WithdrawRunnable implements Runnable
{
    private static final int DELAY_MILLISECONDS = 100;   // milliseconds
    private BankAccount bankAccount;        // reference to a shared BankAccount object
    private double amount;                  // amount to withdraw each time
    private int numberOfWithdrawals;        // number of withdrawals to make

    /**
     * Constructs a withdraw Runnable object
     *
     * @param bankAccount the account from which to withdraw money
     * @param amount  the amount to withdraw in each repetition
     * @param numberOfWithdrawals the number of withdrawals to make
     * */
    public WithdrawRunnable(BankAccount bankAccount, double amount, int numberOfWithdrawals)
    {
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.numberOfWithdrawals  = numberOfWithdrawals;
    }

    public void run()
    {
        try
        {
            for (int i = 1; i <= numberOfWithdrawals; i++)
            {
                bankAccount.withdraw(amount);   // withdraw money from the bankAccount
                                                // withdraw() method runs on this thread

                Thread.sleep(DELAY_MILLISECONDS);
            }
        } catch (InterruptedException exception)
        {
        }
    }
}

