package luong_project1;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

public class ATMSystem {
	
	static Scanner in;
	
	public static void main(String[]args) {
		
		in = new Scanner(System.in);
		
		//Set up ATM and Bank
		ATM a1 = new ATM("ATM1_A", 50.0);
		ATM a2 = new ATM("ATM2_A", 50.0);
		ATM b1 = new ATM("ATM1_B", 50.0);
		ATM b2 = new ATM("ATM2_B", 50.0);
		
		Bank bankA = new Bank("BankofA");
		Bank bankB = new Bank("BankofB");
		
		//Associate Bank to ATM
		a1.setBank(bankA);
		a2.setBank(bankA);
		b1.setBank(bankB);
		b2.setBank(bankB);
		
		//Open Account
		CashCard a11 = bankA.addAccount(40.0, "11", "code11", new GregorianCalendar(2013, 2, 9)); 
		CashCard a12 = bankA.addAccount(40.0, "12", "code12", new GregorianCalendar(2018, 5, 20));
		
		CashCard b111 = bankB.addAccount(40.0, "111", "code111", new GregorianCalendar(2018, 8, 27));
		CashCard b112 = bankB.addAccount(40.0, "112", "code112", new GregorianCalendar(2017, 11, 30));
		CashCard b113 = bankB.addAccount(40.0, "113", "code113", new GregorianCalendar(2015, 8, 5));
		
		System.out.println("Assume all accounts have a $40 preloaded.");
		System.out.println(bankA);
		System.out.println("\n");
		System.out.println(bankB);
		
		System.out.println("\nStates of four ATMS (2 for each Bank)");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(b1);
		System.out.println(b2);
		
		//Map ATM and CashCard to String
		HashMap<String, ATM> atmMap = new HashMap<String, ATM>(); 
		HashMap<String, CashCard> cashCardMap = new HashMap<String, CashCard>();
		
		atmMap.put("ATM_A1", a1);
		atmMap.put("ATM_A2", a2);
		atmMap.put("ATM_B1", b1);
		atmMap.put("ATM_B2", b2);
		
		cashCardMap.put("A 11", a11);
		cashCardMap.put("A 12", a12);
		cashCardMap.put("B 111", b111);
		cashCardMap.put("B 112", b112);
		cashCardMap.put("B 113", b113);
		
		String response = "";
		while(!response.equals("quit")) {
			System.out.println("\nPlease enter your choice of ATM");
			String atmChoice = in.nextLine();
			ATM myATM = atmMap.get(atmChoice);
			
			System.out.println("Please enter your cash card");
			String userCard = in.nextLine();
			CashCard myCashCard = cashCardMap.get(userCard);
			
			if(myCashCard != null && myATM != null) {
				myATM.cardValidation(myCashCard);
			}
			else {
				System.out.println("Illegal ATM or Cash Card");
			}
			
			System.out.println("Would you like to make another transaction? (yes or quit)");
			response = in.nextLine();
		}		
		System.out.println("\n");
		System.out.println(a11.printTransactions());
		System.out.println(a12.printTransactions());
		System.out.println(b111.printTransactions());
		System.out.println(b112.printTransactions());
		System.out.println(b113.printTransactions());
	}

}
