package sortof.sortingClasses;

/**
 * Quicksort järjestysalgoritmin toteuttava luokka.
 *
 *
 */
public class QuickSort {
    private long executionTime;

    /**
     * Luokan konstruktori ei saa parametreja.
     */
    public QuickSort() {
    }
    
    /**
     * sort(int[] list)-metodi on toteutettu sitä varten, että luokan
     * ulkopuolelta kutsuttaessa ei tarvitse antaa parametriksi muuta kuin
     * pelkkä taulukko Metodi jatkaa kutsumalla varsinaista mergeSort-metodia
     * määrittelemällä parametrit first ja last, Metodin sisällä mitataan järjestämiseen kuluva aika ja asetetaan se
     * luokan parametriin executionTime kutsumalla setExecutionTime()-metodia.
     *
     * @param list järjestettävä taulukko
     *
     */
    public void sort(int[] list){
        long startTime = System.currentTimeMillis();
        quickSort(list, 0, list.length-1);
        long stopTime = System.currentTimeMillis();
        setExecutionTime(stopTime - startTime);
    }
    
    /**
     * quickSort - metodi saa sarana-alkiokseen (pivot) taulukon ensimmäisen alkion, Menetelmä vertaa 
     * taulukon alkioita siihen, ja siirtää pienemmät vasemmalle puolelle ja isommat oikealle puolelle taulukon osituksessa,
     * Metodi kutsuu itseään rekursiivisesti taulukon pienemmillä osilla niin kauan että kutsuttavissa osissa on enää maksimissaan
     * kaksi alkiota jäljellä, Tämän jälkeen taulukko on järjestyksessä.
     * 
     * @param list järjestettävä taulukko
     * @param first taulukon (tai sen järjestettävän osan) ensimmäinen indeksi
     * @param last taulukon (tai sen järjestettävän osan) viimeinen indeksi
     */
    public void quickSort(int[] list, int first, int last){
        
        int left = first;
        int right = last;
        
        if (last - first >= 1){
            int pivot = list[first];
            
            while (right > left){
                while (list[left] <= pivot && left<= last && right > left){
                    left++;
                }
                while (list[right] > pivot && right >= first && right >= left){
                    right--;
                }
                if (right>left){
                    swap(list, left, right);
                }
            }
            swap(list, first, right);
            
            //System.out.println("first: "+first+" right: "+right + " last: "+last);
            quickSort(list, first, right-1);
            quickSort(list, right+1, last);
        }
    }
    
    
    /**
     * swap-metodi vaihtaa parametrien first ja second paikat keskenään taulukossa list.
     * 
     * @param list järjestettävä taulukko
     * @param first ensimmäinen
     * @param second toinen
     */
    public void swap(int[] list, int first, int second){
        int temp = list[first];
        list[first]=list[second];
        list[second]=temp;
    }

    private void setExecutionTime(long time) {
        this.executionTime=time;
    }

    public long getExecutionTime() {
        return executionTime;
    }
    
    
}
