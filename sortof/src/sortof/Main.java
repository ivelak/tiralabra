/**
 * Projektin Main-luokka sisältää toistaiseksi vain testikoodia, mutta tänne toteutetaan pääohjelma jonka käynnistyttyä
 * voidaan valita eri järjestysalgoritmeja, järjestää syöte näiden menetelmillä, ja nähdä vertailtavia tuloksia menetelmien tehokkuudesta.
 * 
 **/
package sortof;

/**
 *
 * @author Antti Rantapelkonen
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