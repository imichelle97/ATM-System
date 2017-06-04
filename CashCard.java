package luong_project1;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**Program Assignment #1: ATM Network System
 * Author: Michelle Luong
 * Copyright (C) 2017 Michelle Luong. All Rights Reserved.
 * Version: 1.01 2/24/2017
 */

/**
 * Representation of a customer's cash card
 * @author michelle
 * 
 */

public class CashCard {
	
	private String bankID;
	private GregorianCalendar expireDate;
	private String accountNum;
	private double[] log;
	private int currentSize;
	
	/**
	 * Constructs a CashCard with the following requirements:
	 * @param bankID id of the bank
	 * @param expireDate expiration date of the cash card
	 * @param accountNum the account number
	 */
	public CashCard(String bankID, GregorianCalendar expireDate, String accountNum) {
		this.bankID = bankID;
		this.expireDate = expireDate;
		this.accountNum = accountNum;
		log = new double[20];
		currentSize = 0;
	}
	
	/**
	 * Gets the bank id
	 * @return bankID
	 */
	public String getBankID() {
		return bankID;
	}
	
	/**
	 * Gets the cash card's expiration date
	 * @return expireDate
	 */
	public GregorianCalendar getExpiredDate() {
		return expireDate;
	}
	
	/**
	 * Gets the account number
	 * @return accountNum
	 */
	public String getAccountNum() {
		return accountNum;
	}
	
	/**
	 * Adds each cash card's transaction to a transaction log
	 * @param transaction
	 */
	public void addLog(double transaction) {
		log[currentSize] = transaction;
		currentSize++;
	}
	
	/**
	 * Prints the String representation log of transactions
	 * @return transactions
	 */
	public String printTransactions() {
		String print = bankID + " " + accountNum + " Transactions: \n";
		for(int i = 0; i < currentSize; i++) {
			print += log[i] + " ";
		}
		return print;
	}
	
	/**
	 * String representation of the Cash Card's information, 
	 * including bank id, card number, expiration date and 
	 * account number
	 */
	public String toString() {
		String print = "\nCash Card (Bank ID: " + bankID + ", Card Number: #" + accountNum + ") accesses "; 
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return print + " expires on: " + sdf.format(expireDate.getTime());
	}
	
}
