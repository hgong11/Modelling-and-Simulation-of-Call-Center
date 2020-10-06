package SMTravelSimulation;
/*
 * Call Entities Class 
 */
public class Call {
	
     uCuType cuType;
	 int uType;
	 int uSubject;
	 enum CallType {RSRVN, INFO, CHNGN};   //Type of calls
	 enum uCuType {REGULAR, SILVER, GOLD};   //Type of customers
     double startWaitTime;  // Time the Call arrives 
     double waitTime; // Total wait Time of the Call 
}
