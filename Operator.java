
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	protected static int operatorCounter;
	int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	int servicedForTalking=0;
	int servicedForMessage=0;
	double servicedForInternet=0;
	
	Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
		operatorCounter+=1;
	}
	double calculateTalkingCost(int minute,Customer customer) {
		int customerAge=customer.getAge();
		if(customerAge > 65 || customerAge<18) {
			return (minute*talkingCharge)*((100-discountRate)/100.0);
		}
		else {
			return minute*talkingCharge;
		}
	}
	
	double calculateMessageCost(int quantity,Customer customer, Customer other) {
		if(customer.getOperator()==other.getOperator()) {
			return (quantity*messageCost)*((100-discountRate)/100.0);
		}
		else {
			return quantity*messageCost;			
		}
	}
	double calculateNetworkCost(double amount) {
		return amount*networkCharge;
	}
	
	
	public double getTalkingCharge() {
		return talkingCharge;
	}
	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}
	public double getMessageCost() {
		return messageCost;
	}
	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}
	public double getNetworkCharge() {
		return networkCharge;
	}
	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

