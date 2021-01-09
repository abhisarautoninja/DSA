/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// minimum in rotated sorted array
class Solution {
    public int findMin(int[] nums) {
        int start =0, end = nums.length-1;
        if(nums[end]>nums[start] || nums.length==1){
            return nums[0];
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if((mid-1) >= 0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }else if(nums[mid]>=nums[0]){
                start=mid+1;
            }else if(nums[mid]<nums[0]){
                end=mid-1;
            }
        }
        return -1;
    }
}

// search in rotated sorted array
class Solution {
    public int search(int[] nums, int target) {
        int pivot = searchPivot(nums, 0, nums.length-1);
        if(pivot == 0 || pivot == -1){
            return searchBinary(nums, target, 0, nums.length-1);
        }
        if(nums[0]<=target && target<=nums[pivot-1]){
            return searchBinary(nums, target, 0, pivot-1);
        }
        return searchBinary(nums, target, pivot, nums.length-1);
    }
    public int searchPivot(int[] nums, int start, int end) {
        if(nums[end]>nums[start] || nums.length==1){
            return 0;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if((mid-1) >= 0 && nums[mid-1] > nums[mid]){
                return mid;
            }else if(nums[mid]>=nums[0]){
                start=mid+1;
            }else if(nums[mid]<nums[0]){
                end=mid-1;
            }
        }
        return -1;
    }
    public int searchBinary(int[] nums, int target, int start, int end) {
        if(nums.length==1){
            return nums[0] == target ? 0 : -1;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>=target){
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }
        }
        return -1;
    }
}

// first and last position of element in sorted array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
            res[0]=-1;
            res[1]=-1;
        int start = 0, end = nums.length-1;
        if(nums.length==0){
            return res;
        }
        if(nums.length==1 && nums[0]==target){
            res[0]=0;
            res[1]=0;
            return res;
        }
        
        if(nums[0] == target && nums[nums.length-1]==target){
            res[0]=0;
            res[1]=nums.length-1;
            return res;
        }
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(((mid-1) >= 0 && nums[mid-1] != target && nums[mid] == target) || (mid==0 && nums[mid]==target)){
                res[0]=mid;
                break;
            }else if(nums[mid]>=target){
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }
        }
        
        start = 0;
        end = nums.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(((mid+1) <= nums.length-1 && nums[mid+1] != target && nums[mid] == target) || (mid==nums.length-1 && nums[mid]==target)){
                res[1]=mid;
                break;
            }else if(nums[mid]>target){
                end=mid-1;
            }else if(nums[mid]<=target){
                start=mid+1;
            }
        }
        return res;
    }
}

// find peak element
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        if(nums.length==1){
            return 0;
        }
        if(nums.length==2){
            return nums[0]>nums[1] ? 0 : 1;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] <= nums[mid])){
                return mid;
            }else if(mid > 0 && nums[mid - 1] > nums[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return -1;
    }
}

//find first bad version
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start =1, end = n;
        if(n==1){
            return isBadVersion(n) ? 1 : -1 ;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if((mid==0 && isBadVersion(mid)) || ((mid-1)>=0 && isBadVersion(mid) == true && isBadVersion(mid-1) == false)){
                return mid;
            }else if((mid-1>=0 && isBadVersion(mid) == true && isBadVersion(mid-1) == true)) {
                end = mid-1;
            }else {
                start=mid+1;
            }
        }
        return -1;
    }
}

//2D matrix search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length-1;
        int n=matrix[0].length-1;

        int i=m; 
        int j=0;

        while(i>=0 && j<=n){
            if(target < matrix[i][j]){
                i--;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }

        return false;
    }
}

