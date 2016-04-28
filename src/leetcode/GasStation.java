public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainingCost  = 0;
        int total = 0;
        int start =0;
        int temp =0 ;
        for(int i=0 ;i<gas.length ;i++){
            temp = gas[i] - cost[i];
            remainingCost += temp;
            if(remainingCost < 0){
                start = i+1;
                remainingCost = 0;
            }
            total += temp;
        }
        if(total >= 0)
            return start;
        else
            return -1;
    }
}
