
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

	private double limitingAmount;
	private double currentDebt=0;
	double paidMoney=0;
	Bill(double limitingAmount){
		this.limitingAmount=limitingAmount;
	}
	boolean check(double amount) {
		if(currentDebt+amount>limitingAmount) {
			return false;
		}
		else {
			return true;
		}
	}
	void add(double amount) {
		currentDebt+=amount;
	}
	void pay(double amount) {
		if(amount>=currentDebt) {
			paidMoney+=currentDebt;
			currentDebt=0;
		}
		else {
			paidMoney+=amount;
			currentDebt-=amount;
		}
	}
	void changeTheLimit(double amount) {
		if(amount>currentDebt) {
			this.limitingAmount=amount;
		}	
	}
	public double getLimitingAmount() {
		return limitingAmount;
	}
	
	public double getCurrentDebt() {
		return currentDebt;
	}

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

