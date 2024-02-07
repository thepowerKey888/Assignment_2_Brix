public class SelectionSort implements SortingAlgorithm {
    public int[] sorty(int[] input){

        int l = input.length;

        for(int i = 0; i < l-1; i++){ //loops through length of array minus 1

            int min = i; //will store the minimum element

            for(int j = i+1; j < l; j++){ //loops through the array at the next term after i
                if(input[j] < input[min]){ //checks to see if j is greater than i
                    min = j;
                }

                //swapping minimum element with first element of input
                int t = input[min]; //temporary variable to store the minimum value
                input[min] = input[i]; //switches the elements to correct index
                input[i] = t;
            }
        }

        return input;
    }

    public  String getName(){
        return "Selection Sort";
    }
}
