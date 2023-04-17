package lab_1;
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
	
	public static void main(String args[]){
	    String strNum1, strNum2;
	    String strNotification="Youve just enter: ";
	    
	    strNum1=JOptionPane.showInputDialog(null, "Please input the first number: ","Input first number",JOptionPane.INFORMATION_MESSAGE);
	    strNotification+=strNum1+" and ";
	    strNum2=JOptionPane.showInputDialog(null, "Please input the second number: ","Input second number",JOptionPane.INFORMATION_MESSAGE);
	    strNotification+=strNum2;
	    
	    JOptionPane.showMessageDialog(null, strNotification,"Show two numbers",JOptionPane.INFORMATION_MESSAGE);
	;

	}

}
