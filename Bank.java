package luong_project1;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**Program Assignment #1: ATM Network System
 * Author: Michelle Luong
 * Copyright (C) 2017 Michelle Luong. All Rights Reserved.
 * Version: 1.01 2/24/2017
 */

/**
 * Representation of the Bank
 * @author michelle
 *
 */

public class Bank {

	private String BankID;
	private ArrayList<Account> AllAccount;
	
	/**
	 * Constructs a Bank with the following requirements:
	 * @param BankID id of the bank
	 */
	public Bank(String BankID) {
		this.BankID = BankID;
		this.AllAccount = new ArrayList<Account>();
	}
	
	/**
	 * Gets the bank id
	 * @return BankID
	 */
	public String getBankID() {
		return BankID;
	}
	
	/**
	 * Issues an Account to a CashCard
	 * @param startBalance
	 * @param accountNum
	 * @param passcode
	 * @param expireDate
	 * @return
	 */
	public CashCard addAccount(double startBalance, String accountNum, String passcode, GregorianCalendar expireDate) {		
		CashCard newCashCard = new CashCard(BankID, expireDate, accountNum);
		AllAccount.add(new Account(startBalance, passcode, accountNum, newCashCard));
		return newCashCard;
	}
	
	/**
	 * Gets an Account
	 * @param accountNum
	 * @return returnAccount
	 */
	public Account getAccount(String accountNum) {
		Account returnAccount = null;
		for(int i = 0; i < AllAccount.size(); i++) {
			if(AllAccount.get(i).getAccountNum().equals(accountNum)){
				returnAccount = AllAccount.get(i);
				return returnAccount;
			}				
		}
		return returnAccount;
	}
	
	/**
	 * Verify the passcode from user input with the passcode
	 * from Account
	 * @param input
	 * @param account
	 * @return true if user's inputed passcode matches the 
	 * Account's passcode 
	 */
	public boolean verifyPasscode(String input, Account account) {
		if(input.equals(account.getPasscode())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Verify the bank's id
	 * @param cardBankID
	 * @return true is bank id matches
	 */
	public boolean verifyBankID(String cardBankID) {
		if(getBankID().equals(cardBankID))
			return true;
		else
			return false;
	}
	
	/**
	 * Verify the requested amount
	 * @param requestedAmount
	 * @param chosenAccount
	 * @return true if requested amount is less than current balance,
	 * therefore, able to withdraw requested amount from Account
	 */
	public boolean verifyAmount(double requestedAmount, Account chosenAccount) {
		if(requestedAmount <= chosenAccount.getCurrentBalance()) {
			withdraw(requestedAmount, chosenAccount);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Withdraw transaction
	 * @param amount
	 * @param account
	 */
	public void withdraw(double amount, Account account) {
		account.setCurrentBalance(account.getCurrentBalance() - amount);
	}
	
	/**
	 * Returns a String representaion of the Accounts and BankID
	 */
	public String toString() {
		
		String print = "Bank " + BankID + " ( " + AllAccount.size() + " Customers)\n";
		
		for(Account account:AllAccount) {
			print = print + account.toString();
		}
		return print;
	}
	
	
}
