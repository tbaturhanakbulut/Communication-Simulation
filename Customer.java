
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	protected static int customerCounter;
	int ID;
	String name;
	private int age;
	private Operator operator;
	private Bill bill;
	int talkingTime=0;
	int sentMessages=0;
	double internetAmount=0.0;
	Customer(int ID, String name,int age, Operator operator, double limitingAmount){
		this.ID=ID;
		this.name=name;
		this.age=age;
		this.operator=operator;
		bill=new Bill(limitingAmount);
		customerCounter+=1;
	}
	void talk(int minute, Customer other) {
		if(this!=other) {
			double thisCost=operator.calculateTalkingCost(minute, this);
			if(bill.check(thisCost)) {
				talkingTime+=minute;
				operator.servicedForTalking+=minute;
				other.talkingTime+=minute;
				other.operator.servicedForTalking+=minute;
				bill.add(thisCost); //added to this bill the cost.
			}
		}				
	}
	void message(int quantity, Customer other) {
		if(this!=other) {
			double thisCost=operator.calculateMessageCost(quantity, this, other);
			if(bill.check(thisCost)) {
				operator.servicedForMessage+=quantity;
				sentMessages+=quantity;
				bill.add(thisCost);
			}
		}
	}
	
	void connection(double amount) {
		double thisCost=operator.calculateNetworkCost(amount);
		if(bill.check(thisCost)) {
			operator.servicedForInternet+=amount;
			internetAmount+=amount;
			bill.add(thisCost);
		}	
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator=operator;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill=bill;
	}

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

