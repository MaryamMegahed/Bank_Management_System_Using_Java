import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class CopiedAccount {

	int customerID;
	int customerPasscode;
	String customerName;
	public double balance; 
	String previousTransaction;
	public	Boolean inDebt = false;
    LocalDateTime loanStartDate;
    double  number;
    double theRestTime;
    
    CopiedAccount (String custmorName , int customerID, int customerPasscode) {
    	this.customerName = custmorName ;
		this.customerID = customerID;
		this.customerPasscode=customerPasscode;
	}
 
    // for customers with initial balance
    CopiedAccount (String custmorName, int customerID , double balance,int customerPasscode) {
    	this.customerName = custmorName ;
		this.customerID = customerID;
		this.balance = balance;
		this.customerPasscode=customerPasscode;
	}
    
    public void setBalance(double balance) {
    	this.balance=balance;
    }
    public double getBalance() {
		return this.balance;
	}
    public String getname() {
 		return customerName;
 	}
    
	//Function for Depositing money
	void deposit(double amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = "Deposit";
			}
		}
 
	//Function for Withdrawing money
	void withdraw(double withdrawamount2) {
		if (this.getBalance() - withdrawamount2 < 0 && loanStartDate==null) {
			loanStartDate = LocalDateTime.now();
		}
		
		if((this.getBalance() - withdrawamount2 )<-20000) {
			JOptionPane.showMessageDialog(null, "Sorry !! you have extends the debt limits ..",
      		      "Hey!", JOptionPane.ERROR_MESSAGE);
		}
		else if(withdrawamount2>20000) {
			JOptionPane.showMessageDialog(null, "Sorry !! too much amount to withdraw ..",
	      		      "Hey!", JOptionPane.ERROR_MESSAGE);
		}
		else if (withdrawamount2 != 0) {
			int confirm=JOptionPane.showConfirmDialog( null, "Are You Sure You Want To Withdraw "+withdrawamount2+" From Your Account?",
			        "alert", JOptionPane.OK_CANCEL_OPTION);
			if(confirm==0){
			int confirm2=MyFrame.CurrentAccount.warningMessage(withdrawamount2);
			if(confirm2==0) 
			this.setBalance(  (long) (this.getBalance() - withdrawamount2));
			  JOptionPane.showMessageDialog(null, "Done successfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			  }
			previousTransaction = "Withdraw";
		}
	}
  //Function for Transferring money
	void trans (double amount , CopiedAccount account) {
		if( amount>0 && amount<200000){
			this.balance-=amount;
			account.balance+=amount;
			JOptionPane.showMessageDialog(null, "Done successfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
		else if(amount>=200000) {
			JOptionPane.showMessageDialog(null, "Sorry !! Too Much Amount to Transfer ..",
	      		      "Hey!", JOptionPane.ERROR_MESSAGE);
		}
		else if(amount==0) {
			JOptionPane.showMessageDialog(null, "Sorry !! You Can't Transfer 0 $.",
	      		      "Hey!", JOptionPane.ERROR_MESSAGE);
		}
		previousTransaction="Transfer";
	}
  
	//Used in the status method 
	String notInDept () {
		if(balance>=0) 
			loanStartDate=null;
		return ("You are not in debt ..\n Your balance is " + this.balance);
	}
	
	// Viewing if the customer is indebted or not and The time remaining for payment if indepted
	String Status () {
		notInDept();
		if(loanStartDate!=null) {
		LocalDateTime dateTime = LocalDateTime.now();
		double diff = ChronoUnit.MILLIS.between(loanStartDate, dateTime);
		int month;
		double day;
		if( diff>60000 )
			inDebt=true ;
		theRestTime= (60000- diff)/(30000);//every 1/2 minutes means 1 month //Time limit for payment = 1 minutes means 2 months
		month=(int)theRestTime;
		day= (theRestTime-month)*30;
		if(theRestTime>0){
		return ("Your Time Limit For Payment Is "+  month + " months and "+ (int)day + " days");
		}
		else 
			return(" You're Indebted With "+(-1*balance)+"$");
		}
		return notInDept ();
	}
	
	//Function showing the previous transaction
	 String getPreviousTransaction() {
		if(previousTransaction==null) {
			return ("No Previous Transaction.");
		}
		else
			return ("Your last Transaction is " +  previousTransaction);
	}
	
	int warningMessage(double withdrawamount2) {	
		if (this.balance-withdrawamount2<0) {
			int confirm=JOptionPane.showConfirmDialog( null, "Are You Sure You Want To Withdraw From Your Account? You Don't Have Enough Money.",
			        "alert", JOptionPane.OK_CANCEL_OPTION);
			return confirm;
			}
		else
			return 0;
	}

	//testing that the input is positive integer
	public static boolean isNumeric(String str){
		return str != null && str.matches("[0-9.]+");
	}		
	
	//converting the string input into integer
	public double testnum(String tested) {
	    number = Double.parseDouble(tested);
      return number;
	}
}
