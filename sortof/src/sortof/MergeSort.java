package sortof;

/**
 * MergeSort järjestysalgoritmin toteuttava luokka
 *
 * @author Antti Rantapelkonen
 *
 */
public class MergeSort {

    /**
     * Luokan konstruktori ei saa parametrikseen mitään.
     */
    public MergeSort() {
    }

    /**
     * sort(int[] list)-metodi on toteutettu sitä varten, että luokan
     * ulkopuolelta kutsuttaessa ei tarvitse antaa parametriksi muuta kuin
     * pelkkä taulukko Metodi jatkaa kutsumalla varsinaista mergeSort-metodia
     * määrittelemällä parametrit first ja last.
     *
     * @param list järjestettävä taulukko
     *
     */
    public void sort(int[] list) {
        mergeSort(list, 0, list.length);
    }

    /**
     * mergeSort(int[] list, int first, int last) saa jakaa taulukon
     * (kuvitteellisesti) pieniin osiin ja kutsuu itseään rekursiivisesti niin
     * kauan kunnes kuvitteellisella taulukolla on enää yksi alkio jäljellä
     * (jolloin se on luonnollisesti järjestetty). Metodi kutsuu merge-metodia
     * taulukoiden yhdistämiseksi.
     *
     * @param int[] list metodissa koko ajan mukana kuljetettava kokonainen
     * taulukko
     * @param int first alkulokaatio taulukossa
     * @param int last loppulokaatio taulukossa
     * @return Nothing
     *
     */
    private void mergeSort(int[] list, int first, int last) {
        if (last - first > 1) {
            int mid = (first + last) / 2;
            mergeSort(list, first, mid);
            mergeSort(list, mid, last);
            merge(list, first, mid, last);
        }

    }

    /**
     *
     * merge(int[] list, int first, int mid, int last) vertaa taulukon list
     * first->(mid-1) ja (mid->(last-1)) alkioita keskenään, ja luo niistä
     * järjestetyn taulukon newlist[] 
     * Lopuksi metodi kopioi alkiot
     * suuruusjärjestyksessä aluperäiseen taulukkoon list lokaatioille
     * first-last.
     * 
     * @param list mukana pidettävä koko taulukko
     * @param first yhdistettävien taulukonosien ensimmäinen alkio
     * @param mid yhdistettävien taulukonosien keskimmäinen alkio
     * @param last yhdistettävien taulukonosien viimeinen alkio
     * @return Nothing
     *
     * 
     */
    private void merge(int[] list, int first, int mid, int last) {
        //yhdistää taulukon list[first - mid-1] ja taulukon list[mid-last-1]
        int left = first;
        int right = mid;
        int newpos = 0;
        int[] newList = new int[last - first];
        while (left < mid && right <= (last - 1)) {
            if (list[left] <= list[right]) {
                newList[newpos] = list[left];
                left++;
                newpos++;
            } else {
                newList[newpos] = list[right];
                right++;
                newpos++;
            }
        }
        // kopioidaan loput vasemmalta puolelta uuteen listaan mikäli sieltä jotain löytyy.
        // Tässä oletetaan että oikea puoli on jo koluttu loppuun ja vasemmalle mahdollisesti jäi vielä jotain.
        while (left < mid) {
            newList[newpos] = list[left];
            newpos++;
            left++;
        }
        // kopioidaan loput oikealta puolelta uuteen listaan mikäli sieltä jotain löytyy.
        // Tässä oletetaan että vasen puoli on jo koluttu loppuun ja oikealle mahdollisesti jäi vielä jotain.
        while (right <= (last - 1)) {
            newList[newpos] = list[right];
            newpos++;
            right++;
        }
        // kopioidaan järjestetty newList[] alkuperäisen taulukon paikoille list[first - last-1]
        int oldpos = first;
        for (int i = 0; i < newList.length; i++) {
            list[oldpos] = newList[i];
            oldpos++;
        }
    }

}
