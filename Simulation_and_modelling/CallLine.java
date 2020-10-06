package SMTravelSimulation;
import java.util.ArrayList;
//import java.util.Queue;
/* 
 * Q.CallLine[3] The Queue entity category with three queues for three types of customers   
 */ 
public class CallLine {

	int n; 		//The number of entities in the list, n
	// Implement the queue using an ArrayList object
	private ArrayList<Call> callLine = new ArrayList<Call>();  	// List of call objects waiting to be served (order: FIFO)
	static CallLine[] qCallLine = new CallLine[3]; // Three Queues for REGULAR, SILVER and GOLD calls
	//protected enum callLineType {REGULAR, SILVER, GOLD};   //Type of call Lines
	//protected callLineType uCallLineType;

	// getters/setters and standard procedures
	protected int getN() { return(callLine.size()); }
	protected void spInsertQue(Call icCall) { callLine.add(icCall); }
	protected Call spRemoveQue(Call icCall) //parameter??****
	{ 
		if(callLine.size() != 0) icCall = callLine.remove(0);
		return(icCall);
	}
	}


