package sortof;

import sortof.sortingClasses.InsertionSort;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * InsertionSort-luokan JUnit-testit
 * 
 * @author Antti Rantapelkonen
 */
public class InsertionSortTest {

    public InsertionSort sorter;
    public int[] empty, oneElement, ordered, unordered;

    
    public InsertionSortTest() {
    }

    @Before
    public void setUp() {
        sorter = new InsertionSort();
        this.empty = new int[]{};
        this.oneElement = new int[]{1};
        this.ordered = new int[]{-5, -2, 0, 2, 5};
        this.unordered = new int[]{5, 2, -5, -2, 0};
    }


    /**
     * Tyhjän taulukon järjestäminen toimii.
     */
    @Test
    public void worksWithEmpty() {

        sorter.sort(empty);

        assertArrayEquals(new int[]{}, this.empty);
    }

    /**
     * Järjestäminen toimii taulukolle jossa on vain yksi alkio.
     */
    @Test
    public void worksWithOneElement() {
        sorter.sort(oneElement);

        assertArrayEquals(new int[]{1}, this.oneElement);
    }

    /**
     * Järjestyksessä olevan taulukon järjestäminen toimii.
     */
    @Test
    public void worksWithOrdered() {
        sorter.sort(ordered);

        assertArrayEquals(new int[]{-5, -2, 0, 2, 5}, ordered);
    }

    /**
     * Epäjärjestyksessä olevan taulukon järjestäminen toimii.
     */
    @Test
    public void sortsUnorderedList() {
        sorter.sort(unordered);

        assertArrayEquals(new int[]{-5, -2, 0, 2, 5}, unordered);
    }

}
