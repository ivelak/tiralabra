
package sortof;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comparator-luokan testit.
 *
 * @author Antti Rantapelkonen
 */
public class ComparatorTest {
    Comparator comp;
    public ComparatorTest() {
    }
    
    @Before
    public void setUp() {
        comp=new Comparator(100, 10);
        comp.run();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * createRandomArray-metodin testi.
     */
    @Test
    public void getRandomArrayReturnsArrayWithDemandedLength() {
        
        assertEquals(100, comp.getArrayToSort().length);
    }
    
    /**
     * Ajan tallennuksen testi metodeille runInsertion, runMerge, runQuick.
     */
    @Test
    public void algorithmRunMethodsInitializeAverageTimes(){
        assertNotNull(comp.getInsertionAverage());
        assertNotNull(comp.getMergeAverage());
        assertNotNull(comp.getQuickAverage());
    }
    
    /**
     * reverse-metodin testi.
     */
    @Test
    public void reverseWorks(){
        int[] temp = new int[] {1,2,3,4,5,6,7};
        comp.reverse(temp);
        assertArrayEquals(new int[]{7,6,5,4,3,2,1}, temp);
    }
    
    
}
