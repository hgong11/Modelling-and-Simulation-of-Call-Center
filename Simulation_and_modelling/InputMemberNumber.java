package SMTravelSimulation;
import simulationModelling.SequelActivity;
/*
 * Sequel Activity InputMemberNumber, represents the Call entity entering the member number.
 */
public class InputMemberNumber extends SequelActivity{
	
	    SMTravel model;		// Access to the SMTravel model
	    private Call icCall;
	    
	    // Constructor
	    InputMemberNumber(SMTravel model, Call icCall) {
	        this.model = model;
	        this.icCall = icCall;
	    }


		public void startingEvent(){
	        icCall.uCuType = model.rvp.uCuType();
	    }
	   
	    protected double duration(){
	        return model.rvp.uIMNDuration();
	    }
	   
	    protected void terminatingEvent(){
	    	
	    	EstimateWaitTime estWTime = new EstimateWaitTime(model, icCall);
			model.spStartSequel(estWTime);
	        
	    }
}


