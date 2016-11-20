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
public class MergeSort {

    public MergeSort() {
    }

    /**
     * @param int[] list
     * 
     * sort(int[] list)-metodi on toteutettu sitä varten, että luokan ulkopuolelta kutsuttaessa ei tarvitse antaa parametriksi muuta kuin pelkkä taulukko.
     * Metodi jatkaa kutsumalla varsinaista mergeSort-metodia määrittelemällä parametrit first ja last
     */
    public void sort(int[] list) {
        mergeSort(list, 0, list.length);
    }

    /**
     * @param int[] list
     * @param int first
     * @param int last
     * 
     * mergeSort(int[] list, int first, int last) saa jakaa taulukon
     * (kuvitteellisesti) pieniin osiin ja kutsuu itseään rekursiivisesti niin
     * kauan kunnes kuvitteellisella taulukolla on enää yksi alkio jäljellä
     * (jolloin se on luonnollisesti järjestetty). Metodi kutsuu merge-metodia
     * taulukoiden yhdistämiseksi.
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
     * @param list
     * @param first
     * @param mid
     * @param last 
     * 
     * merge(int[] list, int first, int mid, int last) vertaa taulukon list first->(mid-1) ja (mid->(last-1)) alkioita keskenään,
     * ja luo niistä järjestetyn taulukon newlist[]. Lopuksi metodi kopioi alkiot suuruusjärjestyksessä aluperäiseen taulukkoon list lokaatioille first-last
     */
    private void merge(int[] list, int first, int mid, int last) {
        //yhdistää taulukon list[first - mid-1] ja taulukon list[mid-last-1]
        int leftpos = first;
        int rightpos = mid;
        int newpos = 0;
        int[] newList = new int[last - first];
        while (leftpos < mid && rightpos <= (last - 1)) {
            if (list[leftpos] <= list[rightpos]) {
                newList[newpos] = list[leftpos];
                leftpos++;
                newpos++;
            } else {
                newList[newpos] = list[rightpos];
                rightpos++;
                newpos++;
            }
        }
        // kopioidaan loput vasemmalta puolelta uuteen listaan mikäli sieltä jotain löytyy.
        // Tässä oletetaan että oikea puoli on jo koluttu loppuun ja vasemmalle mahdollisesti jäi vielä jotain.
        while (leftpos < mid) {
            newList[newpos] = list[leftpos];
            newpos++;
            leftpos++;
        }
        // kopioidaan loput oikealta puolelta uuteen listaan mikäli sieltä jotain löytyy.
        // Tässä oletetaan että vasen puoli on jo koluttu loppuun ja oikealle mahdollisesti jäi vielä jotain.
        while (rightpos <= (last - 1)) {
            newList[newpos] = list[rightpos];
            newpos++;
            rightpos++;
        }
        // kopioidaan järjestetty newList[] alkuperäisen taulukon paikoille list[first - last-1]
        int oldpos = first;
        for (int i = 0; i < newList.length; i++) {
            list[oldpos] = newList[i];
            oldpos++;
        }
    }

}
