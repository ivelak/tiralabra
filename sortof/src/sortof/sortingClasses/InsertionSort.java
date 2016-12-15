
package sortof.sortingClasses;

/**
 * InsertionSort-algoritmin toteuttava luokka.
 * 
 **/
public class InsertionSort {

    long executionTime;

    /**
     * Luokan konstruktori ei saa parametreja.
     *
     */
    public InsertionSort() {
    }
    
    /**
     * sort(int[] list)-metodi on toteutettu sitä varten, että luokan
     * ulkopuolelta kutsuttaessa ei tarvitse antaa parametriksi muuta kuin
     * pelkkä taulukko Metodi jatkaa kutsumalla varsinaista insertionSort-metodia,
     * Metodin sisällä mitataan suoritukseen kuluva aika millisekunteina, ja talletetaan 
     * se kutsumalla setExecutionTime()-metodia.
     *
     * @param list järjestettävä taulukko
     *
     */
    public void sort(int[] list){
        long startTime = System.currentTimeMillis();
        insertionSort(list);
        long stopTime = System.currentTimeMillis();
        setExecutionTime(stopTime - startTime);
    }

  /**
   * sort()-metodi järjestää taulukon InsertionSort-algoritmilla.
   * @param list järjestettävä taulukko
   */  
    private void insertionSort(int[] list) {

        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j;

            for (j = i - 1; j >= 0 && temp < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;
        }
    }

    private void setExecutionTime(long time) {
        this.executionTime=time;
    }
    public long getExecutionTime(){
        return this.executionTime;
    }
    

}
