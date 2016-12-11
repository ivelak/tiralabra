package sortof;

import java.util.Random;
import sortof.sortingClasses.InsertionSort;
import sortof.sortingClasses.MergeSort;
import sortof.sortingClasses.QuickSort;


/**
 * Comparator-luokka ajaa QuickSort, MergeSort ja InsertionSort luokat kutsussa määritellyn toistomäärän verran halutun kokoiselle random-taulukolle,
 * Luokka laskee suoritusaikojen keskiarvot ja tulostaa ne.
 * 
 * @author antti
 */
public class Comparator {

    private InsertionSort insert;
    private MergeSort merge;
    private QuickSort quick;

    private double insertionAverage;
    private double mergeAverage;
    private double quickAverage;

    private int[] arrayToSort;
    private int arrayLength;
    private int executions;

    public Comparator(int lengthOfArray, int howManyExecutions) {
        this.insert = new InsertionSort();
        this.merge = new MergeSort();
        this.quick = new QuickSort();

        this.arrayLength = lengthOfArray;
        this.executions = howManyExecutions;
        this.arrayToSort = createRandomArray(lengthOfArray);
    }
    
    public Comparator(int[] givenArray, int howManyExecutions) {
        this.insert = new InsertionSort();
        this.merge = new MergeSort();
        this.quick = new QuickSort();

        this.arrayLength = givenArray.length;
        this.executions = howManyExecutions;
        this.arrayToSort = givenArray;
    }

    private int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    private void runInsertion() {

        long timeSum = 0;
        System.out.println("Insertion");
        for (int i = 0; i < executions; i++) {
            int[] temp = this.arrayToSort.clone();
            insert.sort(temp);
            
            timeSum += insert.getExecutionTime();
            System.out.println("time: " + insert.getExecutionTime() + " SUM: " + timeSum);
        }
        insertionAverage = (double)timeSum / executions;
    }

    private void runMerge() {
        long timeSum = 0;
        System.out.println("Merge");
        for (int i = 0; i < executions; i++) {
            int[] temp = this.arrayToSort.clone();
            merge.sort(temp);
            
            timeSum += merge.getExecutionTime();
            System.out.println("time: " + merge.getExecutionTime() + " SUM: " + timeSum);
        }
        mergeAverage = (double)timeSum / executions;
    }

    private void runQuick() {
        long timeSum = 0;
        System.out.println("Quick");
        for (int i = 0; i < executions; i++) {
            int[] temp = this.arrayToSort.clone();
            quick.sort(temp);
            
            timeSum += quick.getExecutionTime();
            System.out.println("time: " + quick.getExecutionTime() + " SUM: " + timeSum);
        }
        quickAverage = (double)timeSum / executions;
    }

    public void run() {

        System.out.println("Järjestettävä taulukko: ");

        runInsertion();
        runMerge();
        runQuick();

        System.out.println("\n Järjestysalgoritmit suoritettu " + this.executions + " kertaa " + this.arrayLength + " kokoiselle taulukolle \n"
                + "\n" + "Algoritmien keskimääräiset suoritusajat millisekunteina: \n\n"
                + "InsertionSort: " + this.insertionAverage + "\n"
                + "MergeSort: " + this.mergeAverage + "\n"
                + "QuickSort: " + this.quickAverage);
    }

    private void printArray(int[] array) {
        for (int b : array) {
            System.out.print(b + " ");
        }
        System.out.println("");
    }

}
