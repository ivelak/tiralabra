package sortof;

import sortof.sortingClasses.MergeSort;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MergeSort-luokan JUnit-testit
 *
 * @author Antti Rantapelkonen
 */
public class MergeSortTest {

    public MergeSort sorter;
    public int[] empty, oneElement, ordered, unordered;
    

    public MergeSortTest() {
    }

    @Before
    public void setUp() {
        sorter=new MergeSort();
        this.empty = new int[]{};
        this.oneElement = new int[]{1};
        this.ordered = new int[]{-5, -2, 0, 2, 5};
        this.unordered = new int[]{5, 2, -5, -2, 0};
        
    }


    /**
     * Testaa toimiiko tyhjän taulukon järjestäminen.
     */
    @Test
    public void worksWithEmpty() {
        
        sorter.sort(empty);
        
        assertArrayEquals(new int[]{}, empty);
    }
    
    /**
     * Testaa toimiiko järjestäminen taulukolle jossa on vain yksi alkio.
     */
    @Test
    public void worksWithOneElement(){
        sorter.sort(oneElement);
        
        assertArrayEquals(new int[]{1}, oneElement);
    }
    /**
     * Testaa toimiiko valmiiksi järjestyksessä olevan taulukon järjestäminen.
     */
    @Test
    public void worksWithOrdered(){
        sorter.sort(ordered);
        
        assertArrayEquals(new int[]{-5, -2, 0, 2, 5}, ordered);
    }
    /**
     * Testaa toimiiko epäjärjestyksessä olevan taulukon järjestäminen.
     */
    @Test
    public void sortsUnorderedList(){
        sorter.sort(unordered);
        
        assertArrayEquals(new int[]{-5, -2, 0, 2, 5}, unordered);
    }

}
