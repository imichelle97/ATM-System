package luong_project1;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**Program Assignment #1: ATM Network System
 * Author: Michelle Luong
 * Copyright (C) 2017 Michelle Luong. All Rights Reserved.
 * Version: 1.01 2/24/2017
 */

/**
 * Representation of user's accounts.  
 * @author michelle
 *
 */
public class Account {
	
	private double currentBalance;
	private String passcode;
	private String accountNum;
	private CashCard myCard;
	
	/**
	 * Constructs an Account with the following requirements:
	 * @param currentBalance current balance of the user's account
	 * @param passcode passcode of the user's account
	 * @param accountNum account number of the user's account
	 * @param myCard includes bank id, expiration date, and account number from CashCard
	 */
	public Account(double currentBalance, String passcode, String accountNum, CashCard myCard) {
		this.currentBalance = currentBalance;
		this.passcode = passcode;
		this.accountNum = accountNum;
		this.myCard = myCard;
	}
	
	/**
	 * Sets the account balance
	 * @param currentBalance balance to set
	 */
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	/**
	 * Gets current balance
	 * @return currentBalance
	 */
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	/**
	 * Gets passcode
	 * @return passcode
	 */
	public String getPasscode() {
		return passcode;
	}
	
	/**
	 * Gets the account number
	 * @return accountNum
	 */
	public String getAccountNum() {
		return accountNum;
	}
	
	/**
	 * Gets the expiration date
	 * @return getExpiredDate
	 */
	public GregorianCalendar getExpire() {
		return myCard.getExpiredDate();
	}
	
	/**
	 * Returns a string representation of the account information
	 * @return Account information
	 */
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return "\nCustomer - Cash Card (Bank ID: " + myCard.getBankID() + " account number: #" + accountNum + "), expires on " + sdf.format(myCard.getExpiredDate().getTime()) + ", passcode: " + passcode; 
	}
}
