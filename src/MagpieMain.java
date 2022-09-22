import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieMain {

	/**
	MAGPIE RUNNER 2
	 Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args){
		Magpie2 maggie = new Magpie2();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

	// /**
	// 	MAGPIE RUNNER 3
	//  Create a Magpie, give it user input, and print its replies.
	//  */
	// public static void main(String[] args)
	// {
	// 	Magpie3 maggie = new Magpie3();
		
	// 	System.out.println (maggie.getGreeting());
	// 	Scanner in = new Scanner (System.in);
	// 	String statement = in.nextLine();
		
	// 	while (!statement.equals("Bye"))
	// 	{
	// 		System.out.println (maggie.getResponse(statement));
	// 		statement = in.nextLine();
	// 	}
	// }

	// /**
	//  MAGPIE RUNNER 4
	//  * Create a Magpie, give it user input, and print its replies.
	//  */
	// public static void main(String[] args)
	// {
	// 	Magpie4 maggie = new Magpie4();
		
	// 	System.out.println (maggie.getGreeting());
	// 	Scanner in = new Scanner (System.in);
	// 	String statement = in.nextLine();
		
	// 	while (!statement.equals("Bye"))
	// 	{
	// 		System.out.println (maggie.getResponse(statement));
	// 		statement = in.nextLine();
	// 	}
	// }


	// /**
	// 	MAGPIE RUNNER 5
	//  * Create a Magpie, give it user input, and print its replies.
	//  */
	// public static void main(String[] args)
	// {
	// 	Magpie5 maggie = new Magpie5();
		
	// 	System.out.println (maggie.getGreeting());
	// 	Scanner in = new Scanner (System.in);
	// 	String statement = in.nextLine();
		
	// 	while (!statement.equals("Bye"))
	// 	{
	// 		System.out.println (maggie.getResponse(statement));
	// 		statement = in.nextLine();
	// 	}
	// }

}