package lab_1;

import javax.swing.JOptionPane;
public class code_2_5{
public static void main(String args[]){
    String strNum1, strNum2;
    
    strNum1=JOptionPane.showInputDialog(null, "Please input the first number","Input first number",JOptionPane.INFORMATION_MESSAGE);
    strNum2=JOptionPane.showInputDialog(null, "Please input the second number","Input first number",JOptionPane.INFORMATION_MESSAGE);
    
    double num1 = Double.parseDouble(strNum1);
    double num2 = Double.parseDouble(strNum2);
    double sum=num1+num2;
    double dif=num1-num2;
    double prod=num1 *num2;
    if(num2!=0) {
    double quot=num1/num2;
    JOptionPane.showMessageDialog(null, "Sum:" +sum+"\n"+ "Different:"+dif+"\n"+"Product:"+prod +"\n"+"Quotient"+quot+"\n");
    }
    else {
    	JOptionPane.showMessageDialog(null, "Sum:" +sum+"\n"+ "Different:"+dif+"\n"+"Product:"+prod +"\n"+"Quotient:No Quotient since the divisor is 0\n");
    }
    System.exit(0);


}
}