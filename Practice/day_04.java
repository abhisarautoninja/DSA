/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// Valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] charA = s.toCharArray();
        char[] charB = t.toCharArray();
        Arrays.sort(charA);
        Arrays.sort(charB);
        for(int i=0;i<(charA.length);i++){
            if(charA[i]!=charB[i]){
                return false;
            }
        }
        return true;
    }
}

// Group Anagram

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i=0;i<strs.length;i++){
            char[] charA = strs[i].toCharArray();
            Arrays.sort(charA);
            String x = new String(charA);
            if(map.containsKey(x)){
                map.get(x).add(strs[i]);
            }else {
                ArrayList<String> b = new ArrayList<String>();
                b.add(strs[i]);
                map.put(x, b);
            }
        }
        return map.values().stream().collect(Collectors.toList());      
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] charA = s.toCharArray();
        char[] charB = t.toCharArray();
        Arrays.sort(charA);
        Arrays.sort(charB);
        for(int i=0;i<(charA.length);i++){
            if(charA[i]!=charB[i]){
                return false;
            }
        }
        return true;
    }
}
