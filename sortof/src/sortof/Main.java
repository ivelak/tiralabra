package sortof;

import sortof.sortingClasses.QuickSort;
import sortof.sortingClasses.InsertionSort;
import sortof.sortingClasses.MergeSort;
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

        Comparator comp = new Comparator(100000, 10);
        comp.run();
        
    }

}
