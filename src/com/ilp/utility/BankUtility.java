package com.ilp.utility;


import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.services.BankService;

public class BankUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mainMenu();
	}

	private static void mainMenu() {
		// TODO Auto-generated method stub
		
		int choice;
		char mainMenuRepeat;
		ArrayList<Services> serviceList = new ArrayList<Services>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Services> productServiceList = new ArrayList<Services>();
		ArrayList<Account> accountList = new ArrayList<Account>();
		Customer customer = null;
		do {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("**************Welcome to the Bank**************");
			System.out.println("1.Create Service 2.Create Product 3.Create Customer 4.Manage Account 5.Display Customer 6.Exit");
			System.out.println("Enter you choice :");
			choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1: BankService.createServices(serviceList);
			        System.out.println(serviceList);
			break;
			
			case 2: BankService.createProduct(serviceList,productList);
			        System.out.println(productList);
			break;
			
			case 3: 
				    customer = BankService.createCustomer( productList);
				    System.out.println(customer.getAccount()); 
			break;
			
			case 4: BankService.manageAccount(customer);
			break;
			
			case 5: BankService.displayCustomer(customer);
			break;
			
			case 6: BankService.exitBank();
			break;
		}
			System.out.println("Go to main menu(y/n)");
			mainMenuRepeat = scanner.next().charAt(0);
		}while(mainMenuRepeat=='y');
	}
}
