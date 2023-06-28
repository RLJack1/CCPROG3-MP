import java.util.Scanner;

/** 
  * Stores and operates on all money inside the vending machine.
  */
public class MoneyHandler {
    private int[] denomList = {1000, 500, 200, 100, 50, 20, 10, 5, 1}; // int array to hold denomination values.
    private int[] denomStore = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] userDenom = {0, 0, 0, 0, 0, 0, 0, 0, 0};
     // int array to hold how many denominations are stored.
	
	/** 
      * A constructor that creates an instance of the MoneyHandler object.
      */
    public MoneyHandler() {
    }

    // TODO: displayDenomList() to print the contents of denomList. DONE
    public void displayDenomList(){
        for (int i = 0; i < denomStore.length; i++){
            System.out.println("P" + denomList[i] + ": " + denomStore[i] + " stored.");
        }
    }

    //TODO: inputDenominations() to store user input denominations into the machine. DONE
    public void inputDenominations(Scanner s) {
        int totalUser = 0;
        try { 
            System.out.println("Enter the denominations separated by spaces:");
            
            String inputLine = s.nextLine();
            String[] denominations = inputLine.split(" ");

            for (int i = 0; i < denominations.length; i++) {
                switch(Integer.parseInt(denominations[i])){
                    case 1000 -> userDenom[0]++;
                    case 500 -> userDenom[1]++;
                    case 200 -> userDenom[2]++;
                    case 100 -> userDenom[3]++;
                    case 50 -> userDenom[4]++;
                    case 20 -> userDenom[5]++;
                    case 10 -> userDenom[6]++;
                    case 5 -> userDenom[7]++;
                    case 1 -> userDenom[8]++;
                    default -> System.out.println("Denomination not recognized, skipping input...");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < userDenom.length; i++) {
            totalUser += userDenom[i] * denomList[i];
        }

        System.out.println("You've inserted " + totalUser + " worth of money.");
        System.out.println("Denominations inputted successfully!");
    }


    // TODO: checkEnoughChange(cashIn, itemPrice) logic checks if there is enough change in the VM to dispense change. DONE
    public boolean checkEnoughChange(int cashIn, int itemPrice){
        int totalChange = 0;
        boolean isEnoughChange = false;

        for (int i = 0; i < denomStore.length; i++){
            totalChange += denomList[i] * denomStore[i];
        }
       
        if (totalChange >= cashIn)
            isEnoughChange = true;

        return isEnoughChange;
    }

    // TODO: cashOut(totalDenom) to take out all money from the vending machine. (presumably also store and return how much money was collected, so return int) DONE
    public boolean cashOut(){
		boolean result = false;

        for (int i = 0; i < denomStore.length; i++){
            denomStore[i] -= denomStore[i];
            result = true;
        }

        return result;
    }
    
    // TODO: create method cashOne(index, numOfDenom) to take out and return a specified denom and number from the vending machine. DONE
    public boolean cashOne(int denomination, int numOfDenom){
        int index = 0;
		boolean result = false;

        for(int i = 0; i < denomList.length; i++){ 
            if (denomList[i] == denomination){
                index = i;
            }
        }
        if (denomStore[index] - numOfDenom >= 0){
            denomStore[index] -= numOfDenom;
            result = true;
        }

        return result;
    }

    /* TODO: create method splitDenom(cashIn) to split inputted cash into denominations and store them into the vending machine. DONE
    public void splitDenom(int cashIn)
    { // @megan i feel like this won't be needed anymore since cash is inputed seperately by bills
        for(int i = 0; i < denomStore.length; i++){
            if (cashIn >= denomList[i]){
                denomStore[i] = cashIn / denomList[i];
                cashIn %= denomList[i];
            }
        }
    }*/

    // TODO: create method refillOne(index, denomAdd) to replenish a specified denom given their number. DONE
    public void refillOne(int denomination, int denomAdd){
        switch(denomination){
            case 1000 -> denomStore[0] += denomAdd;
            case 500 -> denomStore[1] += denomAdd;
            case 200 -> denomStore[2] += denomAdd;
            case 100 -> denomStore[3] += denomAdd;
            case 50 -> denomStore[4] += denomAdd;
            case 20 -> denomStore[5] += denomAdd;
            case 10 -> denomStore[6] += denomAdd;
            case 5 -> denomStore[7]+= denomAdd;
            case 1 -> denomStore[8] += denomAdd;
        }
    }

    public void initialMoneys(){
        for(int i = 0; i < 9; i++){ 
            denomStore[i] += 25;
        }
    }

    public void changeHelper(boolean doesChange){
        if(doesChange == true){
            for(int i = 0; i < denomStore.length; i++){
                denomStore[i] += userDenom[i];
            }
        }
        else{
            for(int i = 0; i < denomStore.length; i++){
                denomStore[i] -= userDenom[i];
            }
        }
    }

    // TODO: create method for change(cashIn, productPrice)  to loop thru each denom. should also return money if transaction is unsuccessful. DONE.
    public boolean checkChange(int cashIn, int productPrice){
        boolean enoughChange = false;
        int changeOut = cashIn - productPrice;
        int tempStore[] = {}; 
        int totalChange = 0, i;
        int toChange = 0; 

        for (i = 0; i < 9; i++){
            totalChange += denomList[i] * denomStore[i]; 
        }

        for (i = 0; i < 9; i++){
            tempStore[i] += denomStore[i] + userDenom[i];
        }

        if (totalChange >= changeOut){
            for(i = 0; i < 9; i++){ 
                if (changeOut >= denomList[i]){ 
                    tempStore[i] = changeOut / denomList[i];
                    changeOut %= denomList[i] * tempStore[i]; 
                }
            }
            //boolean changeSuccess = changeOut == 0;
            if(changeOut == 0){
                enoughChange = true;

                for(i = 0; i < denomStore.length; i++){
                    denomStore[i] += userDenom[i];
                    userDenom[i] = 0;
                    denomStore[i] -= tempStore[i];
                }

                return enoughChange;
            }
            else{
                System.out.println("Sorry! This Vending Machine doesn't have enough change to dispense :((");
                return enoughChange;
            }
        }
        else{
            System.out.println("Canceling order...");
		    System.out.println("Returning money...");
            return enoughChange;
        }
    }

    // public int checkChange(int cashIn, int productPrice){
    //     int changeOut = cashIn - productPrice;
    //     int countDenom[] = denomStore;
    //     int totalChange = 0, i;

    //     for (i = 0; i < denomStore.length; i++){
    //         totalChange += denomList[i] * denomStore[i];
    //     }

    //     if (totalChange >= changeOut){
    //         for(i = 0; i < denomStore.length; i++){
    //             if (changeOut >= denomList[i]){
    //                 countDenom[i] = changeOut / denomList[i];
    //                 changeOut %= denomList[i];
    //             }
    //         }

    //         boolean changeSuccess = changeOut == 0;

    //         if(changeSuccess){
    //             for(i = 0; i < denomStore.length; i++){
    //                 denomStore[i] -= countDenom[i];
    //             }

    //             return changeOut;
    //         }
    //         else{
    //             System.out.println("Sorry! This Vending Machine doesn't have enough change to dispense :((");
    //             return cashIn;
    //         }
    //     }
    //     else{
    //         System.out.println("Canceling order...");
	// 	    System.out.println("Returning money...");
    //         return cashIn;
    //     }
    // }
    
    public int getTotal()
    {
        int finalTotal = 0;
        for (int i = 0; i < denomList.length; i++){
            finalTotal += denomList[i] * denomStore[i];
        }

        return finalTotal;
    }

    public int getIndex(int denomValue){
        int index = 0;
        for (int i = 0; i < denomList.length; i++){
            if (denomValue == denomList[i]){
                index = i;
            }
        }
        return index;
    }

    public int[] getChange(int[] availDenom){
        return availDenom;
    }
}