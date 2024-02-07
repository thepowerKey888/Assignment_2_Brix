/**
Description: This class holds the Insertion sorting algorithm methods.
             Insertion sort takes the input as 2 parts: unsorted part & sorted part.
             Then it inserts the value from the unsorted part into the sorted part.

 */
public class InsertionSort implements SortingAlgorithm{

    public int[] sorty(int[] input){

        int l = input.length;

        int i = 0; int j = 0; //variables used in for loop to mark the elements
        int temp = 0; //temporary variable used for swapping elements

        for(i = 1; i < l; i++){ //start at the first element at i =1
            temp = input[i]; //temporarily storing the element we are on
            j = i -1; //setting j to the previous element of i

            while(j >= 0 && input[j] > temp){ //checks if the previous element is greater than the next element

                input[j+1] = input[j]; //moves the element one position ahead
                j = j -1; //resets position of j
            }

            input[j +1] = temp; //sets position of temp

        }

        return input;
    }

    public  String getName(){
        return "Insertion Sort";
    }
}
