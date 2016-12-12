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

   
    private double insertionAverage;
    private double mergeAverage;
    private double quickAverage;

    private int[] arrayToSort;
    private int arrayLength;
    private int executions;

    public Comparator(int lengthOfArray, int howManyExecutions) {

        this.arrayLength = lengthOfArray;
        this.executions = howManyExecutions;
        this.arrayToSort = createRandomArray(lengthOfArray);
    }
    
    public Comparator(int[] givenArray, int howManyExecutions) {
        
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
        InsertionSort insert;
        long timeSum = 0;
        System.out.print("    (InsertionSort...");
        for (int i = 0; i < executions; i++) {
            insert=new InsertionSort();
            int[] temp = this.arrayToSort.clone();
            insert.sort(temp);
            
            timeSum += insert.getExecutionTime();
            //System.out.println("time: " + insert.getExecutionTime() + " SUM: " + timeSum);
        }
        insertionAverage = (double)timeSum / executions;
        System.out.println("100%)");
    }

    private void runMerge() {
        MergeSort merge;
        long timeSum = 0;
        System.out.print("        (MergeSort...");
        for (int i = 0; i < executions; i++) {
            merge=new MergeSort();
            int[] temp = this.arrayToSort.clone();
            merge.sort(temp);
            
            timeSum += merge.getExecutionTime();
            //System.out.println("time: " + merge.getExecutionTime() + " SUM: " + timeSum);
        }
        mergeAverage = (double)timeSum / executions;
        System.out.println("100%)");
    }

    private void runQuick() {
        QuickSort quick;
        long timeSum = 0;
        System.out.print("            (QuickSort...");
        for (int i = 0; i < executions; i++) {
            quick=new QuickSort();
            int[] temp = this.arrayToSort.clone();
            quick.sort(temp);
            
            timeSum += quick.getExecutionTime();
            //System.out.println("time: " + quick.getExecutionTime() + " SUM: " + timeSum);
        }
        quickAverage = (double)timeSum / executions;
        System.out.println("100%)");
    }

    public void run() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Suorituksessa oleva algoritmi:");

        runInsertion();
        runMerge();
        runQuick();

        System.out.println("\n Järjestysalgoritmit suoritettu " + this.executions + " kertaa " + this.arrayLength + " kokoiselle taulukolle \n"
                + "\n" + "Algoritmien keskimääräiset suoritusajat millisekunteina: \n\n"
                + "InsertionSort: " + this.insertionAverage + "\n"
                + "MergeSort: " + this.mergeAverage + "\n"
                + "QuickSort: " + this.quickAverage + "\n");
    }

    private void printArray(int[] array) {
        for (int b : array) {
            System.out.print(b + " ");
        }
        System.out.println("");
    }

}
