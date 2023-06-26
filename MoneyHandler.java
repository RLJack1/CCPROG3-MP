import java.util.Scanner;

public class MoneyHandler {
    private int[] denomList = {1000, 500, 200, 100, 50, 20, 10, 5, 1}; // int array to hold denomination values.
    private int[] denomStore = {0, 0, 0, 0, 0, 0, 0, 0, 0}; // int array to hold how many denominations are stored.
    //private int totalDenom; @megan what's this for again huhuhuh

    public MoneyHandler()
    {
        // constructor.
    }

    // TODO: displayDenomList() to print the contents of denomList. DONE
    public void displayDenomList(){
        for (int i = 0; i < denomStore.length; i++){
            System.out.println("P" + denomList[i] + ": " + denomStore[i] + "instances.");
        }
    }

    //TODO: inputDenominations() to store user input denominations into the machine. DONE
    public void inputDenominations() {
        try (Scanner scanner = new Scanner(System.in)) { //@megan inputted try-catch based on VSC prompt
            System.out.println("Enter the denominations separated by spaces:");

            String inputLine = scanner.nextLine();
            String[] denominations = inputLine.split(" ");

            for (int i = 0; i < denominations.length; i++) {
                switch(Integer.parseInt(denominations[i])){
                    case 1000 -> denomStore[0]++;
                    case 500 -> denomStore[1]++;
                    case 200 -> denomStore[2]++;
                    case 100 -> denomStore[3]++;
                    case 50 -> denomStore[4]++;
                    case 20 -> denomStore[5]++;
                    case 10 -> denomStore[6]++;
                    case 5 -> denomStore[7]++;
                    case 1 -> denomStore[8]++;
                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
    public int cashOut(){
        int totalCollect = 0;

        for (int i = 0; i < denomStore.length; i++){
            totalCollect += denomList[i] * denomStore[i];
            denomStore[i] -= denomStore[i];
        }

        return totalCollect;
    }
    
    // TODO: create method cashOne(index, numOfDenom) to take out and return a specified denom and number from the vending machine. DONE
    public int cashOne(int denomination, int numOfDenom){
        int totalCollect = 0;
        int index = 0;

        for(int i = 0; i < denomList.length; i++){ 
            if (denomList[i] == denomination){
                index = i;
            }
        }

        if (denomStore[index] - numOfDenom >= 0){
            totalCollect += denomStore[index] * numOfDenom;
            denomStore[index] -= numOfDenom;
        }

        return totalCollect;
    }

    // TODO: create method splitDenom(cashIn) to split inputted cash into denominations and store them into the vending machine. DONE
    public void splitDenom(int cashIn)
    {
        for(int i = 0; i < denomStore.length; i++){
            if (cashIn >= denomList[i]){
                denomStore[i] = cashIn / denomList[i];
                cashIn %= denomList[i];
            }
        }
    }

    // TODO: create method refillOne(index, denomAdd) to replenish a specified denom given their number. DONE
    public void refillOne(int index, int denomAdd){
        denomStore[index + 1] += denomAdd;
    }

    // TODO: create method for change(cashIn, productPrice)  to loop thru each denom. should also return money if transaction is unsuccessful. DONE.
    public int checkChange(int cashIn, int productPrice){
        int changeOut = cashIn - productPrice;
        int countDenom[] = denomStore;
        int totalChange = 0, i;

        for (i = 0; i < denomStore.length; i++){
            totalChange += denomList[i] * denomStore[i];
        }

        if (totalChange >= changeOut){
            for(i = 0; i < denomStore.length; i++){
                if (changeOut >= denomList[i]){
                    countDenom[i] = changeOut / denomList[i];
                    changeOut %= denomList[i];
                }
            }

            boolean changeSuccess = changeOut == 0;

            if(changeSuccess){
                for(i = 0; i < denomStore.length; i++){
                    denomStore[i] -= countDenom[i];
                }

                return changeOut;
            }
            else{
                System.out.println("Sorry! This Vending Machine doesn't have enough change to dispense :((");
                return cashIn;
            }
        }
        else{
            System.out.println("Canceling order...");
		    System.out.println("Returning money...");
            return cashIn;
        }
    }
    
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
    // I removed the following methods because their processes can be done by the new methods.

    // public boolean addDenom(int denom, int amountToAdd) {
    //     if (denom + amountToAdd > 30)
    //         return false;
    //     else
    //     {
    //         denom += amountToAdd;
    //         return true;
    //     }
    // }

    // public boolean minusDenom(int denom, int amountToMinus) {
    //     if (denom - amountToMinus < 0)
    //         return false;
    //     else
    //     {
    //         denom -= amountToMinus;
    //         return true;
    //     }
    // }
