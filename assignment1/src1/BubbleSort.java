//Class to implement Bubble Sort algorithm
public class BubbleSort {
    public void sort(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public void swap(double[] arr, int i, int j){
        double copy = arr[i];
        arr[i]=arr[j];
        arr[j]=copy;
    }
}
