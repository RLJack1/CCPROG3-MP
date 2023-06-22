public class MoneyHandler {
    private int[] denomList = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    private int[] denomStore = {0, 0, 0, 0, 0, 0, 0, 0, 0}; // to hold amount of denom
    private int totalDenom; // Don't know if we still need this/

    // create method checkEnoughChange(change) to check if enough change from the totalParallel. (We probably don't need this anymore)

    public MoneyHandler()
    {
        // constructor.
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
    public int cashOne(int index, int numOfDenom){
        int totalCollect = 0;

        if (denomStore[index + 1] - numOfDenom < 0){
            totalCollect += denomStore[index + 1] * numOfDenom;
            denomStore[index + 1] -= numOfDenom;
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
            else
                return cashIn;
            
        }
        else
            return cashIn;

    }
    
    public int getTotal()
    {
        int finalTotal = 0;
        for (int i = 0; i < denomList.length; i++){
            finalTotal += denomList[i] * denomStore[i];
        }

        return finalTotal;
    }

    public int getDenom(int denom){
        return denom;
    }

    public int[] getChange(int[] availDenom){
        return availDenom;
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
}