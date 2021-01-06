/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
		int[] arr = new int[10];
		arr[0] = (1);
		arr[1] = (2);
		arr[2] = (3);
		arr[3] = (4);
		arr[4] = (5);
		arr[5] = (6);
		arr[6] = (7);
		arr[7] = (8);
		arr[8] = (9);
		arr[9] = (10);
		ArrayList<String> res = new ArrayList<String>();
		printAllSubsequence("abcde",res);
		System.out.println(res);
	};
	// Binary search
	public static int binarySearch(int[] args, int num, int start, int end) {
		if(start>end){
		    return -1;
		}
		int mid = start + (end-start)/2;
		if(args[mid] == num){
		    return mid;
		}else if(args[mid] > num){
		    return binarySearch(args,num,0,mid);
		}else if(args[mid] < num){
		    return binarySearch(args,num,mid+1, args.length);
		}
		return -1;
	};
	// Is sorted
	public static boolean isSorted(int[] arr, int i) {
		if(i+1==arr.length){
		    return true;
		}
		if(arr[i]<arr[i+1]){
		    return true && isSorted(arr, i+1);
		}
		return false;
	};
	// Print all subsequence
	public void printAllSubsequence(String str, HashSet<String> res) {
		if(str.length() == 1){
		    return;
		}
		for(int index=0;index<str.length();index++){
		    String temp = str.substring(0, index) + str.substring(index+1);

		    if(temp.length()>0){
			res.add(temp);
			printAllSubsequence(temp, res);
		    }
		}
		return;
	};
}
