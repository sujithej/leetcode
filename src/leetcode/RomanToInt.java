package leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 21/06/15
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RomanToInt {


    public void populateHashMap(HashMap<Character,Integer> a)
    {
        a.put('I',1);
        a.put('V',5);
        a.put('X',10);
        a.put('L',50);
        a.put('C',100);
        a.put('D',500);
        a.put('M',1000);
    }

    public int romanToInt(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<Character,Integer> ();
        populateHashMap(hashMap);
        char []charArray = s.toCharArray();

        int sum =0;
        if(hashMap.get(charArray[0]) < hashMap.get(charArray[1]) && s.length() > 1)
        {
            sum = sum - hashMap.get(charArray[0]);
        }
        else
        {
            sum = sum+ hashMap.get(charArray[0]);
        }




        for(int i =1;i<charArray.length-1;i++)
        {
            if(hashMap.get(charArray[i]) < hashMap.get(charArray[i+1]) &&  hashMap.get(charArray[i]) < hashMap.get(charArray[i-1]) )
            {
                sum = sum - hashMap.get(charArray[i]);
            }
            else
            {
                sum = sum + hashMap.get(charArray[i]);
            }


        }

        if(s.length() > 1)
            sum = sum+hashMap.get(charArray[charArray.length -1] );

        return sum;

    }






}
