import java.util.Scanner;

public class ETest11 {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a whole number (or quit to finish):");
		
		if (input.hasNextInt() != true) {
			System.out.println("Error: " + input.next() +  " is not a whole number.");
		}
		
		while (input.hasNextInt()) 
		{
			int inputInt = input.nextInt();
			System.out.print("The number " + inputInt + " is ");
			if (!isMagnanimous(inputInt)) 
			{
				System.out.print("NOT ");
			}
			System.out.print("a magnanimous number and is ");
			if (!isPetersonNumber(inputInt)) 
			{
				System.out.print("NOT ");
			}
			System.out.print("a Peterson number.\n");	
			System.out.println("Enter a whole number (or quit to finish):");
		}
		input.close();
	}
	
	public static boolean isPrime(int number)
	{
		if (number <= 1) 
		{
			return false;
		}
				
		for (int n = 2; n <= Math.sqrt(number); n++) 
		{
			if (number % n == 0) 
			{
				return false; 
			}
		}		
		return true;
	}
	
	public static boolean isMagnanimous(int number)
	{
		int digitCount = 0;
		int passedNumber = number;
		
		for (digitCount = 0; passedNumber > 0; digitCount++ ) 
		{
			passedNumber /=10;
		}
		
		if (digitCount >= 2)
		{	
			int numberA = 0;
	        int numberB = 0;
	        int operand = number;
	        
			for (int placeValue = 1; placeValue < digitCount; placeValue++) 
			{
				numberA = number / (int) Math.pow(10, digitCount-placeValue);
				numberB = number - (numberA * ((int) Math.pow(10,digitCount-placeValue)));
				if (!isPrime((numberA+numberB))) 
				{
					return false;
				}
				operand /= 10;	
			}
			return true;
		}
		return false;
	}
	
	public static int calculateFactorial(int number)
	{
		int factorial = 1;
		for (int multiplyer = 1; multiplyer <= number; multiplyer++) 
		{
			factorial *= multiplyer;
		}
		return factorial;
	}
	
	public static boolean isPetersonNumber(int number) 
	{
		int passedNumber = number;
		int digit = 0;
		int factorial = 0;
		int sumOfDigitFactorials = 0;
		for (int digitCount = 0; passedNumber > 0; digitCount++)
		{
			digit = passedNumber % 10;
			passedNumber /= 10;
			factorial = calculateFactorial(digit);
			sumOfDigitFactorials += factorial;
		}
		if (sumOfDigitFactorials == number)
		{
			return true;
		} else {
			return false;
		}
	}
}