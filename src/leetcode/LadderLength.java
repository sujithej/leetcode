import java.util.*;

/**
 * Created by sujith.j on 18/11/15.
 */
public class LadderLength {

    public static void main(String []args)
    {
        String beginWord = "hit";
        String endWord = "hit";
        String []words = {"hot","dot","dog","lot","log"};
        Set<String> wordList  = new HashSet<String >(Arrays.asList(words));
        int length = (new LadderLength()).ladderLength(beginWord,endWord,wordList);
        System.out.println(length);
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> currentList = new HashSet<String>(wordList);
        currentList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        Queue<String> tempqueue = new LinkedList<String>();
        ArrayList<String> deleteList = new ArrayList<String>();
        queue.add(beginWord);
        if(beginWord.length() ==0 )
            return 0;
        int ladderLength = 1;
        while(!queue.isEmpty())
        {
            tempqueue = new LinkedList<String>();
            for (String temp : queue) {
                deleteList = new ArrayList<String>();

                if(temp == endWord)
                    return ladderLength;
                for (String s : currentList) {

                    if(adjacentWords(temp,s)) {
                        tempqueue.add(s);
                        deleteList.add(s);
                    }
                }
                currentList.removeAll(deleteList);

            }
            ladderLength++;
            queue = new LinkedList<String>(tempqueue);

        }
        return 0;


    }

    public boolean adjacentWords(String s1,String s2)
    {
        int diff = 0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }
        if(diff == 1)
            return true;
        else
            return false;

    }

}
