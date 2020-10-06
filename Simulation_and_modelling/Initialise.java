package SMTravelSimulation;

import simulationModelling.ScheduledAction;

public class Initialise extends ScheduledAction{
	
	


		SMTravel model;
		
		// Constructor
		protected Initialise(SMTravel model) { this.model = model; }
		
		double [] ts = { 0.0, -1.0 }; // -1.0 ends scheduling
		int tsix = 0;  // set index to first entry.
		protected double timeSequence() {
			return ts[tsix++];  // only invoked at t=0
		}
		
		public void actionEvent() {
			// System Initialization
			model.qCallLine.get(Constants.GOLD).clear();
	        model.qCallLine.get(Constants.SILVER).clear();
	        model.qCallLine.get(Constants.REGULAR).clear();

			model.rgOperator[Constants.GOLD].group.clear();
			model.rgOperator[Constants.SILVER].group.clear();
			model.rgOperator[Constants.REGULAR].group.clear();
		
			model.rgTrunkLine.list.clear();
			
			// Initialize the output variables
			model.output.numGoldCalls = 0;
			model.output.numSilverCalls = 0;
			model.output.numRegularCalls  = 0;
			model.output.num90SecGoldCalls = 0;
			model.output.num180SecSilverCalls = 0;
			model.output.num900SecRegularCalls = 0;
			model.output.numBusyCrdHCalls = 0;
			model.output.numBusyRegularCalls = 0;
			
			
		}

}
