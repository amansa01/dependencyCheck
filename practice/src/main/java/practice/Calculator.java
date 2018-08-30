package practice;

public class Calculator {

	public static void main(String[] args){
		int result;
		 int num1=10;
		int num2=5;
		result=addition(num1, num2);
		int result2 = subtraction( num1, num2);
	}
	
	public static int addition(int num1 ,int num2){
		return num1+num2;
	}
	
	private static int subtraction(int num1 ,int num2){
		return num1-num2;
	}
}
