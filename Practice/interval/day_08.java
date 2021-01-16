/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// merge interval
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<int[]>();
        if(intervals.length==1){
            return intervals;
        }
        for(int i=1;i<intervals.length;i++){
            int[] k = new int[2];
            int lastIndex = list.size()-1;
            int[] h = lastIndex>=0 ? list.get(lastIndex) : intervals[0];
            System.out.println(list);
            if(intervals[i][0] >= h[0] && intervals[i][0] <= h[1]){
                k[0]=h[0];
                k[1]=(Math.max(intervals[i][1], h[1]));
                if(lastIndex >= 0)
                    list.remove(lastIndex);
                list.add(k);
            }else if((intervals[i][0]>intervals[i-1][1])){
                if(i-1==0){
                    list.add(intervals[0]);
                }
                list.add(intervals[i]);
            }
        }
        int[][] itemsArray = new int[list.size()][2];
        list.toArray(itemsArray);
        return itemsArray;
    }
}

// insert interval
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<int[]>();
        int added = 0;
        if(intervals.length==0){
            list.add(newInterval);
            int[][] itemsArray = new int[list.size()][2];
            list.toArray(itemsArray);
            return itemsArray;
        }
        for(int i=0;i<intervals.length;){
            int[] entry = new int[2];
            int lastIndex = list.size()-1;
            if(lastIndex<0){
                list.add(intervals[0]);
                i++;
                continue;
            }
            entry = list.get(lastIndex);
            if(added == 0 && isOverlapping(entry, newInterval) == true){
                list.remove(lastIndex);
                list.add(getEntry(entry, newInterval));
                added = 1;
            }else if(isOverlapping(entry, intervals[i]) == true){
                list.remove(lastIndex);
                list.add(getEntry(entry, intervals[i]));
                i++;
            }else {
                list.add(intervals[i]);
                i++;
            }
        }
        if(added == 0){
            int[] entry = new int[2];
            int lastIndex = list.size()-1;
            entry = list.get(lastIndex);
            if(isOverlapping(entry, newInterval) == true){
                list.remove(lastIndex);
                list.add(getEntry(entry, newInterval));
            }else {
                list.add(newInterval);
            }
        }
        int[][] itemsArray = new int[list.size()][2];
        list.toArray(itemsArray);
        Arrays.sort(itemsArray, (a, b) -> a[0] - b[0]);
        return itemsArray;
    }
    public boolean isOverlapping(int[] entry, int[] newInterval) {
        if(newInterval[1]<=entry[1] && newInterval[1]>=entry[0]){
            return true;
        } 
        if(newInterval[0]<=entry[1] && newInterval[0]>=entry[0]){
            return true;
        } 
        if(newInterval[1]>entry[1] && newInterval[0]<entry[0]){
           return true;
        }
        if(newInterval[1]<entry[1] && newInterval[0]>entry[0]){
           return true;
        }
        return false;
    }
    public int[] getEntry(int[] entry, int[] newInterval) {
        int[] k = new int[2];
        k[0]=-1;
        k[1]=-1;
        if(isOverlapping(entry, newInterval)){
            k[0]=(Math.min(newInterval[0], entry[0]));
            k[1]=(Math.max(newInterval[1], entry[1]));
        }
        return k;
    }
}

//interval list intersection
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0;
        if(A.length==0 || B.length==0){
            return A.length==0 ? A : B;
        }
        ArrayList<int[]> res = new ArrayList<int[]>();
        while(i<A.length && j<B.length){
            int[] k=new int[2];
            if(isOverlapping(A[i], B[j])){
                k[0]=Math.max(A[i][0], B[j][0]);
                k[1]=Math.min(A[i][1], B[j][1]);
                res.add(k);
                if(B[j][1]<=A[i][1]){
                    j++;
                }else {
                    i++;   
                }
            }else{
                
                if(B[j][1]<=A[i][0]){
                    j++;
                }else {
                    i++;   
                }
            }
        }
        int[][] itemsArray = new int[res.size()][2];
        res.toArray(itemsArray);
        return itemsArray;
    }
    public boolean isOverlapping(int[] a, int[] b) {
        
        if(a[0]>=b[0] && a[0]<=b[1]){
            return true;
        }
        if(a[1]>=b[0] && a[1]<=b[1]){
            return true;
        }
        if(b[0]>=a[0] && b[0]<=a[1]){
            return true;
        }
        if(b[0]>=a[0] && b[0]<=a[1]){
            return true;
        }
        return false;
    }
}

//my calendar I
class MyCalendar {
    List<int[]> calender; 
    public MyCalendar() {
        calender = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for(int[] entry: calender){
            if((start>=entry[0] && start<entry[1]) || (end>entry[0] && end<=entry[1])){
                return false;
            }
            if((start>=entry[0] && end<=entry[1])){
                return false;
            }
            if((start<=entry[0] && end>=entry[1])){
                return false;
            }
        }
        calender.add(new int[]{start,end});
        return true;
    }
}
