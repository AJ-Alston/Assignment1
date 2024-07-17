import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Class to implement a faster version of Merge Sort
public class FastMergeSort {
    private static final int THRESHOLD = 64;

    public static void sort(double[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        double[] temp = new double[arr.length];
        sortHelper(arr, temp, 0, arr.length - 1);
    }

    private static void sortHelper(double[] arr, double[] temp, int left, int right) {
        if (right - left <= THRESHOLD) {
            insertionSort(arr, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        sortHelper(arr, temp, left, mid);
        sortHelper(arr, temp, mid + 1, right);
        if (arr[mid] <= arr[mid + 1]) return;
        merge(arr, temp, left, mid, right);
    }

    private static void insertionSort(double[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void merge(double[] arr, double[] temp, int left, int mid, int right) {
        System.arraycopy(arr, left, temp, left, right - left + 1);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) arr[k++] = temp[i++];
    }
}


/*
public class FastMergeSort {

    //Lists to hold pairs
    static List<List<Double>> pairs = new ArrayList<>();
    static List<Double> order = new ArrayList<>();

    //function that goes through array finds pairs and adds them to list
    public static void findPairs(double[] arr){
        order.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            //keep adding if data is greater than the previous
            if(arr[i]>=arr[i-1]){
                order.add(arr[i]);
            }
            //if not add the group to the list "pairs" and delete the original place holder pair
            else if(order.size()>0 && arr[i]<arr[i-1]){
                List<Double> order2 = new ArrayList<>();
                for (int j = 0; j < order.size(); j++) {
                    order2.add(order.get(j));
                }
                pairs.add(order2);
                order.clear();
                order.add(arr[i]);
            }
        }
        pairs.add(order);
    }
    //While loop that merges ordered elements until the list of them contains only one element
    void sort(double[] arr){
        findPairs(arr);
        //System.out.println(pairs.toString());
        //isSorted
        while(pairs.size()>1) {
            merge(arr, pairs.get(0), pairs.get(1));
        }
    }

    //Merges adjacent ordered pairs and reduces elements in "pairs" list
    public static void merge(double[] arr, List<Double> left, List<Double> right){
        int leftSize = left.size();
        int rightSize = right.size();

        int i=0,j=0,k=0;
        //Merge left and right sides
        while(i<leftSize && j<rightSize){
            if(left.get(i)<=right.get(j)){
                arr[k]=left.get(i);
                i++;
            }
            else{
                arr[k]=right.get(j);
                j++;
            }
            k++;
        }
        //Add additional left over elements
        while(i<leftSize){
            arr[k]=left.get(i);
            i++;
            k++;
        }
        while(j<rightSize){
            arr[k]=right.get(j);
            j++;
            k++;
        }
        int counter=0;
        int counter2=0;
        //If the right ordered set contains less elements add elements from right to left and delete the right set
        if(leftSize>=rightSize){
            while(right.size()>0) {
                if(right.get(counter)>=left.get(counter2) && right.get(counter)<left.get(counter2+1)){
                    left.add(counter2+1,right.get(counter));
                    right.remove(counter);
                    counter2--;
                }
                else if(right.get(counter)<left.get(0)){
                    left.add(0,right.get(counter));
                    right.remove(counter);
                    counter2--;
                }
                else if(right.get(counter)>left.get(left.size()-1)){
                    left.add(right.get(counter));
                    right.remove(counter);
                }
                counter2++;
            }
            pairs.remove(right);
            //System.out.println(pairs.toString());
        }
        //If the left ordered set contains less elements add elements from left to right and delete the left set
        else if(leftSize<rightSize){
            counter = 0;
            counter2 = 0;
            while(left.size()>0) {
                if(left.get(counter2)>=right.get(counter) && left.get(counter2)<right.get(counter+1)){
                    right.add(counter+1,left.get(counter2));
                    left.remove(counter2);
                    counter--;
                }
                else if(left.get(counter2)<right.get(0)){
                    right.add(0,left.get(counter2));
                    left.remove(counter2);
                    counter--;
                }
                else if(left.get(counter2)>right.get(right.size()-1)){
                    right.add(left.get(counter2));
                    left.remove(counter2);

                }
                counter++;
            }
            pairs.remove(left);

        }


    }

}*/
