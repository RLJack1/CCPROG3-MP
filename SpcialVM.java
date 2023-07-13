/*MAIN TASKS: contains additional attributes to VM  (food type, recipelist and numIngredients each, available preset recipes)
 *			: getters and setters
 */

public class SpecialVM extends VendingMachine {
	private String delicacy;
	private 
	
	public SpecialVM(String delicacy, String machineName, int totalSales, int lastTotalSales) {
		this.delicacy = delicacy;
		super(machineName, totalSales, lastTotalSales);
	}
	
	
	
	public getDelicacy() {
		return this.delicacy;
	}
}