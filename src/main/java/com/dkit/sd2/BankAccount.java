package com.dkit.sd2;

/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals.
 * In this sample, a BankAccount object can be accessed by both
 * the Withdraw and Deposit Runnables, that run in their own threads.
 *
 */
public class BankAccount
{
    private double balance;

    /**
     * Constructs a bank account with an initial zero balance.
     */
    public BankAccount()
    {
        this.balance = 0.00;
    }

    /**
     * Deposits money into the bank account.
     * @param amount the amount to deposit
     */
    public /*synchronized*/ void deposit(double amount)
    {
        double newBalance = this.balance + amount;

        this.balance = newBalance;

        System.out.print("Depositing " + amount);
        System.out.println(", new balance is " + newBalance);
    }

    /**
     * Withdraws money from the bank account.
     * @param amount the amount to withdraw
     */
    public /*synchronized*/ void withdraw(double amount)
    {
        double newBalance = this.balance - amount;

        this.balance = newBalance;

        System.out.print("Withdrawing " + amount);
        System.out.println(", new balance is " + newBalance);
    }
    /**
     * Gets the current balance of the bank account.
     * @return the current balance
     */
    public double getBalance()
    {
        return this.balance;
    }
}

/**
 * Java synchronized keyword marks a method as a critical section of code.
 * A critical section is where one and only one thread must be allowed to
 * execute at a time, and the thread holds the lock for the synchronized section.
 * This prevents methods that are accessing shared data concurrently (e.g. balance)
 * from interfering with each other. Only one thread will have access at time.
 * The whole object is locked while a synchronized method is running - meaning
 * that no other thread can access fields in that object.
 */

