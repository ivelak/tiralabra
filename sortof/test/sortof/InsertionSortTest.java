/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author antti
 */
public class InsertionSortTest {

    public InsertionSort sorter;
    public int[] empty;
    public int[] oneElement;
    public int[] ordered;
    public int[] unordered;

    public InsertionSortTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sorter = new InsertionSort();
        this.empty = new int[]{};
        this.oneElement = new int[]{1};
        this.ordered = new int[]{-5, -2, 0, 2, 5};
        this.unordered = new int[]{5, 2, -5, -2, 0};
    }

    @After
    public void tearDown() {
    }

    /**
     * Tyhjän taulukon järjestäminen toimii
     */
    @Test
    public void worksWithEmpty() {

        sorter.sort(empty);

        assertArrayEquals(new int[]{}, this.empty);
    }

    /**
     * Järjestäminen toimii taulukolle jossa on vain yksi alkio
     */
    @Test
    public void worksWithOneElement() {
        sorter.sort(oneElement);

        assertArrayEquals(new int[]{1}, this.oneElement);
    }

    /**
     * Järjestyksessä olevan taulukon järjestäminen toimii
     */
    @Test
    public void worksWithOrdered() {
        sorter.sort(ordered);

        assertArrayEquals(new int[]{-5, -2, 0, 2, 5}, ordered);
    }

    /**
     * Epäjärjestyksessä olevan taulukon järjestäminen toimii
     */
    @Test
    public void sortsUnorderedList() {
        sorter.sort(unordered);

        assertArrayEquals(new int[]{-5, -2, 0, 2, 5}, unordered);
    }

}
