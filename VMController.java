import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

/** 
  * Makes the initial function calls to start the interaction of classes.
  */
public class Driver {
	private VendingMachine vm;
	
	/** 
      * A constructor that creates an instance of the Driver object.
      */
	public Driver() {
	}
	
	/** 
      * The main method of the program
	  * @param args Stores Java command-line arguments
      */
	public static void main(String[] args) {
		Driver driver = new Driver ();
		VendingMachine vm = new VendingMachine();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Loading Vending Machine...");
			
		try {
			vm.populateVMHistory();
			System.out.println("Done!");
		} catch (FileNotFoundException e) {
			System.out.println("Oops! An error occurred.");
			e.printStackTrace();
		}
		
		try {
			vm.displayMenu(vm, s); 
			System.out.println("Saving Vending Machine data...");
			vm.writeVMHistory();
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }
		
		s.close();
	}
}