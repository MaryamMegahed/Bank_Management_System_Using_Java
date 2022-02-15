import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class TheVip extends CopiedAccount {	
	
	TheVip(String custmorName, int customerID ,double  balance,int customerPasscode) {
		super(custmorName, customerID , balance,customerPasscode);
	}
	
	void deposit(long amount) {
		if (amount != 0 && amount<=1000000) {
			balance = balance + amount;
			previousTransaction = "Deposit";
			}
		}

	void withdraw(double withdrawamount2) {
		if (this.getBalance() - withdrawamount2 < 0 && loanStartDate==null) {
			loanStartDate = LocalDateTime.now();
		}
		if((this.getBalance() - withdrawamount2 )<-250000) {
			JOptionPane.showMessageDialog(null, "Sorry !! you have extends the debt limits ..",
      		      "Hey!", JOptionPane.ERROR_MESSAGE);
			}
		else if(withdrawamount2>250000) {
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

	void trans (double amount , CopiedAccount account) {
		if( amount>0 && amount<250000) {
			this.balance-=amount;
			account.balance+=amount;
			JOptionPane.showMessageDialog(null, "Done successfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(amount>=250000) {
				JOptionPane.showMessageDialog(null, "Sorry !! Too Much Amount to Transfer ..",
						"Hey!", JOptionPane.ERROR_MESSAGE);
			}
			previousTransaction="Transfer";
		}
	
	String Status () {
		notInDept();
		if(loanStartDate!=null) {
		LocalDateTime dateTime = LocalDateTime.now();
		double diff = ChronoUnit.MILLIS.between(loanStartDate, dateTime);
		int month;
		double day;
		if(diff> 300000 )
			inDebt=true ;
		theRestTime= (300000-  diff)/(30000);//every 1/2 min means 1 month //Time accepted = 1 mins means 2 months
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
}