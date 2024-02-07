import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Performance {
    /**
     * Main method to run the SortingAlgorithm's class
     * @param args
     */

    public static void main(String[] args){

        //initializes SortingAlgorithm objects
        SortingAlgorithm[] sortingAlgorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort()
        };

        int[] arraySizes = {100, 500, 1000,2000,5000,10000,20000, 75000, 150000};
        int iterations = 20;

        //creating a graph of the runtimes
        Graphs graph = new Graphs("Sorting Algorithm Runtimes");

        try{

            //writes the file
            FileWriter fileWriter = new FileWriter("/Users/sophiabrix/Desktop/Report/performance_report.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Performance Report: ");

            //iterates through the sorting algorithms
            for(SortingAlgorithm x : sortingAlgorithms){

                printWriter.println("Sorting Algorithms: " + x.getName());

                Tester tester = new Tester(x); //tester instance
                String algoName = x.getName();

                //iterates through array sizes
                for(int size : arraySizes){

                    double avgTime = tester.singleTest(size)/iterations; //computes avg time!

                    printWriter.println("Array Size: " + size);

                    tester.test(iterations, size);

                    printWriter.println("Sorted " +size+ " elements in " +
                            avgTime + " ms (avg)");
                    printWriter.println(" ");
                    tester.generateKSorted(size);
                    printWriter.println("");
                    graph.addData(algoName, size, avgTime); //adds data to graph

                }

                printWriter.println();

            }

            printWriter.close(); //closes PrintWriter
            System.out.println("Report successfully created!");
        }
        /**
        Catches any errors that may occur during runtime execution
        when writing the file
         */
        catch (IOException e){
            e.printStackTrace();
        }

        graph.createChart();
    }
}
