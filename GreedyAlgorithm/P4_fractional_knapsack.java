package GreedyAlgorithm;

import java.util.Arrays;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class P4_fractional_knapsack {

    public static double fractionalKnapsack(int W, Item arr[], int n){
        Arrays.sort(arr, (a,b) -> Double.compare(
            (double) b.value / b.weight,
            (double) a.value / a.weight
        ));
        
        double totalValue = 0.0;
        int currentWeight = 0;

        for(int i=0; i<n; i++){
            if(currentWeight + arr[i].weight <= W){
                currentWeight += arr[i].weight;
                totalValue += arr[i].value;
            }
            else{
                int remainingWeight = W - currentWeight;
                totalValue += (double) arr[i].value / arr[i].weight * remainingWeight;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item items[] = new Item[]{
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30),
        };
        int weight = 50, size = items.length;

        double maxValue = fractionalKnapsack(weight, items, size);
        System.out.println("Maximum Value that it can hold: "+ maxValue);
    }
}
