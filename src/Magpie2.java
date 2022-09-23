/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";

		if (statement.indexOf("no ") >= 0 || statement.indexOf("No ") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("Sun") >= 0 || statement.indexOf("sun") >= 0) {
			response = "The sun is very hot.";
	    } else if (statement.trim().length() == 0) {
	    	response = "Say something, please.";
	    } else if(statement.indexOf("Cat")>= 0 || statement.indexOf("cat")>=0||statement.indexOf("pet")>=0||statement.indexOf("Pet")>=0||statement.indexOf("Dog")>=0||statement.indexOf("dog")>=0){
			response = "I have a cat, its name it Jumbo";
		} else if(statement.indexOf("yin ")>=0||statement.indexOf("Yin ")>=0){
			response = "You should be nicer to Mr. Yin";
		} else if(statement.indexOf("iphone")>=0||statement.indexOf("iPhone")>=0||statement.indexOf("IPhone")>=0||statement.indexOf("Iphone")>=0){
			response = "iPhones are worse than androids";
		} else if(statement.indexOf("bot")>=0||statement.indexOf("Bot")>=0){
			response = "I'm not a chatbot, how dare you substantiate that I might be!";
		} else if(statement.indexOf("pda")>=0||statement.indexOf("PDA")>=0||statement.indexOf("Palm")>=0||statement.indexOf("palm")>=0){
			response="I like PDA's.";
		}
		else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 8;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			 response = "The squirel can surive falling from terminal velocity.";
		} else if (whichResponse == 5) {
			response = "You should go give Alex Miranda five dollars.";
		} else if (whichResponse == 6){
			response = "There are 48 regular Polyhedra";
		} else if (whichResponse == 7){
			response = "You should listen to Legaly Blonde: The Musical";
		}
		return response;
	}
}