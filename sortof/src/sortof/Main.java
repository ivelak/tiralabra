package sortof;

import java.util.Arrays;
import java.util.Collections;
import sortof.sortingClasses.QuickSort;
import sortof.sortingClasses.InsertionSort;
import sortof.sortingClasses.MergeSort;
import java.util.Random;

/**
 * Main-luokka käynnistää tekstikäyttöliittymän UI.
 *
 * @author Antti Rantapelkonen
 *
 *
 */
public class Main {

    
   

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
