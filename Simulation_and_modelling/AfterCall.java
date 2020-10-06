
package SMTravelSimulation;
import simulationModelling.SequelActivity;
/*
 * Sequel Activity AfterCall, represents the operator doing the after call work.
 */
public class AfterCall extends SequelActivity{
		
	SMTravel model;		// Access to the SMTravel model
	private Call icCall;
	private int operatorType;
	   
	// Constructor
	AfterCall(SMTravel model, Call icCall, int operatorType) {
		this.model = model;
		this.icCall = icCall;
		this.operatorType = operatorType;  
	}


	public void startingEvent(){
	    //No starting event
	}
		   
	protected double duration(){
		return model.rvp.uAftCallWrkTm(icCall.uSubject, operatorType);
	}
		   
	protected void terminatingEvent(){
		model.rgOperator[operatorType].numBusy -= 1;
		        
	}
}
