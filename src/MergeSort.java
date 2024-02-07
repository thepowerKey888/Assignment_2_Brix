public class MergeSort implements SortingAlgorithm {

    public int[] sorty(int[] input){

        mergeSort(input, 0, input.length-1);
        return input;
    }

    private void mergeSort(int[] a, int left, int right){
        if(left < right){
            int middle = left + (right-left)/2; //determine the middle point

            mergeSort(a, left, middle);
            mergeSort(a, middle+1, right);
            merge(a, left, middle, right);
        }
    }

    private void merge(int[] a, int left, int middle, int right){

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; ++i) {

            L[i] = a[left + i];

        }

        for(int j = 0; j < n2; ++j){

            R[j] = a[middle+1+j];
        }

        int i =0;
        int j =0;

        int k = left;

        while(i < n1 && j < n2){

            if (L[i] <= R[j]){
                a[k] = L[i];
                i++;
            }

            else{
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            a[k] = L[i];
            i++;
            k++;
        }

        while(j < n2){

            a[k] = R[j];
            j++;
            k++;
        }
    }


public  String getName(){
        return "Merge Sort";
        }
}
