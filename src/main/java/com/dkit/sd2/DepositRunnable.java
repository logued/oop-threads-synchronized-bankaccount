package com.dkit.sd2;

/**
 * This Runnable task will deposit an 'amount' of money into
 * a shared bankAccount object, a number of times, delaying (sleeping)
 * for "DELAY" number of milliseconds between each deposit.
 */
public class DepositRunnable implements Runnable
{
    private static final int DELAY_MILLISECONDS = 100;   // milliseconds
    private BankAccount bankAccount;
    private double amount;
    private int numberOfDeposits;

    /**
     * Constructs a deposit runnable.
     * Set up the deposit amount and the number of deposits to make for a given BankAccount
     *
     * @param bankAccount the account into which to deposit money
     * @param amount  the amount to deposit in each repetition
     * @param numberOfDeposits    the number of repetitions
     */
    public DepositRunnable(BankAccount bankAccount, double amount, int numberOfDeposits)
    {
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.numberOfDeposits = numberOfDeposits;
    }

    public void run()
    {
        try
        {
            for (int i = 1; i <= numberOfDeposits; i++)
            {
                bankAccount.deposit(amount);    // the deposit() method will run in this thread

                Thread.sleep(DELAY_MILLISECONDS);    // pause for specified time
            }
        } catch (InterruptedException exception)
        {
        }
    }
}


