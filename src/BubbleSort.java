
public class BubbleSort implements SortingAlgorithm{

    public int[] sorty(int[] input){

        int l = input.length;

        for(int i = 0; i < (l-1); i ++){
            for(int j = 0; j < l - i -1; j++ ){ //keeps the second element less than the first element

                if(input[j] > input[j+1]){ //checks to see if the second element is greater than the first
                    int t = input[j];
                    input[j] = input[j+1];
                    input[j+1] = t;
                }
            }
        }

        return input;
    }

    public  String getName(){
        return "Bubble Sort";
    }



}
