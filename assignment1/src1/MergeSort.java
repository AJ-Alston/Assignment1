//Class to implement Merge Sort algorithm
public class MergeSort {

    void sort(double [] arr){
        if(arr.length>1){
            double [] left = getLeft(arr);
            double [] right = getRight(arr);

            sort(left);
            sort(right);
            merge(arr,left,right);
        }
    }

    public static double [] getLeft(double [] arr){
        int mid = arr.length/2;
        double [] left = new double[mid];
        for (int i = 0; i < mid; i++) {
            left[i]=arr[i];
        }
        return left;
    }

    public static double [] getRight(double [] arr){
        int mid = arr.length/2;
        double [] right = new double[arr.length-mid];
        for (int i = mid; i < arr.length; i++) {
            right[i-mid]=arr[i];
        }
        return right;
    }

    public static void merge(double[] arr, double[] left, double [] right){
        int leftSize = left.length;
        int rightSize = right.length;

        int i=0,j=0,k=0;

        while(i<leftSize && j<rightSize){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<leftSize){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<rightSize){
            arr[k]=right[j];
            j++;
            k++;
        }

    }
}
