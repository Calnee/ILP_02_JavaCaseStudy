package com.ilp.services;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class BankService {

	public static void createServices(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub

		char serviceChoice;
		do {
			Scanner scanner = new Scanner(System.in);

			Services service = new Services();

			System.out.println("Enter Service Code:");
			String serviceCode = scanner.nextLine();
			service.setServiceCode(serviceCode);

			System.out.println("Enter Service Name:");
			String serviceName = scanner.nextLine();
			service.setServiceName(serviceName);

			System.out.println("Enter Service Rate:");
			double serviceRate = scanner.nextDouble();
			service.setServiceRate(serviceRate);

			serviceList.add(service);
			System.out.println("Do you want to create more services? (y/n)");
			serviceChoice = scanner.next().charAt(0);
		} while (serviceChoice == 'y');
	}

	public static void createProduct(ArrayList<Services> serviceList, ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		char moreProduct;
		char moreService;
		Product product = null;
		ArrayList<Services> productServiceList = new ArrayList<Services>();
		System.out.println("The available products are: 1.Savings Max Account 2.Current Account 3.Loan Account");

		do {

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Product Code:");
			String productCode = scanner.nextLine();
			

			System.out.println("Enter Product Name:");
			String productName = scanner.nextLine();
			

			System.out.println("Available Services:");
			for (Services service : serviceList) {
				System.out.println(service.getServiceCode() + ". " + service.getServiceName());
			}
			do {
				System.out.println("Enter the service code you want:1.Cash Deposit 2.ATM Withdrawal 3.Online Banking");
				String productChoice = scanner.nextLine();
				scanner.nextLine();

				for (Services services : serviceList) {
					if (services.getServiceCode().equalsIgnoreCase(productChoice)) {
						productServiceList.add(services);
					}
				}
				System.out.println("Do you want to create more services?(y/n)");
				moreService = scanner.next().charAt(0);

			} while (moreService == 'y');

			if (productName.equalsIgnoreCase("Savings max account")) {
				product = new SavingsMaxAccount(productCode, productName, productServiceList);
				productList.add(product);
			} else if (productName.equalsIgnoreCase("Current account")) {
				product = new CurrentAccount(productCode, productName, productServiceList);
				productList.add(product);
			} else if (productName.equalsIgnoreCase("Loan account")) {
				product = new LoanAccount(productCode, productName, productServiceList);
				productList.add(product);
			}

			System.out.println("Do you want to create more products?(y/n)");
			moreProduct = scanner.next().charAt(0);
			scanner.nextLine();

		} while (moreProduct == 'y');
	}

	
	public static Customer createCustomer(ArrayList<Product> productList) {
		
		int accountChoice;
		Scanner scanner = new Scanner(System.in);
		Customer customer = null;
		
		ArrayList<Account> accountList;
   
			System.out.println("Enter customer ID:");
			String customerCode = scanner.nextLine();
			
			System.out.println("Enter customer name:");
			String customerName = scanner.nextLine();
			
			
			System.out.println("ID do not exist. Create new account");
			char moreAccounts = 'y';
			
			do {
			System.out.println("**********Accounts available**********");
			System.out.println("1.Savings Max Account 2.Current Account 3.Loan Account");
			System.out.println("Enter your choice:");
			accountChoice = scanner.nextInt();
			
			Random random = new Random();
			double accountNo = random.nextInt() * 10;
	        String accountNum = Double.toString(accountNo);
	        String accountType = "";
            Product customerProduct = null;
			
			switch(accountChoice) {
			
			case 1:
		        accountType = "Savings Max Account";
		        for (Product product : productList) {
	                if ("Savings Max Account".equalsIgnoreCase(product.getProductName())) {
	                	customerProduct = product;     	
	                }
	            }
				break;
				
			case 2:
		        accountType = "Current Account";
		        for (Product product : productList) {
	                if ("Current Account".equalsIgnoreCase(product.getProductName())) {
	                	customerProduct = product;     	
	                }
	            }
		        break;
		      
			case 3:
		        accountType = "Loan Account";
		        for (Product product : productList) {
	                if ("Loan Account".equalsIgnoreCase(product.getProductName())) {
	                	customerProduct = product;     	
	                }
	            }  
		        break;
			}
			System.out.println("Enter balance to add: ");
		    double accountBalance = scanner.nextInt();
		    Account account = new Account(accountNum,customerProduct.getProductName(),customerProduct,accountBalance) ;
			accountList = new ArrayList<Account>();
			accountList.add(account);
			
			
			
			//ArrayList<Services> productServiceListNew = productServiceList.getServices();
			System.out.println(accountType+"   "+"created for"+"  "+customerName+"\nAccount is active!!!");
			//System.out.println("You have the following services:\n");
		
			System.out.println("Do you want to create more accounts?(y/n)");
			moreAccounts = scanner.next().charAt(0);
			}while(moreAccounts == 'y');	
			
			customer = new Customer(customerName,customerCode,accountList);
			return customer;
	
	}

	
	public static void manageAccount(Customer customer) {
		
		Scanner scanner = new Scanner(System.in);
		String manageChoice;
		System.out.println("Enter the customer ID: ");
		String customerID = scanner.nextLine();
		System.out.println(customerID);
		System.out.println(customer.getCustomerCode());
		
		
		if (customerID.equalsIgnoreCase(customer.getCustomerCode())) {
			 
			System.out.println(customer.getCustomerName() + " has the following accounts:");
			 ArrayList<Account> newAccount = customer.getAccount();
		        for (Account account : newAccount) {
		            System.out.println(account.getAccountType());
		        }
		    } else {
		        System.out.println("Customer not found!");
		    }
		
		System.out.println("Enter your account choice:");
		manageChoice = scanner.nextLine();
		int choice;
		
		for (Account account : customer.getAccount()) {
			 
			//double balance = account.getAcccountBalance();
		do {
			if(manageChoice.equalsIgnoreCase(account.getAccountType())) {
				System.out.println("Enter your choice: 1.Deposit 2.Withdraw 3.Display balance");
				choice = scanner.nextInt();
				scanner.nextLine();
				
				switch(choice) {
				
				case 1:
					depositMoney(account);
					break;
					
				case 2:
					withdrawMoney(account);
					break;
					
				case 3:
					displayBalance(account);
					break;	
				}	
			}
				System.out.println("Do you want to continue?(y/n)");
				choice = scanner.next().charAt(0);
				}while(choice =='y');
		   }
		}
	

	private static void displayBalance(Account account) {
		
		System.out.println("The current balance:"+account.getAcccountBalance());
		
		
	}

	private static void withdrawMoney(Account account) {
		
		Scanner scanner = new Scanner(System.in);
		
		if(account.getAccountType().equalsIgnoreCase("Savings Max Account")) {
			System.out.println("Enter the amount to be withdrawn:");
			double withdrawAmount = scanner.nextDouble();
			scanner.nextLine();
			double newBalance = account.getAcccountBalance()- withdrawAmount;
			
			if(newBalance < 1000) {
				System.out.println("Sorry!!!!!!!!!!!!! A mininmum balance of Rs 1000 should be mainted in the account.");
			}
			else {
				double newBalanceWithdraw = account.getAcccountBalance()- withdrawAmount;
				account.setAcccountBalance(newBalanceWithdraw);
				System.out.println("Your current balance is:"+ newBalanceWithdraw);
			}	
		}
		else if(account.getAccountType().equalsIgnoreCase("Current Account")) {
			
			System.out.println("Enter the amount to be withdrawn:");
			double withdrawAmount = scanner.nextDouble();
			scanner.nextLine();
			double newBalance = account.getAcccountBalance()- withdrawAmount;
			
			if(newBalance <= 0) {
				System.out.println("Account should not be empty.");
			}
			else {
				double newBalanceWithdraw = account.getAcccountBalance()- withdrawAmount;
				account.setAcccountBalance(newBalanceWithdraw);
				System.out.println("Your current balance is:"+ newBalanceWithdraw);
			}	
		}
		else if(account.getAccountType().equalsIgnoreCase("Loan Account")) {
			
			System.out.println("Cannot withdraw from Loan Account");
		}	
	}

	private static void depositMoney(Account account) {
		
		Scanner scanner = new Scanner(System.in);
		
		if(account.getAccountType().equalsIgnoreCase("Savings Max Account")) {
			
			System.out.println("Enter the amount to be deposited:");
			double deposit = scanner.nextDouble();
			scanner.nextLine();
			double newBalance = account.getAcccountBalance()+ deposit;	
			System.out.println("Your current balance is"+"  "+newBalance);
		}
		else if(account.getAccountType().equalsIgnoreCase("Current Account")) {
			
			System.out.println("Enter the amount to be deposited:");
			double deposit = scanner.nextDouble();
			scanner.nextLine();
			double newBalance = account.getAcccountBalance()+ deposit;	
			System.out.println("Your current balance is"+"  "+newBalance);
		}
		else if(account.getAccountType().equalsIgnoreCase("Loan Account")) {
			
			System.out.println("Deposit method ");
			System.out.println("1.Cash / 2.Cheque");
			int depositChoice = scanner.nextInt();
			scanner.nextLine();
			
			switch(depositChoice) {
			
			case 1:
				
				System.out.println("Enter the amount to be deposited:");
				double deposit = scanner.nextDouble();
				scanner.nextLine();
				double newBalance = account.getAcccountBalance()+ deposit;	
				System.out.println("Your current balance is"+"  "+newBalance);
				break;
				
			case 2:
				
				System.out.println("Enter the amount to be deposited:");
				double depositCheque = scanner.nextDouble();
				scanner.nextLine();
				double chargePercentage = 0.003;
				double chequeAmount = depositCheque * chargePercentage;
				double totalChequeAmount = depositCheque - chequeAmount;
				double newChequeBalance = account.getAcccountBalance()+ totalChequeAmount;
				account.setAcccountBalance(newChequeBalance);
				System.out.println("Your current balance is"+"  "+newChequeBalance);
				break;
			}	
		}	
	}

	public static void displayCustomer(Customer customer) {
		
		System.out.println("***********************************Customer Account Details*********************************");
		System.out.println("CustomerID"+"         "+"CustomerName"+"         "+"AccountType"+"               "+"Balance");
		System.out.println("*********************************************************************************************");
		for (Account account : customer.getAccount()) {
			if(account.getAccountType().equalsIgnoreCase("Savings Max Account")) {
				System.out.println(customer.getCustomerCode()+"              "+customer.getCustomerName()+"               "+account.getAccountType()+"                 "+account.getAcccountBalance());
				System.out.println("services provided:");
				 for (Services service : account.getProduct().getServices()) {
			            System.out.println("- " + service.getServiceName() + " (" + service.getServiceCode() + ")");
			        }
				}
			else if(account.getAccountType().equalsIgnoreCase("Current Account")) {
				
				System.out.println(customer.getCustomerCode()+"         "+customer.getCustomerName()+"         "+account.getAccountType()+"                 "+account.getAcccountBalance());
				System.out.println("services provided:");
				 for (Services service : account.getProduct().getServices()) {
			            System.out.println("- " + service.getServiceName() + " (" + service.getServiceCode() + ")");
			        }
			}
			else if(account.getAccountType().equalsIgnoreCase("Loan Account")) {
				
				System.out.println(customer.getCustomerCode()+"         "+customer.getCustomerName()+"         "+account.getAccountType()+"                 "+account.getAcccountBalance());
				System.out.println("services provided:");
				 for (Services service : account.getProduct().getServices()) {
			            System.out.println("- " + service.getServiceName() + " (" + service.getServiceCode() + ")");
			        }
			}
		}
	}

	public static void exitBank() {
		// TODO Auto-generated method stub

	}

}
