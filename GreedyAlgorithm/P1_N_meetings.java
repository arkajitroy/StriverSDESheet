package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Meeting{
    int start, end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Main{
    public static int maxMeetings(int start[], int end[], int n) {
        // Create a list of Meetings
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        // Sort the meetings based on their end times
        meetings.sort(Comparator.comparingInt(m -> m.end));

        // Select the first meeting
        int count = 1;
        int endTime = meetings.get(0).end;

        // Iterate through the sorted meetings and select non-overlapping ones
        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > endTime) {
                count++;
                endTime = meetings.get(i).end;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        System.out.println("Maximum number of meetings: " + maxMeetings(start, end, n));
    }
}