/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortof;

/**
 *
 * @author antti
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] test = {2,4,3,6,5,9,1};
        for (int u : test) {
            System.out.print(u+" ");
            
        }
        System.out.println("");
        InsertionSort sorting = new InsertionSort(test);
        int[] sortedTest = sorting.sort();
        
        for (int u : sortedTest) {
            System.out.print(u+" ");
            
        }
        System.out.println("");
    }
    
}
