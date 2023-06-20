public class MoneyHandler {
    private int[] denomList = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

    public MoneyHandler()
    {
        // constructor.
    }
    
    public int getTotal(int[] denomList)
    {
        int finalTotal = 0;
        for (int i = 0; i < denomList.length; i++){
            finalTotal += denomList[i];
        }

        return finalTotal;
    }

    public int getDenom(int denom){
        return denom;
    }

    public boolean addDenom(int denom, int amountToAdd) {
        if (denom + amountToAdd > 30)
            return false;
        else
        {
            denom += amountToAdd;
            return true;
        }
    }

    public boolean minusDenom(int denom, int amountToMinus) {
        if (denom - amountToMinus < 0)
            return false;
        else
        {
            denom -= amountToMinus;
            return true;
        }
    }
}