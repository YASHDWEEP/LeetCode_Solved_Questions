class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        //distinct
        int n=nums.length;

        if(start==goal){
            return 0;
        }

        boolean[] vis=new boolean[1002];
        Queue<Integer> q=new LinkedList<>();

        q.offer(start);
        vis[start]=true;

        int steps=0;

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                int num=q.poll();

                for(int j=0;j<n;j++){
                    int choice1=num+nums[j];
                    int choice2=num-nums[j];
                    int choice3=num^nums[j];

                    if(choice1==goal || choice2==goal || choice3==goal){
                        return steps+1;
                    }

                    if(choice1>=0 && choice1<=1000 && !vis[choice1]){
                        q.offer(choice1);
                        vis[choice1]=true;
                    }

                    if(choice2>=0 && choice2<=1000 && !vis[choice2]){
                        q.offer(choice2);
                        vis[choice2]=true;
                    }

                     if(choice3>=0 && choice3<=1000 && !vis[choice3]){
                        q.offer(choice3);
                        vis[choice3]=true;
                    }
                }
            }

            steps++;
        }

        return -1;
    } 
}