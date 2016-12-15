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

    /**
     * Ensimmäinen konstruktori on varsinaista käyttöliittymää varten.
     * Konstruktori alustaa määritettävän taulukon pituusparametrin avulla kutsumalla createRandomArray-metodia.
     * 
     * @param lengthOfArray käyttäjä päättää järjestettävän taulukon koon.
     * @param howManyExecutions  Käyttäjä päättää monestikko taulukko järjestetään mittaustulosten tarkkuuden parantamiseksi
     */
    public Comparator(int lengthOfArray, int howManyExecutions) {

        this.arrayLength = lengthOfArray;
        this.executions = howManyExecutions;
        this.arrayToSort = createRandomArray(lengthOfArray);
    }
    
    /**
     * Toinen konstruktori on luotu testausdataa varten. Siinä parametrinä annetaan valmis taulukko.
     * @param givenArray Järjestettävä taulukko
     * @param howManyExecutions Käyttäjä päättää monestikko taulukko järjestetään mittaustulosten tarkkuuden parantamiseksi
     */
    public Comparator(int[] givenArray, int howManyExecutions) {
        
        this.arrayLength = givenArray.length;
        this.executions = howManyExecutions;
        this.arrayToSort = givenArray;
    }

    /**
     * Metodi saa parametrina pituuden ja palauttaa random taulukon.
     * @param length
     * @return array
     */
    private int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    public int[] getArrayToSort() {
        return arrayToSort;
    }

    public double getInsertionAverage() {
        return insertionAverage;
    }

    public double getMergeAverage() {
        return mergeAverage;
    }

    public double getQuickAverage() {
        return quickAverage;
    }
    

    /**
     * Ajaa InsertionSort-algoritmin konstruktorissa alustetun executions-muuttujan lukumäärän verran, Metodi laskee keskimääräisen 
     * suoritusajan ja tallettaa sen insertionAverage muuttujaan.
     */
    private void runInsertion() {
        InsertionSort insert;
        long timeSum = 0;
        System.out.print("    (InsertionSort...");
        for (int i = 0; i < executions; i++) {
            insert=new InsertionSort();
            int[] temp = this.arrayToSort.clone();
            insert.sort(temp);
            
            timeSum += insert.getExecutionTime();
        }
        insertionAverage = (double)timeSum / executions;
        System.out.println("100%)");
    }

    /**
     * Ajaa MergeSort-algoritmin konstruktorissa alustetun executions-muuttujan lukumäärän verran, Metodi laskee keskimääräisen 
     * suoritusajan ja tallettaa sen mergeAverage muuttujaan.
     */
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

    /**
     * Ajaa QuickSort-algoritmin konstruktorissa alustetun executions-muuttujan lukumäärän verran, Metodi laskee keskimääräisen 
     * suoritusajan ja tallettaa sen quickAverage muuttujaan.
     */
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

    /**
     * Käynnistää kootusti kaikkien järjestysalgoritmien ajometodit ja tulostaa järjestettävän 
     * taulukon pituuden, suorituskertojen määrän ja kunkin algoritmin keskimääräisen suoritusajan.
     */
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

    /**
     * Kehityksen aikana käytetty apumetodi taulukon tulostamiseen.
     * @param array 
     */
    private void printArray(int[] array) {
        for (int b : array) {
            System.out.print(b + " ");
        }
        System.out.println("");
    }
    
    /**
     * Kehityksen aikana käytetty apumetodi joka parametrina saadun taulukon järjestyksen päinvastaiseksi.
     * 
     * @param array 
     */
     public void reverse(int[] array) {
        int temp;

        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

}
