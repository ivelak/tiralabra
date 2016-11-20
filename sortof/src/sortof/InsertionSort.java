
package sortof;

/**
 * InsertionSort-algoritmin toteuttava luokka.
 **/
public class InsertionSort {

    int[] list;

    /**
     * Konstruktori saa parametrikseen taulukon lukuja
     * @param listToBeSorted parametrina saatava taulukko
     *
     */
    public InsertionSort(int[] listToBeSorted) {

        this.list = listToBeSorted;

    }

  /**
   * sort()-metodi palauttaa järjestetyn taulukon.
   * @return palauttaa järjestetyn taulukon
   */  
    public int[] sort() {

        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j;

            for (j = i - 1; j >= 0 && temp < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;
        }
        return list;
    }
    

}
