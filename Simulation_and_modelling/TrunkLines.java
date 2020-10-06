package SMTravelSimulation;

import java.util.HashSet;
/* 
 *  RG.TrunkLine Entity Category    
 */
public class TrunkLines {	
	// Attributes
	int n;    //The number of n being used
	protected HashSet<Call> list = new HashSet<Call>();  // maintains set of call objects, that is RG.TrunkLines.list
	protected int numLines; 	//The  total number of trunk lines
	protected int numReserved;  //The number of reserved lines
    //Constructor
	TrunkLines(int numLines, int numReserved){
		this.numLines = numLines;
		this.numReserved = numReserved;
		n = 0;
	}
	// Required methods to manipulate the group
	protected void insertList(Call icCall) {	
		list.add(icCall); 
		}
	protected boolean removeList(Call icCall) { 
		return(list.remove(icCall)); 
		}
	protected int getN() { 
		return list.size(); 
		}  // Attribute n

}
