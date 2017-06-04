package luong_project1;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**Program Assignment #1: ATM Network System
 * Author: Michelle Luong
 * Copyright (C) 2017 Michelle Luong. All Rights Reserved.
 * Version: 1.01 2/24/2017
 */

/**
 * Simulated the ATM. It gathers information from the user, 
 * takes care of transactions (withdraws), and processes
 * the information through the Bank.
 * @author michelle
 *
 */

public class ATM {
	
	private String atmNum;
	private double maxPerTransaction;
	private Bank bank;
	private CashCard insertedCard;
	private Scanner in;
	private Account chosenAccount;	
	
	/**
	 * Constructs an ATM with the following requirements:
	 * @param atmNum ATM number
	 * @param maxPerTransaction Withdraw limit per ATM transaction
	 */
	public ATM(String atmNum, double maxPerTransaction) {
		this.atmNum = atmNum;
		this.maxPerTransaction = maxPerTransaction;
		insertedCard = null;
		in = ATMSystem.in;
	}
	
	/**
	 * Set the bank
	 * @param bank
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	/**
	 * Get the ATM number
	 * @return atmNum
	 */
	public String getATMNum() {
		return atmNum;
	}
	
	/**
	 * Returns String representation of the ATM information, 
	 * including the ATM number and the maximum withdraw
	 * amount per transaction
	 */
	public String toString() {
		return atmNum + ": " 
				+ "\nThe maximum amount of cash a card can withdraw per transaction: $"
				+ maxPerTransaction;
	}
	
	/**
	 * When card gets ejected/removed, the inserted card 
	 * becomes null
	 */
	public void removeCard() {
		insertedCard = null;
	}
	
	/**
	 * 
	 * @param aInsertedCard
	 * @return
	 */
	public boolean cardValidation(CashCard aInsertedCard) {
		insertedCard = aInsertedCard;
		if(insertedCard.getExpiredDate().after(new GregorianCalendar())) {
			if(insertedCard.getBankID().equals(bank.getBankID())) {
				chosenAccount = bank.getAccount(insertedCard.getAccountNum());
				cardAuthorize();
				return true;
			}			
			else {
				System.out.println("Error: Card is not supported by this ATM. Your card has been ejected.");
				removeCard();
				return false;
			}
		}
		else {
			System.out.println("Error: This card is expired. You card has been ejected.");
			removeCard();
			return false;
		}
	}
	
	public void cardAuthorize() {
		boolean authorizeAccepted = false;
		while(!authorizeAccepted) {
			System.out.println("Please enter your passcode: ");
			String input = in.nextLine();
			if(chosenAccount.getPasscode().equals(input)) {
				authorizeAccepted = true;
				System.out.println("Card authorized.");
				cardTransaction();
			}
		}
	}
	
	public void cardTransaction() {
		boolean transactionAccepted = false;
		while(!transactionAccepted) {
			System.out.println("Please enter the amount you would like to withdraw");
			double withdrawAmt = Double.parseDouble(in.nextLine()); 
			if(withdrawAmt <= maxPerTransaction) {
				if(bank.verifyAmount(withdrawAmt, chosenAccount)) {
					System.out.println("Amount approved.");
					System.out.println("$ " + withdrawAmt + " is withdrawn from your account. The remaining balance of this account is $ " + chosenAccount.getCurrentBalance());
					insertedCard.addLog(withdrawAmt);
					transactionAccepted = true;
				}
				else {
					System.out.println("Amount denied. Amount is greater than balance. Please try again.");
				}

			}
			else {
				System.out.println("Amount denied. Amount is greater than ATM limit. Please try again.");
			}
		}
	}

}
