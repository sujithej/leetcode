package leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 21/06/15
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntToRoman {

    public static void main(String []args)
    {
        System.out.println((new IntToRoman()).intToRoman(76));
    }

    public void populateHashMap(HashMap<Integer,Character> a)
    {
        a.put(1,'I');
        a.put(5,'V');
        a.put(10,'X');
        a.put(50,'L');
        a.put(100,'C');
        a.put(500,'D');
        a.put(1000,'M');
    }


    public String intToRoman(int num) {

        char []charArray = new char[100];
        Character tempChar10,tempChar5,tempChar1;
        int temp;
        int divisionfactor = 1000;
        HashMap<Integer,Character> hashMap = new HashMap<Integer,Character>();
        populateHashMap(hashMap);
        int i = 0;



        while(divisionfactor > 0)
        {
            temp = num/divisionfactor;
            num = num % divisionfactor;
            tempChar10 = hashMap.get(divisionfactor*10);
            tempChar5 = hashMap.get(divisionfactor*5);
            tempChar1 = hashMap.get(divisionfactor);
            divisionfactor = divisionfactor/10;
            switch (temp){
                case 0:
                    break;
                case 1:
                    charArray[i++] = tempChar1;
                    break;
                case 2:
                    charArray[i++] = tempChar1;
                    charArray[i++] = tempChar1;
                    break;
                case 3:
                    charArray[i++] = tempChar1;
                    charArray[i++] = tempChar1;
                    charArray[i++] = tempChar1;
                    break;
                case 4:
                    charArray[i++] = tempChar1;
                    charArray[i++] = tempChar5;
                    break;
                case 5:
                    charArray[i++] = tempChar5;
                    break;
                case 6:
                    charArray[i++] = tempChar5;
                    charArray[i++] = tempChar1;
                    break;
                case 7:
                    charArray[i++] = tempChar5;
                    charArray[i++] = tempChar1;
                    charArray[i++] = tempChar1;
                    break;
                case 8:
                    charArray[i++] = tempChar5;
                    charArray[i++] = tempChar1;
                    charArray[i++] = tempChar1;
                    charArray[i++] = tempChar1;
                    break;
                case 9:
                    charArray[i++] = tempChar1;
                    charArray[i++] = tempChar10;
                    break;
            }

        }
        String ans = new String(charArray).trim();
        return ans;





    }


}
