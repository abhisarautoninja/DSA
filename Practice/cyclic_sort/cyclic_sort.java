/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

//missing numbers
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[j-1]) {
                int temp = nums[i];
                nums[i] = nums[j-1];
                nums[temp-1] = temp;
            } else {
                i++;
            }
        }
        for (int m = 0; m < nums.length; m++) {
            if (nums[m] != m+1) {
                return m+1;
            }
        }
        return nums.length+1;
    }
}

//duplicate number
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[j-1]) {
                int temp = nums[i];
                nums[i] = nums[j-1];
                nums[temp-1] = temp;
            } else {
                i++;
            }
        }
        return nums[nums.length-1];
    }
}

// first missing positive
class Solution {
    public int firstMissingPositive(int[] nums) {
        // method 1
        // int countNeg = 0, min = Integer.MAX_VALUE;
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]<0){
        //         countNeg++;
        //     }
        //     if(nums[i]>=0 ){
        //         if(min>nums[i])
        //             min = nums[i];
        //         map.put(nums[i], 1);
        //     }
        // }
        // if(min>1){
        //     return 1;
        // }
        // for(int i=min+1;i<(min+nums.length-countNeg);i++){
        //     if(!map.containsKey(i)){
        //         return i;
        //     }
        // }
        // return min+nums.length-countNeg;
        
        //method 2
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[j-1]) {
                int temp = nums[i];
                nums[i] = nums[j-1];
                nums[temp-1] = temp;
            } else {
                i++;
            }
        }
        for (int m = 0; m < nums.length; m++) {
            if (nums[m] != m+1) {
                return m+1;
            }
        }
        return nums.length+1;
    }
}

// single number
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int m = 0; m < nums.length; m++) {
            if(map.containsKey(nums[m])){
                if(map.get(nums[m]) == 1){
                    map.put(nums[m],0);
                }
            }else{
                    map.put(nums[m],1);
                }
        }
        for (Integer name : map.keySet())  
        { 
            // System.out.println("key- "+name+"value- "+map.get(name));
            if(map.get(name) == 1){
                return name;
            }
        }  
        return -1;
    }
}

//set mismatch (pending incomplete)
