package sortof;

import java.util.Arrays;
import java.util.Collections;
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

    public static void reverse(int[] array) {
        int temp;

        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UI ui=new UI();
        ui.run();
        
        
    }

}
