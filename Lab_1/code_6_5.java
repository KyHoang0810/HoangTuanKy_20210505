package lab_1;
import java.util.Scanner;
import java.util.Arrays; 
public class code_6_5 {
	public static void main(String args[]) {
		Scanner kb= new Scanner(System.in);
		double sum = 0 ;double average;
		System.out.println("Enter number of element in the array");
		int n=kb.nextInt();
		double a[]=new double [n];
		System.out.println("Enter all the elements:");
        for(int i = 0; i < n ; i++)
        {
            a[i] = kb.nextDouble();
            sum = sum + a[i];
        }
        
        average=sum/n;
        System.out.println("Original numeric array : "+Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Sorted numeric array : "+Arrays.toString(a));
        System.out.println("Sum: "+sum);
        System.out.println("Average: "+average);
        kb.close();
	}

}
