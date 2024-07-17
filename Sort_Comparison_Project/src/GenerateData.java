import java.util.Random;

public class GenerateData {

    // Data sets
    double[] data1 = new double[50000];
    double[] data2 = new double[100000];
    double[] data3 = new double[150000];
    double[] data4 = new double[200000];
    double[] data5 = new double[250000];
    double[] data6 = new double[300000];
    double[] data7 = new double[350000];
    double[] data8 = new double[400000];
    double[] data9 = new double[450000];
    double[] data10 = new double[500000];

    // Fills array with random double instances
    public static void fillArray(double[] data) {
        Random random = new Random(); // Create Random object once
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextDouble() * 1000; // Generate a random double between 0 and 10
        }
    }

    //Main function to run experiment
    public static void main(String[] args) {
        GenerateData gd = new GenerateData();

        //Select data set defined above.
        //Note: Bubble Sorting 500,000 cells takes around 5-10 min on a Macbook M1 chip
        double[] data = gd.data1;

        //Sorting implementations
        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();
        InsertionSort insertionSort = new InsertionSort();
        QuickSort quickSort = new QuickSort();
        SelectionSort selectionSort = new SelectionSort();
        FastMergeSort fastMergeSort = new FastMergeSort();
        //Array of sorting algorithms and names
        Object[] sorts = {bubbleSort, mergeSort, insertionSort, quickSort, selectionSort,fastMergeSort};
        String[] sortNames = {"BubbleSort","MergeSort", "InsertionSort", "QuickSort", "SelectionSort", "FastMergeSort"};

        //Loop through sorting methods
        for (int i = 0; i < sorts.length; i++) {
            // Fill array again to reset the random values before each sort
            fillArray(data);

            long start = System.currentTimeMillis();

            // Check which sorting algorithm to use
            if (sorts[i] instanceof BubbleSort) {
                ((BubbleSort) sorts[i]).sort(data);
            } else if (sorts[i] instanceof MergeSort) {
                ((MergeSort) sorts[i]).sort(data);
            } else if (sorts[i] instanceof InsertionSort) {
                ((InsertionSort) sorts[i]).sort(data);
            } else if (sorts[i] instanceof QuickSort){
                ((QuickSort) sorts[i]).sort(data,0,data.length-1);
            } else if(sorts[i] instanceof SelectionSort){
                ((SelectionSort) sorts[i]).sort(data);
            } else if (sorts[i] instanceof FastMergeSort){
                ((FastMergeSort) sorts[i]).sort(data);
            }
            long end = System.currentTimeMillis();
            System.out.println(sortNames[i] + " Time: " + (end - start) + "ms");

            // Good place to call printSortedData()

            System.out.println(); // Newline for better readability
        }
    }

    //Function to print data and ensure sort works properly
    public static void printSortedData(double[] data, String sortName) {
        System.out.println("Sorted data for " + sortName + ":");
        //Signify how many rows you'd like to print with rows var
        int rows = 100;
        for (int j = 0; j < Math.min(data.length, rows); j++) {
            System.out.println(data[j]);
        }
        System.out.println(); // Add a blank line after printing for better readability
    }
}