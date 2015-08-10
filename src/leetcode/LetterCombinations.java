package leetcode;

import java.util.List;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 01/07/15
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class LetterCombinations {

    public static void main(String []args)
    {
        List<String> ans = (new LetterCombinations()).letterCombinations("23456");
        System.out.println("hold");
    }

    HashMap<Character,ArrayList<Character>> nocharmap = new HashMap<Character,ArrayList<Character>>();

    public List<String> letterCombinations(String digits) {
        populateNoCharMap(nocharmap);
        HashMap<Integer,ArrayList<Character>>  nocharmap = new HashMap<Integer, ArrayList<Character>>();
        List<String> ans  = new ArrayList<String>();
        if(digits.length() == 0)
            return ans;

        char []temp = new char[digits.length()];
        letterCombinationsUtil(ans,digits,temp,0);
        return ans;

    }

    public void letterCombinationsUtil(List<String> ans,String digits,char []temp,int index)
    {
        if(index == digits.length())
        {
            ans.add(new String(temp));
            return;
        }

        ArrayList<Character> charCombination = nocharmap.get(digits.charAt(index));

        for(Character c:charCombination)
        {
            temp[index]  = c;
            letterCombinationsUtil(ans, digits, temp, index + 1);
        }

    }

    public void populateNoCharMap(HashMap<Character,ArrayList<Character>> nocharmap)
    {
        ArrayList<Character> temp = new ArrayList<Character>();
        temp.add('a');temp.add('b');temp.add('c');
        nocharmap.put('2',temp);
        temp = new ArrayList<Character>();
        temp.add('d');temp.add('e');temp.add('f');
        nocharmap.put('3',temp);
        temp = new ArrayList<Character>();
        temp.add('g');temp.add('h');temp.add('i');
        nocharmap.put('4',temp);
        temp = new ArrayList<Character>();
        temp.add('j');temp.add('k');temp.add('l');
        nocharmap.put('5',temp);
        temp = new ArrayList<Character>();
        temp.add('m');temp.add('n');temp.add('o');
        nocharmap.put('6',temp);
        temp = new ArrayList<Character>();
        temp.add('p');temp.add('q');temp.add('r');temp.add('s');
        nocharmap.put('7',temp);
        temp = new ArrayList<Character>();
        temp.add('v');temp.add('t');temp.add('u');
        nocharmap.put('8',temp);
        temp = new ArrayList<Character>();
        temp.add('w');temp.add('x');temp.add('y');temp.add('z');
        nocharmap.put('9',temp);

    }

}
