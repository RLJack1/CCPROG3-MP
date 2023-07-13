/*MAIN TASKS: clear files (done)
 *			: load files
 */

public class FileHandler {
	public FileHandler() {
	}
	
	/** 
	  * Clears all data of a file, given its filename
	  * @param filename The name of the file to be cleared
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
	public void clearFile(String filename) throws FileNotFoundException {
        try {
			PrintWriter p = new PrintWriter(filename);
            p.close();
			System.out.println("File cleared: " + filename);
        } catch (IOException e) {
			System.out.println("Error clearing: " + filename);
            e.printStackTrace();
        }
	}
}