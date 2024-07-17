//Class to implement Insertion Sort algorithm
public class InsertionSort {
    public void sort(double[] arr){
        for (int k = 0; k < arr.length; k++) {
            double temp = arr[k];
            int l = k - 1;
            while (l >= 0 && arr[l] > temp) {
                arr[l + 1] = arr[l];
                --l;
            }
            arr[l + 1] = temp;
        }
    }

}
