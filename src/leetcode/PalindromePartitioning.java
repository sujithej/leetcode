import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<List<Integer>> palindromes = new ArrayList<List<Integer>>(s.length());
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        List<Integer> temp;
        List<List<List<String>>> answers = new ArrayList<List<List<String>>>(s.length()+1);
        for (int i = 0; i < length; i++) {
            temp = new ArrayList<Integer>();
            for (int j = i; j < length; j++) {
                if(isPalindrome(charArray,i,j)){
                    temp.add(j);
                }
            }
            palindromes.add(temp);
            answers.add(new ArrayList<List<String>>());
        }


        List<String> tmpList  ;
        List<List<String>> tempAns;
        List<List<String>> answer;
        ArrayList<List<String>> defaultList = new ArrayList<>();
        defaultList.add(new ArrayList<String>());
        answers.add(defaultList);
        for(int i = length-1; i >=0 ;i--){
            answer  = answers.get(i);
            temp = palindromes.get(i);
            for (Integer integer : temp) {
//                if(integer == length-1) {
//                    tempAns = new ArrayList<List<String>>();
//                }else {
                    tempAns = answers.get(integer + 1);
//                }
                append(s.substring(i, integer + 1), answer,tempAns);
            }
//            answers.add(i,answer);
        }
        return answers.get(0);
    }
    public List<List<String>> append(String str,List<List<String>> answers,List<List<String>> tmpList){
        for (List<String> strings : tmpList) {
            List<String> tmp = new ArrayList<>();
            tmp.add(str);
            tmp.addAll(strings);
            answers.add(tmp);
        }
        return answers;
    }


    public Boolean isPalindrome(char[] charArray, int i, int j) {
        for (int index = i; index <= i + (j - i) / 2; index++) {
            if (charArray[index] != charArray[j + i - (index)])
                return false;
        }
        return true;
    }

    public static void main(String []args){
        List<List<String>> answers = (new PalindromePartitioning()).partition("aab");
        System.out.println("hold");

    }
}
