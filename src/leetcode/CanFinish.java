package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 08/07/15
 * Time: 8:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class CanFinish {
    public static void main(String []args)
    {
        int [][]prerequisites = {{1,0},{0,2}};
        boolean ans = (new CanFinish()).canFinish(2,prerequisites);
        System.out.println(ans);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>>  adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
        HashSet<Integer> traversed = new HashSet<Integer>();
        HashSet<Integer> duplicates = new HashSet<Integer>();
        ArrayDeque<Integer> temp = new ArrayDeque<Integer>();
        ArrayList<Integer> adjacent = new ArrayList<Integer>();
        Integer tempInt;

        populateAdjacencyList(adjacencyList,prerequisites);
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>(adjacencyList.keySet());
        while(!queue.isEmpty())
        {
            tempInt  = queue.poll();
            if(!duplicates.contains(tempInt))
            {
                duplicates.add(tempInt);
                if(traversed.contains(tempInt))
                    return false;
                else
                    traversed.add(tempInt);

                adjacent = adjacencyList.get(tempInt);
                if(adjacent != null)
                    temp.addAll(adjacent);
            }
            if(queue.isEmpty())
            {
                queue = temp;
                temp = new ArrayDeque<Integer>();
                duplicates.clear();
            }
        }

        return true;
    }

    public void populateAdjacencyList(HashMap<Integer,ArrayList<Integer>>  adjacencyList,int [][]prerequisites)
    {
        ArrayList temp;
        for(int i=0;i< prerequisites.length;i++)
        {
            temp = adjacencyList.get(prerequisites[i][0]);
            if(temp == null)
                temp = new ArrayList<Integer>() ;
            temp.add(prerequisites[i][1]);
            adjacencyList.put(prerequisites[i][0],temp);
        }
    }
}
