/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// Valid Palindrome
class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i) == ' ' || !(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
                i++;
                continue;
            }
            if(s.charAt(j) == ' ' || !(Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j)))){
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

//Valid Palindrome II

class Solution {
    public boolean validPalindrome(String s) {
        int low=0,high=s.length()-1, count=0;
        while(low<high){
            if(s.charAt(low)==s.charAt(high)){
                low++;high--;
            }else {
                if(isPalindrome(s.substring(0,low)+s.substring(low+1,s.length()))){
                    return true;
                }
                if(isPalindrome(s.substring(0,high)+s.substring(high+1,s.length()))){
                    return true;
                }
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i) == ' ' || !(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
                i++;
                continue;
            }
            if(s.charAt(j) == ' ' || !(Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j)))){
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}



// Reverse string
class Solution {
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
            System.out.println(s[i] +"111"+ s[s.length-1-i]);
        }
    }
}

//Reverse words in string
class Solution {
    public String reverseWords(String s) {
        int i=0,j=0;
        String[] arr = s.split(" "); 
        List<String>  str = new ArrayList<String>(); 
        for(int k=0; k<arr.length; k++){
            if(arr[k].trim().length() > 0){
                str.add(arr[k].trim());
            }
            
        }
        Collections.reverse(str);
        String c = str.get(0);

        for(int k=1; k<str.size(); k++){
            c += (" "+str.get(k));
        }
        return c;
    }
}
