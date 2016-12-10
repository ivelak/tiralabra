package sortof;

import java.util.Random;

/**
 * Projektin Main-luokka sisältää toistaiseksi vain testikoodia, mutta tänne
 * toteutetaan pääohjelma jonka käynnistyttyä voidaan valita eri
 * järjestysalgoritmeja, järjestää syöte näiden menetelmillä, ja nähdä
 * vertailtavia tuloksia menetelmien tehokkuudesta.
 *
 * @author Antti Rantapelkonen
 *
 *
 */
public class Main {

    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] test = {2, 4, 3, 6, 5, 9, 1, 12, 15, -1, 0, 7};
        int[] test2 = {5, 2, -5, -2, 0};
        //int[] test = {7,1,3,2,6,4};

//        InsertionSort sorting = new InsertionSort(test);
//        int[] sortedTest = sorting.sort();
//        
//        for (int u : sortedTest) {
//            System.out.print(u+" ");
//            
//        }
//        System.out.println("");
//        
//        MergeSort yhdisys = new MergeSort();
//        yhdisys.sort(test);
        int[] random = createRandomArray(10000);

        QuickSort quick = new QuickSort();
        MergeSort merge = new MergeSort();
        InsertionSort insert = new InsertionSort();

        for (int u : random) {
            System.out.print(u + " ");

        }
        System.out.println("");
        
        int[] q=random;
        int[] m=random;
        int[] i=random;

//        quick.sort(q);
//
//        for (int u : q) {
//            System.out.print(u + " ");
//        }
//        System.out.println("");
//        System.out.println("QuickSort: " + quick.getExecutionTime());
//        System.out.println("");
//        
//        merge.sort(m);
//        
//        for (int u : m) {
//            System.out.print(u + " ");
//        }
//        System.out.println("");
//        System.out.println("MergeSort: " + merge.getExecutionTime());
//        System.out.println("");
        
        insert.sort(i);
        
        for (int u : i) {
            System.out.print(u + " ");
        }
        System.out.println("");
        System.out.println("InsertionSort: " + insert.getExecutionTime());
        System.out.println("");
        
    }

}
