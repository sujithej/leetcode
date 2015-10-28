import java.util.*;

/**
 * Created by sujith.j on 25/10/15.
 */

//Given an array of strings, group anagrams together.
//
//        For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Return:
//
//        [
//        ["ate", "eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]

public class GroupAnagrams {

    public static void main(String[] args) {
        String []strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = (new GroupAnagrams()).groupAnagrams(strs);
        System.out.println("hold");
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        HashMap<String, List<String>> resultHash = new HashMap<String, List<String>>();
        String hash;
        List<String> temp = new ArrayList<String>();
        for (String str : strs) {
//            hash = rotateStringBySmallest(str);
            hash = sortString(str);
            if (resultHash.containsKey(hash))
                temp = resultHash.get(hash);
            else
                temp = new ArrayList<String>();
            temp.add(str);
            resultHash.put(hash,temp);
        }
        for (List<String> stringList : resultHash.values()) {
            Collections.sort(stringList);
            ans.add(stringList);
        }
        return ans;

    }

    public String rotateStringBySmallest(String string) {
        String temp = "";
        char smallest = string.charAt(0);
        int rotateIndex = 0;
        for (int i = 1; i < string.length(); i++) {
            if (smallest(string, i, rotateIndex)) {
                rotateIndex = i;
            }
        }
        temp = string.substring(rotateIndex) + string.substring(0, rotateIndex);

        return temp;
    }

    public String sortString(String str)
    {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    public boolean smallest(String s, int index1, int index2) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char var1 = s.charAt((index1 + i) % length);
            char var2 = s.charAt((index2 + i) % length);
            if (var1 < var2)
                return true;
            if (var2 < var1)
                return false;
        }
        return true;
    }


}
