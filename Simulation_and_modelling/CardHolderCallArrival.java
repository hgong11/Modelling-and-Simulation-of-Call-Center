package SMTravelSimulation;
import simulationModelling.ScheduledAction;
/*
 * Scheduled Action CardHolderCallArrival 
 */
public class CardHolderCallArrival extends ScheduledAction {
	
	    SMTravel model; 	// Access to the SMTravel model
	    
	    // Constructor 
	    CardHolderCallArrival(SMTravel model) { this.model = model;}

	    @Override
	    public double timeSequence() {
	        return (model.rvp.DuCallCrd());
	    }

	    @Override
	    protected void actionEvent() {
	    	// Arrival Action Sequence SCS
	    	Call icCall = new Call();
	    	icCall = model.spDerive(icCall);  
	    	icCall.uType = model.rvp.uCuType();
	    	icCall.uSubject = model.rvp.uCaType();
	    	model.udp.UpdateNumArrivalsOutput(icCall);
	    	//If there is an available trunk line add the Call
	    	if(model.rgTrunkLine.n < model.rgTrunkLine.numLines) {
	    		model.spInsertGrp(model.rgTrunkLine, icCall);
	    		InputMemberNumber inputMNum = new InputMemberNumber(model, icCall);
	    		model.spStart(inputMNum);
	    	}
	    	else {
	    		// Call receives busy signal and leaves.
	    		model.udp.UpdateNumBusyOutput(icCall);
	    		model.spLeave(icCall);
	    	}
	    }	
}
