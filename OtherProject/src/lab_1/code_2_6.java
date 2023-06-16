package lab_1;

import javax.swing.JOptionPane;
import java.lang.Math;
public class code_2_6 {
    
    public static void main(String args[]){
        String stropt;
        stropt=JOptionPane.showInputDialog(null, "Please input option number to solve:\n "
        +"1:first-degree equation with one variable\n"+"2:first-degree equation with two variable\n"+
        "3:second-degree equation with one variable",JOptionPane.INFORMATION_MESSAGE);
        int opt = Integer.parseInt(stropt);
        switch (opt){
            case 1:
            String stra,strb;
            stra=JOptionPane.showInputDialog("Enter coefficient a:",JOptionPane.INFORMATION_MESSAGE);
            strb=JOptionPane.showInputDialog("Enter coefficient b:",JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(stra);
            double b = Double.parseDouble(strb);
            double x=-b/a;
            JOptionPane.showMessageDialog(null,"Root x="+x);
            break;
            case 2:
            String stra11,stra12,strb1,stra21,stra22,strb2;
            stra11=JOptionPane.showInputDialog("Enter coefficient a11:",JOptionPane.INFORMATION_MESSAGE);
            stra12=JOptionPane.showInputDialog("Enter coefficient a12:",JOptionPane.INFORMATION_MESSAGE);
            strb1=JOptionPane.showInputDialog("Enter coefficient b1:",JOptionPane.INFORMATION_MESSAGE);
            stra21=JOptionPane.showInputDialog("Enter coefficient a21:",JOptionPane.INFORMATION_MESSAGE);
            stra22=JOptionPane.showInputDialog("Enter coefficient a22:",JOptionPane.INFORMATION_MESSAGE);
            strb2=JOptionPane.showInputDialog("Enter coefficient b2:",JOptionPane.INFORMATION_MESSAGE);
            double a11 = Double.parseDouble(stra11);
            double a12 = Double.parseDouble(stra12);
            double a21 = Double.parseDouble(stra21);
            double a22 = Double.parseDouble(stra22);
            double b1 = Double.parseDouble(strb1);
            double b2 = Double.parseDouble(strb2);
            double d1=b1*a22-b2*a12;
            double d2=b1*a21-b2*a11;
            double d=a11*a22-a21*a12;
            if(d==0){
                if(d1!=0) JOptionPane.showMessageDialog(null, "No solution");
                else JOptionPane.showMessageDialog(null,"Infinite solution");

            }
            else{
                double x1=d1/d;
                double x2=-d2/d;
                JOptionPane.showMessageDialog(null, "X1="+x1+"; X2="+x2);

            }
            break;
            case 3:
            String strc;
            stra=JOptionPane.showInputDialog("Enter coefficient a:",JOptionPane.INFORMATION_MESSAGE);
            strb=JOptionPane.showInputDialog("Enter coefficient b:",JOptionPane.INFORMATION_MESSAGE);
            strc=JOptionPane.showInputDialog("Enter coefficient c:",JOptionPane.INFORMATION_MESSAGE);
            a = Double.parseDouble(stra);
            b = Double.parseDouble(strb);
            double c= Double.parseDouble(strc);
            if (a==0)  {JOptionPane.showMessageDialog(null,"error: a can not have value 0");break;}
            d=b*b-4*a*c;
            if(d==0){
                x=-b/(2*a);
                JOptionPane.showMessageDialog(null,"Double root:x= "+x);
            }
            else if(d<0) JOptionPane.showMessageDialog(null,"No solution");
            else  {
                double X1=(-b+Math.sqrt(d))/(2*a);
                double X2=(-b-Math.sqrt(d))/(2*a);

                JOptionPane.showMessageDialog(null,"2 root:x1="+X1+"; x2="+X2);}
            break;
            
            default: JOptionPane.showMessageDialog(null,"error");
            
            System.exit(0);

        }

        



    }
    
}
