package sortof;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Antti Rantapelkonen
 */
public class UI {

    private Comparator comp;
    private Scanner scan;

    public UI() {
        this.scan = new Scanner(System.in);

    }

    public void run() {
        int size;
        int executions;

        System.out.println("Tervetuloa käyttämään Sortof-ohjelmaa! \n "
                + "\n"
                + "Ohjelma generoi haluamasi kokoisen taulukon satunnaisessa järjestyksessä olevaista kokonaisluvuista, \n "
                + "ja suorittaa järjestysalgoritmit InsertionSort, QuickSort ja MergeSort. \n"
                + "Voit myös päättää montako kertaa taulukko järjestetään. \n"
                + "\n"
                + "Lopuksi ohjelma tulostaa kunkin algoritmin keskimääräisen suoritusajan. \n"
                + "\n"
                + "Ohjelman voi lopettaa syöttämällä -1. \n");

        while (true) {

            size = readSize();

            if (size == -1) {
                System.out.println("Heippa...");
                break;
            }
            executions = readExecutions();
            if (executions == -1) {
                System.out.println("Heippa...");
                break;
            }

            comp = new Comparator(size, executions);
            comp.run();

        }
    }

    private int readSize() {
        int size;
        while (true) {

            System.out.print("Syötä taulukon koko välillä 0-10000 (-1 lopettaa): ");
            String input=scan.nextLine();
            
            if (input.equals("") || !isNumeric(input)){               
                continue;
            }
                       
            size = Integer.parseInt(input);
            

            if (size == -1) {
                return size;
            } else if (size > 0 && size <= 10000) {
                break;
            } else {
                System.out.println("Syötit virheellisen arvon!");
                System.out.println("");
            }
        }
        return size;
    }

    private int readExecutions() {
        int exec;
        while (true) {
            System.out.print("Syötä suoritusten määrä välillä 1-10000: ");
            String input  = scan.nextLine();
            if (input.equals("") || !isNumeric(input)){               
                continue;
            }
                       
            exec = Integer.parseInt(input);
            
            if (exec == -1) {
                return exec;
            } else if (exec >= 1 && exec <= 10000) {
                break;
            } else {
                System.out.println("Syötit virheellisen arvon!");
                System.out.println("");
                
            }
        }
        return exec;
    }
    
    private boolean isNumeric(String input){
        try
        {
            int a = Integer.parseInt(input);
            
        }
        catch(NumberFormatException e){
            return false;
        } 
        return true;
    }

}
