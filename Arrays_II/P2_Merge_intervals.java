package Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution{

    public static int[][] merge(int[][] intervals){
        List <int []> res = new ArrayList<>();

        if(intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals){
            if (i[0] <= end){
                end = Math.max(end, i[1]);
            }else{
                res.add(new int[] {start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[] {start, end});
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);

        // Display the merged intervals
        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}