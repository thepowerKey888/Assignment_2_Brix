public class QuickSort implements SortingAlgorithm{

   public int[] sorty(int[] input) {
       quickSort(input, 0, input.length - 1);
       return input;
   }
    private void quickSort(int[] input, int start, int end) {

        if (end <= start) {
            int high = partition(input, start, end);
            quickSort(input, start, high);
            quickSort(input, high + 1, end);
        }
    }

       public static int partition(int[] input, int start, int end){

       int midpoint = start + (end - start)/2;
       int pivot = input[midpoint];

       int low = start;
       int high = end;

       boolean done = false;

       while(!done){

           while(input[low] < pivot){
               low++;
           }

           while(input[high] > pivot){
               high--;
           }

           if(low >= high){
               done = true;
           }
           else{
               int t = input[low]; //temorarily stores the variable
               input[low] = input[high];
               input[high] = t;

               low++;
               high--;
           }

       }

       return high;
       }

    public  String getName(){
        return "Quick Sort";
    }
}
