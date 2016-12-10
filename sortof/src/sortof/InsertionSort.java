
package sortof;

/**
 * InsertionSort-algoritmin toteuttava luokka.
 **/
public class InsertionSort {

    long executionTime;

    /**
     * Konstruktori saa parametrikseen taulukon lukuja
     * @param listToBeSorted parametrina saatava taulukko
     *
     */
    public InsertionSort() {
    }
    
    public void sort(int[] list){
        long startTime = System.currentTimeMillis();
        insertionSort(list);
        long stopTime = System.currentTimeMillis();
        setExecutionTime(stopTime - startTime);
    }

  /**
   * sort()-metodi palauttaa järjestetyn taulukon.
   * @return palauttaa järjestetyn taulukon
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
