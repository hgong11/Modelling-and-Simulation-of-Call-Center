package SMTravelSimulation;
import simulationModelling.AOSimulationModel;
import simulationModelling.Behaviour;
import simulationModelling.SequelActivity;
import java.util.*;

// The Simulation Model Class
public class SMTravel extends AOSimulationModel{
	
	    protected boolean traceFlag;
    

/*----------------------Entity Data Structures--------------------------*/
	/* Group and Queue Entities */
		Operator[] rgOperator = new Operator[3];
		ArrayList<ArrayList<Call>> qCallLine = new ArrayList<ArrayList<Call>>(3);
		//protected ArrayList<Call> qCallLine = new ArrayList<Call>(); // Line
		TrunkLines rgTrunkLine;

	/* Input Variables */
		// Define any Independent Input Variables here
		
		// References to RVP and UDP objects
		protected RVPs rvp;  // Reference to rvp object - object created in constructor
		protected UDPs udp = new UDPs(this);

		// Output object
		protected Output output = new Output(this);
		// Output values - define the public methods that return values
		// required for experimentation.
		//The percentage of regular calls that exceeded the 900 second wait time.
		public double getPerc900SecRegularCalls(){
			 return output.get900();
		}
		//The  percentage of silver calls that exceeded the 180 second wait time.
		public double getPerc180SecSilverCalls(){
			 return output.get180();
		}
		//The percentage of gold calls that exceeded the 90 second wait time.
		public double getPerc90SecGoldCalls(){
			return output.get90();
		}
		//The percentage of card hold calls that receive busy signal.
		public double getPercBusyCrdHCalls(){
			return output.getbusycrd();
		}
		//The percentage of regular calls that receive a busy signal.
		public double getPercBusyRegularCalls(){
			return output.getbusyReg();
		}
		//Constructor + Initializes the model
		public SMTravel(double t0time, double tftime, int[][] schedule, int numTrunkLine,
           int numReservedLine, Seeds sd, boolean traceFlag) {
		
			// Tracing
			 this.traceFlag = traceFlag;
			// Initialize Parameters
			rgTrunkLine = new TrunkLines(numTrunkLine,numReservedLine);
			rgOperator[Constants.REGULAR] = new Operator(schedule[Constants.REGULAR]);
			rgOperator[Constants.SILVER] = new Operator(schedule[Constants.SILVER]);
			rgOperator[Constants.GOLD] = new Operator(schedule[Constants.GOLD]);
			qCallLine.add(Constants.REGULAR, new ArrayList<Call>());
			qCallLine.add(Constants.SILVER, new ArrayList<Call>());
			qCallLine.add(Constants.GOLD, new ArrayList<Call>());
			// Initialize classes
			// Create RVP object with given seed
			rvp = new RVPs(this, sd);		
            // rgCounter and qCustLine objects created in Initalise Action
			// Initialize the Simulation Model
			initAOSimulModel(t0time,tftime);
		    closingTime = tftime;
			// Schedule the first arrivals and employee scheduling
			Initialise init = new Initialise(this);
			scheduleAction(init);  // Should always be first one scheduled.
			StaffChange staffChange = new StaffChange(this);
			scheduleAction(staffChange);
			RegularCallArrival regularArrival = new RegularCallArrival(this);
			scheduleAction(regularArrival);
			CardHolderCallArrival cardholderArrival = new CardHolderCallArrival(this);
			scheduleAction(cardholderArrival);
	      
			// Schedule other scheduled actions and activities here

		}
	
/***************** Implementation of Data Modules ************/
	/*
	* Testing preconditions
	*/
	protected void testPreconditions(Behaviour behObj) {
		// Reschedule scheduled actions
		reschedule(behObj);
		//boolean statusChanged = false;
		
		// Check preconditions of Conditional Activities
		if (Service.precondition(this) == true) {
			Service act = new Service(this);
			act.startingEvent();
			scheduleActivity(act);
			//statusChange = true;
		}
		// Check preconditions of Interruptions in Extended Activities
		if (EstimateWaitTime.interruptionPreCond() == 1) {
			EstimateWaitTime act = new EstimateWaitTime(this);
			act.startingEvent();
			scheduleActivity(act);
			//statuChange = true;
		}
		
	//	return(statuChange);

	
	}
	public void eventOccured()
	{
//******************************************		
		//this.showSBL();
		// Can add other debug code to monitor the status of the system
		// See examples for suggestions on setup logging

		// Setup an updateTrjSequences() method in the Output class
		// and call here if you have Trajectory Sets
		// updateTrjSequences() 
//*********************************************
		if(traceFlag) {
            System.out.printf("Clock: %-9.3f RG.TrunkLines.n: %d\n",
                    getClock(), rgTrunkLine.n);
            System.out.printf("Q.CallLine[REGULAR].n: %d Q.CallLine[SILVER].n: %d Q.CallLine[GOLD].n %d\n",
                    qCallLine.get(Constants.REGULAR).size(),
                    qCallLine.get(Constants.SILVER).size(),
                    qCallLine.get(Constants.GOLD).size());
            System.out.printf("RG.Operator[REGULAR].n: %d\n",
                    rgOperator[Constants.REGULAR].n);
            System.out.printf("RG.Operator[SILVER].n:  %d\n",
                    rgOperator[Constants.SILVER].n);
            System.out.printf("RG.Operator[GOLD].n:    %d\n",
                    rgOperator[Constants.GOLD].n);
            this.showSBL();
		}
	}
	
	
	
	
	protected double closingTime; // closing time of the call center
	
	//Termination explicit
	public boolean implicitStopCondition() {
		boolean retVal = false;
		//System.out.println("ClosingTime = " + closingTime + "currentTime = "
		//		+ getClock() + "RG.TrunkLine.n = " + rgTrunkLine.n);
		if (getClock() >= closingTime && rgTrunkLine.n == 0)
			retVal = true;
		//System.out.println("implicit stop condition returns " + retVal);

		return (retVal);
	}
	
	
	    
//************** not sure about SPs *************************************************************//
	// For implementing the group, use a HashSet object.
		//protected HashSet<TrunkLines> group = new HashSet<TrunkLines>();

	// Standard Procedure to start Sequel Activities with no parameters
	//start the sequel activity
	public void spStart(SequelActivity seqAct){
		seqAct.startingEvent();
		scheduleActivity(seqAct);
	}
	public Call spDerive(Call icCall) {
		 return (icCall = new Call());
	}
	
	// Insert the call into the RG.TrunkLine
	public void spInsertGrp(TrunkLines rgTrunkLine, Call icCall) {
		//rgTrunkLine.add(icCall);
		rgTrunkLine.insertList(icCall);	
	}
	
	// remove object from group
	public void spRemoveGrp(TrunkLines rgTrunkLine, Call icCall) {
		rgTrunkLine.removeList(icCall);
		
	}
	// Insert object to queue
	
	// Leave
	public void spLeave(Call icCall) {
		rgTrunkLine.removeList(icCall);
		}
	
	// Terminate
	public void spTerminate() {
	}

}

