Sorting Algorithms Comparison Project 
===================================== 
This project implements multiple sorting algorithms and compares their performance by measuring and printing their runtimes. Implemented Algorithms: 
- BubbleSort 
- MergeSort 
- InsertionSort
 - QuickSort 
- SelectionSort 
- FastMergeSort (an optimized version of merge sort) 

FastMergeSort: FastMergeSort is an alternate implementation of the traditional merge sort algorithm. It optimizes the sorting process by: 
1. Using a threshold (THRESHOLD = 64) to switch to insertion sort for small subarrays, which is more efficient for small datasets. 
2. Avoiding unnecessary merges when a subarray is already sorted (checks if arr[mid] <= arr[mid + 1]). 
3. Using a temporary array to reduce the number of array copies during the merge process.These optimizations can lead to improved performance, especially for partially sorted arrays or arrays with many duplicates. 

Note: This algorithm is slightly faster for smaller datasets but becomes much faster as the input datasets increase in size. Bubble sort may take 5-10 minutes to process 500,000 cells of data on a Mac M1 chip.

How to Use: 
1. Download the project files: GenerateData.java and FastMergeSort.java 
2. Compile the Java files: javac GenerateData.java FastMergeSort.java 
3. Run the GenerateData class: java GenerateData The program will automatically: 
- Generate random datasets of various sizes (from 50,000 to 500,000 elements) 
- Apply each sorting algorithm to one of the data sets (default 50,000 cell size, can be changed within the code)
- Print the runtime for each algorithm 

To change data size: 
1. Open GenerateData.java 
2. Locate the line: double[] data = gd.data1; 
3. Change data1 to data2, data3, etc., to test with different dataset sizes 
4. Run the program again to see how the algorithms perform with larger datasets 

To view the sorted data (for verification): 
1. Locate the line: // Good place to call printSortedData() 
2. Add the following line below it: printSortedData(data, sortNames[i]); 
3. Adjust the 'rows' variable in the printSortedData method to control how many sorted elements to display Note: Sorting larger datasets (e.g., 500,000 elements) may take several minutes, especially for less efficient algorithms like Bubble Sort. Enjoy comparing the performance of different sorting algorithms and exploring the optimized FastMergeSort implementation!

This project was apart of the CS245 course at University of San Francisco Spring 2022
