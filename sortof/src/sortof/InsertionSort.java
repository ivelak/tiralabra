/**
 * Luokan InsertionSort konstruktorin parametrina tulee taulukko lukuja, jotka luokan metodi sort() 
 * järjestää pienimmästä suurimpaan Insertion Sort järjestysalgoritmia käyttäen.
 **/
package sortof;

public class InsertionSort {

    int[] list;

    /**
     * Konstruktori saa parametrikseen taulukon lukuja
     * @param array 
     */
    public InsertionSort(int[] array) {

        this.list = array;

    }

  /**
   * sort()-metodi palauttaa järjestetyn taulukon.
   * @return array
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
