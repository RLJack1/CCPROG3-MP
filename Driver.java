public class Driver {
	private VendingMachine vm;
	
	public Driver() {
		
	}
	
	public static void main(String[] args) {
		Driver driver = new Driver ();
		this.vm = new VendingMachine();
		
		System.out.println("Loading Vending Machine...");
			
		try {
			vm.populateVMHistory();
			System.out.println("Done!");
		} catch (FileNotFoundException e) {
			System.out.println("Oops! An error occurred.");
			e.printStackTrace();
		}
		
		vm.displayMenu(vm); 
		vm.clearFile("VM-History.txt");
		vm.saveToFile("VM-History.txt");
	}
}