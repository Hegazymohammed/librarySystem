package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.Arrays.*;

public class Main {

    static int [][]memo=new int[36][36];


    public static int knapsack(int index,int remains,int []weight,int []value){
        if(index==weight.length)
            return 0;

        int result=memo[index][remains];
        if(result!=-1)
            return result;

        int leave=knapsack(index+1, remains, weight,value);

        int peak=0;
        if(remains>=weight[index])
            peak=value[index]+ knapsack(index+1, remains-weight[index], weight,value);

        memo[index][remains]=Math.max(leave, peak);
        return memo[index][remains];
    }
    public static void main(String[] args) {


        int weight[]={10, 4 , 6, 5, 1};
        int cost[]=  {10, 15, 2 , 8, 2 };
        setAll(memo, row-> IntStream.range(0, 36).map(col-> -1).toArray());
        knapsack(0, 21, weight, cost);


        for(int[]val:memo){
            System.out.println(Arrays.toString(val));
        }


    }
}