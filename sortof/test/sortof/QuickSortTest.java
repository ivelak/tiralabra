/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortof;

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
public class QuickSortTest {
    private QuickSort sorter;
    private int[] list;
    public int[] empty;
    public int[] oneElement;
    public int[] ordered;
    public int[] unordered;
    
    public QuickSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.sorter = new QuickSort();
        this.list = new int[]{6,1,7,3,4,2,5};       
        this.empty = new int[]{};
        this.oneElement = new int[]{1};
        this.ordered = new int[]{-5, -2, 0, 2, 5};
        this.unordered = new int[]{5, 2, -5, -2, 0};
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testaa swap-metodin toimivuuden, eli vaihtaako metodi annettujen indeksien mukaisten alkioiden paikkaa päittäin.
     */
    @Test
    public void swappingWorks(){
        
        int [] swapped=list;
        this.sorter.swap(swapped, 1, 5);
        
        assertArrayEquals(new int[]{6,2,7,3,4,1,5}, swapped);       
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
