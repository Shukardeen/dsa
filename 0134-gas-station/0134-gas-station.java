class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0;
        int totalCost = 0;

        int gasInTank = 0;
        int start = 0;

        for(int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            gasInTank += gas[i] - cost[i];

            if(gasInTank < 0) {
                gasInTank = 0;
                start = i+1;
            }
        }      

        return totalGas >= totalCost ? start : -1;  
    }
}