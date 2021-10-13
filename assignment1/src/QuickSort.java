public class QuickSort {
    public void sort(double[] arr, int bot, int top){
        if(bot<top){
            int p = partition(arr,bot,top);
            sort(arr,bot,p-1);
            sort(arr,p+1,top);
        }
    }
    public void swap(double[] arr, int i, int j){
        double copy = arr[i];
        arr[i]=arr[j];
        arr[j]=copy;
    }

    public int partition(double[] arr,int left,int right) {
        int pivot = right;
        int bot = left;
        int top = right - 1;
        if (left < right) {

            while (bot <= top) {
                while (bot < right && arr[bot] < arr[pivot])
                    ++bot;
                while (top >= bot && arr[top] >= arr[pivot])
                    --top;
                if (bot < top)
                    swap(arr, bot, top);
                else
                    swap(arr, bot, pivot);
            }

        }
        return bot;
    }
}
