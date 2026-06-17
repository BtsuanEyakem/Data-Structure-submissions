/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> end = new PriorityQueue<>();
        int[] start = new int[intervals.size()];
        int rooms = 0;
        for(int i=0; i < intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end.offer(intervals.get(i).end);
        }
        Arrays.sort(start);
        for(int j=0; j < start.length; j++){
            if(start[j] >= end.peek()){
                end.poll();
            }else{
                rooms++;
            }
        }
    return rooms;

    }
}
