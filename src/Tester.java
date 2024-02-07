import java.util.Random;
public class Tester {

    //field
    private /*final*/ SortingAlgorithm sortingAlgorithm;

    /**
     * Constructor for the Tester class.
     * @param sa
     */
    public Tester(SortingAlgorithm sa){

        this.sortingAlgorithm = sa;
    }


    /**
     * Creates a random array
     * and generates a k sorted array.
     * @param size
     * @return
     */
   public double singleTest(int size){


       //creates an array full of random numbers
//       int[] input = new int[size];
//       Random random = new Random();
//       for(int i = 0; i< size; i++){
//           input[i] = random.nextInt(1000); //can adjust the range of numbers
//       }

       //creates a kSorted array
        int[] input = generateKSorted(size); //generates k sorted array


        long startT = System.nanoTime();
        sortingAlgorithm.sorty(input); //calls the sorting algorithms
        long endT = System.nanoTime();

        double elapsedTime = (endT-startT) / 1e6; //converts to milliseconds

       return elapsedTime;

    }

    /**
     * Runs singleTest method as many times
     * as the number of iterations provided.
     * Prints the avgerage time it takes to
     * sort the arrays.
     * @param iterations
     * @param size
     */
    public void test(int iterations, int size){

        double totalTime = 0;
        for(int i = 0; i< iterations; i++){

            totalTime += singleTest(size);

        }

        double avgTime = totalTime/iterations;

        //print statement for random data
        //System.out.println("Sorted " + size + " elements in " + avgTime + " ms (avg");

        //print statement for k-sorted data
        System.out.println("Sorted: " + size +
                " elements in " + avgTime + "ms (avg) with 10-sorted data");
    }

    /**
     * Generates a k sorted array to be sorted.
     * @param size
     * @return
     */
    public int[] generateKSorted(int size){

        int[] input = new int[size];

        Random random = new Random();
        for(int i = 0; i < size; i++){
            input[i] = random.nextInt();
        }

        for(int gap = size/10; gap > 0; gap/=2){
            for(int i = gap; i < size; i++){
                int a = input[i];
                int j;
                for( j = i; j>= gap && a < input[j - gap]; j-= gap){
                    input[j] = input[j-gap];
                }
                input[j] = a;
            }
        }
        return input;
    }

}
