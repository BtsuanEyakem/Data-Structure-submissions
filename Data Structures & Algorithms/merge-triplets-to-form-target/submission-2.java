class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        if(triplets.length == 1)  return Arrays.equals(triplets[0],target);
            int len = triplets.length;
            int l =0;
            int[] list = new int[3];
          //  int r = 1;

          while(l < len){
            int[] cur = triplets[l];
            boolean isPart = true;
            for(int i=0; i <3; i++){
                if(cur[i]>target[i]){
                    isPart = false;
                }
            }
            if(isPart){
                int x = Math.max(list[0],cur[0]);
                int y = Math.max(list[1],cur[1]);
                int z = Math.max(list[2],cur[2]);
                list = new int[]{x,y,z};
            }

            l++;
          }

          return Arrays.equals(list,target);
 	    
    }

}
//                                    j
//   5 5 5                                  5 5 5
// [[2,5,3],[5,6,7],[5,5,3],[2,3,4],[1,2,5],[5,2,3]]    target = [5,5,5]
// count = 
// if all arr[i] < target[i]
// list = Math.max([2,5,3] + arr[i]]
// [2,5,4] + [1,2,5] = [2,5,5]

/*
   
*/



// TC = O(n)
// SC = O(n)