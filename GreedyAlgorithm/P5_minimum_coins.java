package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class P5_minimum_coins {
    public static int minimumCoins(int[] coins, int size, int value){
        Arrays.sort(coins);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=size-1; i>=0; i--){
            System.out.println("check" + value +" "+ coins[i] );
            while (value >= coins[i]) {
                value -= coins[i]; 
                result.add(coins[i]);
            }
            System.out.println("list" + result); // Printing the result list after each iteration
        }
        return result.size();
    }

    public static void main(String[] args) {
        int[] coins = { 9, 6, 5, 1 };
        int value = 11;
        System.out.println("Minimum number of coins: " + minimumCoins(coins, coins.length, value));
    }
}
