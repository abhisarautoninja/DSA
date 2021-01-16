/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

//fibonacci
class Solution {
    public int fib(int n) {
        if(n<=0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        return fib(n-1)+fib(n-2);
    }
}

// house robbers
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        
        if(nums.length==1){
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        
        return dp[nums.length-1];
    }
}


//climbing stairs
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n==1) return dp[1];
        dp[2] = 2;
        if(n==2) return dp[2];
        for(int i=3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}


//climbing stairs min const
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0]=cost[0];
        if(cost.length==0) return 0;
        dp[1] = cost[1];
        if(cost.length==1) return dp[1];
        for(int i=2;i<=cost.length;i++){
            dp[i] = i==cost.length ? Math.min(dp[i-2], dp[i-1]) : cost[i]+Math.min(dp[i-2], dp[i-1]);
            System.out.println("dp["+i+"] -> "+ dp[i]);
        }
        return dp[cost.length];
    }
}

