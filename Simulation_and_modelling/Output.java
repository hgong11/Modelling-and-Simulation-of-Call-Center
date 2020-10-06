package SMTravelSimulation;
/*
 * Outputs
 */
public class Output {
	
		SMTravel model;

//	      ZIBO MENG	
		
		protected Output(SMTravel md) {model = md; }
	    // Use OutputSequence class to define Trajectory and Sample Sequences
	    // Trajectory Sequences

	    // Sample Sequences

	    // DSOVs available in the OutputSequence objects
	    // If separate methods required to process Trajectory or Sample
	    // Sequences - add them here

	    // SSOVs
		int numGoldCalls = 0 ; 			//The number of gold calls that call the SM Travel center.
		int num90SecGoldCalls = 0 ; 		//The number of gold calls that exceeded the 90 second wait time.
		int numSilverCalls = 0; 		//The number of silver calls that enter the SM Travel system.
		int num180SecSilverCalls = 0; 	//The number of silver calls that exceeded the 180 second wait time.
		int numRegularCalls = 0; 		//The number of regular calls that enter the SM Travel system.
		int num900SecRegularCalls = 0;  //The number of regular calls that exceeded the 900 second wait time.
		
		int numBusyCrdHCalls= 0 ;  		//The number of gold/silver calls that receive a busy signal.
		int numCardHArrivalCalls= 0 ;  	//The number of card hold calls that arrived at the very start of the system.
		int numBusyRegularCalls= 0 ; 	//The number of regular calls that receive a busy signal.
		int numRegularArrivalCalls= 0; //The number of regular calls that arrived at the very start of the system.
		
		public double get900(){
			if(numRegularCalls==0) return 0.0;
			else return (double)num900SecRegularCalls/(double)numRegularCalls;
		}
		public double get180(){
			if(numSilverCalls==0) return 0.0;
			else return (double)num180SecSilverCalls/(double)numSilverCalls;
		}
		public double get90(){
			if(numGoldCalls==0) return 0.0;
			else return (double)num90SecGoldCalls/(double)numGoldCalls;
		}
		public double getbusycrd(){
			if(numGoldCalls==0&&numSilverCalls==0) return 0.0;
			else return (double)numBusyCrdHCalls /(double)(numGoldCalls+numSilverCalls);
		}
		public double getbusyReg(){
			if(numRegularArrivalCalls==0) return 0.0;
			else return (double)numBusyRegularCalls /(double)(numRegularArrivalCalls);
		}

		
		//remember to design a print method in simulation part

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	public double getPerc900SecRegularCalls() {
			if(num900SecRegularCalls > 0)
				perc900SecRegularCalls =  numRegularCalls/num900SecRegularCalls;  	//The percentage of regular calls that exceeded the 900 second wait time.
			return perc900SecRegularCalls;
		}
		public double getPerc180SecSilverCalls() {
			if (numSilverCalls > 0)
				perc180SecSilverCalls = num180SecSilverCalls / numSilverCalls; 		//The percentage of silver calls that exceeded the 180 second wait time.
			return perc180SecSilverCalls;
		}
		public double getPerc90SecGoldCalls() {
			if (numGoldCalls > 0)
				perc90SecGoldCalls =  num90SecGoldCalls / numGoldCalls; 				//The percentage of gold calls that exceeded the 90 second wait time.
			return perc90SecGoldCalls;
		}
		public double getPercBusyCrdHCalls() {
			if ((numGoldCalls+numSilverCalls) > 0)
				percBusyCrdHCalls = numBusyCrdHCalls / (numGoldCalls+numSilverCalls);//The percentage of card hold calls that receive busy signal.
			return percBusyCrdHCalls;
		}
		public double getPercBusyRegularCalls() {
			if (numRegularArrivalCalls > 0)
				percBusyRegularCalls = numBusyRegularCalls / numRegularArrivalCalls; //The percentage of regular calls that receive a busy signal.
			return percBusyRegularCalls;
		}
		//remember to design a print method in simulation part
*/
