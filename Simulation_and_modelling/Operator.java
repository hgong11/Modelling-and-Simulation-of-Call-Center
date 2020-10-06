package SMTravelSimulation;
import java.util.ArrayList;
import java.util.HashSet;
/* 
 *  RG.Operator[3] Entity Category    
 */
public class Operator {
	
	// Attributes
	int n; 	//The number of entities in the list, n (maximum values is uNumOperators)
	//ArrayList<Operator> list = new ArrayList<Operator>();  	// List of operator objects that can service a call
	// For implementing the group, use a HashSet object.
	protected HashSet<Operator> group = new HashSet<Operator>(); // RG.Operator[].list
	int uNumOperators; 	//The total number of operators within a day
	int numBusy; 	//The assigned value represents the number of operators that are busy

	int[] uShift; 	//The number of operators starting at each shift
	Operator(int[] uShift){
		this.uShift = uShift; 
	}
	protected enum operatorType {REGULAR, SILVER, GOLD};   //Type of operators
	protected operatorType uOperatorType;
	int operatorID; // *** what is the use???? **/////
	
	protected int getN() { return group.size(); }  // Attribute n
	
	// are these needed?
	/******
	// Required methods to manipulate the group, standard procedures
	protected void insertGrp(Operator icCall) {	group.add(icCall); }
	protected boolean removeGrp(Call icCall) { return(group.remove(icCall)); }
	
	*****//////
}
