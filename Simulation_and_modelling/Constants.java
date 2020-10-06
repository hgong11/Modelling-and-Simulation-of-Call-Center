package SMTravelSimulation;
/* 
 * Constants 
 */
public class Constants {
	  
	// Example: protected final static double realConstant = 8.0;
	// Define constants as static
	final static int REGULAR = 0;			    // Identifier for regular operators.   
	final static int SILVER = 1;			    // Identifier for silver operators.
	final static int GOLD = 2;				    // Identifier for gold operators.
	final static double EWTVOICEDURATION = 8.0;	// Wait time duration for the voice in the phone to estimate the expected wait time
	final static double EWTDURATION = 240.0; 	// Pessimistic wait time for a customer to be serviced.

    final static int INFO = 0; 			// Identifier for Information call type
    final static int RSRVN = 1; 		// Identifier for Reservation call type
    final static int CHNG = 2;  		// Identifier for Change call type
    final static String[] CUSTOMERTYPE = {"REGULAR", "SILVER", "GOLD"}; 		// Customer Type (Regular, Silver or Gold)
    final static String[] CALLTYPE = {"INFO", "RSRVN" , "CHNG"};  		// Call Type (Information, Reserving or Changing)
	
    
	// this numbers come from the project goal but seconds converted to minues, the first 3 of five,.
    final static double[] LONG_WAIT_THRESHOLD = {
            15,  //REGULAR
            3,   //SILVER
            1.5  //GOLD
    };

}
