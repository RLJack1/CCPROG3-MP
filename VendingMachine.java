import java.util.ArrayList;

public class VendingMachine{
    private int userChoice;
    private String machineName;
    private boolean machineType;
    public ArrayList <Item> itemList;
    public int denomList[] = {1000, 500, 200, 100, 50, 20, 10, 5 ,1};

    public void createVM(String machineName, boolean machineType){
        this.machineName = machineName;
        this.machineType = machineType;
    }

    public void maintainMode(){

    }

    public void testMode(){

    }

    public void exit(){

    }
}
