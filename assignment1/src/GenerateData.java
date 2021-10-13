import java.util.Random;

public class GenerateData {

    //data points
    double [] data1 = new double[50000];
    double [] data2 = new double[100000];
    double [] data3 = new double[150000];
    double [] data4 = new double[200000];
    double [] data5 = new double[250000];
    double [] data6 = new double[300000];
    double [] data7 = new double[350000];
    double [] data8 = new double[400000];
    double [] data9 = new double[450000];
    double [] data10 = new double[500000];

    //fills array with random double instances
    public static void fillArray(double [] data){
        for (int i = 0; i < data.length; i++) {
            Random random = new Random();

            data[i]=random.nextDouble(10);
            //System.out.println(data[i]);
        }
    }

    //Create a Generate Data object, fill array, create other source objects and collect time for sorts.
    public static void main(String[] args) {

        GenerateData gd = new GenerateData();
        double [] data = gd.data10;
        gd.fillArray(data);
        BubbleSort sort = new BubbleSort();
        MergeSort sort2 = new MergeSort();
        InsertionSort sort3 = new InsertionSort();
        long start = System.currentTimeMillis();
        //sort.sort(data);
        sort.sort(data);
        long end = System.currentTimeMillis();
        System.out.println("Time: "+(end-start)+"ms");
        /*for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }*/

    }
}
