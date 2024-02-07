public class ShellSort implements SortingAlgorithm{

    public int[] sorty(int[] input){

        int l = input.length;

        for(int gap = l/2; gap > 0; gap /= 2){ //divide length of array into 2

            for(int i = gap; i < l; i += 1){ //gap sorting array

                int t = input[i]; //temporary variable to make a space at position i

                for(int j = i; j >= gap && input[j- gap] > t; j -= gap){ //shifting gap sorted elements until location of a[i] is found

                    input[j] = input[j - gap];

                    input[j] = t; //putting the temporary variable in correct location
                }
            }
        }

        return input;
    }

    public  String getName(){
        return "Shell Sort";
    }
}
