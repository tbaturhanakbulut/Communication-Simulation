
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		PrintStream outstream1;
		try {
	        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
	        e2.printStackTrace();
	        return;
		}
		Customer.customerCounter=0;
		Operator.operatorCounter=0;
		reader.nextLine();
		for(int i=0;i<N;i++) {
			String line[]=reader.nextLine().split(" ");
			if(Integer.parseInt(line[0])==1) {					
				String name=line[1];
				int age=Integer.parseInt(line[2]);
				int ID =Integer.parseInt(line[3]);
				double limitingAmount= Double.parseDouble(line[4]);
				customers[Customer.customerCounter]=new Customer(Customer.customerCounter,name,age,operators[ID],limitingAmount);			
			}
			else if(Integer.parseInt(line[0])==2){
				double talkingCharge=Double.parseDouble(line[1]);
				double messageCost=Double.parseDouble(line[2]);
				double networkCharge=Double.parseDouble(line[3]);
				int discountRate=Integer.parseInt(line[4]);
				operators[Operator.operatorCounter]=new Operator(Operator.operatorCounter,talkingCharge,messageCost,networkCharge,discountRate);
			}
			else if(Integer.parseInt(line[0])==3) {
				int firstCustomerID=Integer.parseInt(line[1]);
				int secondCustomerID=Integer.parseInt(line[2]);
				int hour=Integer.parseInt(line[3]);
				customers[firstCustomerID].talk(hour, customers[secondCustomerID]);
				//System.out.println(customers[firstCustomerID].bill.getCurrentDebt());
				//System.out.println(customers[secondCustomerID].bill.getCurrentDebt());
			}
			
			else if(Integer.parseInt(line[0])==4){
				int firstCustomerID=Integer.parseInt(line[1]);
				int secondCustomerID=Integer.parseInt(line[2]);
				int nofMessages=Integer.parseInt(line[3]);
				customers[firstCustomerID].message(nofMessages, customers[secondCustomerID]);
				//System.out.println(customers[firstCustomerID].bill.getCurrentDebt());	
			}
			else if(Integer.parseInt(line[0])==5){
				int customerID=Integer.parseInt(line[1]);
				double amountOfInternet=Double.parseDouble(line[2]);
				customers[customerID].connection(amountOfInternet);
			}
			else if(Integer.parseInt(line[0])==6){
				int customerID=Integer.parseInt(line[1]);
				double wannaPay=Double.parseDouble(line[2]);
				customers[customerID].getBill().pay(wannaPay);
			}
			else if(Integer.parseInt(line[0])==7){
				int customerID=Integer.parseInt(line[1]);
				int operatorID=Integer.parseInt(line[2]);
				customers[customerID].setOperator(operators[operatorID]);	
			}
			else if(Integer.parseInt(line[0])==8){
				int customerID=Integer.parseInt(line[1]);
				double newLimit=Double.parseDouble(line[2]);
				customers[customerID].getBill().changeTheLimit(newLimit);
			}		
		}
		for(int i=0;i<Operator.operatorCounter;i++) {
			//printing operators
			outstream1.println("Operator "+ i +" : "+ operators[i].servicedForTalking +" " + operators[i].servicedForMessage +" "+String.format("%.2f",operators[i].servicedForInternet));
		}
		//defining the variables for finding the most ones
		int mostTalkedID=customers[0].ID;
		int mostSentID=customers[0].ID;
		int mostInternetID=customers[0].ID;
		//
		for(int i=0;i<Customer.customerCounter;i++) {
			//printing customers
			outstream1.println("Customer "+ i +" : "+String.format("%.2f",customers[i].getBill().paidMoney)+" "+ String.format("%.2f",customers[i].getBill().getCurrentDebt()));
			//finding the most ones
			if(i>0) {
				if(customers[i].talkingTime>customers[mostTalkedID].talkingTime) { // for finding the most talked one					
						mostTalkedID=i;
				}
				if(customers[i].sentMessages>customers[mostSentID].sentMessages) { // for finding the most sent one
						mostSentID=i;
				}
				if(customers[i].internetAmount>customers[mostInternetID].internetAmount) { // for finding the most used one
						mostInternetID=i;
				}
			}
		}
		//printing out the most ones
		outstream1.println(customers[mostTalkedID].name+" : "+customers[mostTalkedID].talkingTime);
		outstream1.println(customers[mostSentID].name+" : "+customers[mostSentID].sentMessages);
		outstream1.println(customers[mostInternetID].name+" : "+ String.format("%.2f",customers[mostInternetID].internetAmount));

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

