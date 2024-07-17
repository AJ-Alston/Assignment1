//Class to implement Selection Sort algorithm
public class SelectionSort {

    public int findSmallest(double[] arr, int start){
        int smallest =start;
        for (int i = start+1; i < arr.length; i++)
            if(arr[i]<arr[smallest])
                smallest=i;
        return smallest;
    }

    public void swap(double[] arr, int i, int smallest){
        double copy = arr[i];
        arr[i]=arr[smallest];
        arr[smallest]=copy;
    }
    public void sort (double[] data){
        for (int i = 0; i < data.length; i++)
            swap(data, i, findSmallest(data, i));

    }

}
