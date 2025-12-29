// Practice- Sort Two Colors ?


class sortTwocolors{
 
    public static void sortTwocolors(int nums[]){
            int i = 0;
            int j = nums.length - 1;

            while(i <= j){
                 if(nums[i] == 1){
                      int  temp = nums[i];
                      nums[i] = nums[j];
                      nums[j] = temp;
                      j--;
                 }else{
                     i++;
                 }
            }
    }
    public static void main(String[] args) {
        int nums[] = {1,0,1,0,1}; 

        sortTwocolors(nums);

       for(int i = 0; i < nums.length; i++){ 
        System.out.print(nums[i] + " ");
       }
    }
}
