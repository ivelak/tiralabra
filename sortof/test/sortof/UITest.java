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
 * UI luokan testit
 *
 * @author Antti Rantapelkonen
 */
public class UITest {

    UI ui;

    public UITest() {
    }

    @Before
    public void setUp() {
        ui = new UI();
    }

    
    @Test
    public void isNumericReturnsFalseForAlphapeticCharacters() {
        Boolean shouldBeFalse = ui.isNumeric("abc");
        assertFalse(shouldBeFalse);
        
    }
    @Test
    public void isNumericReturnsTrueForNumeric(){
        Boolean shouldBeTrue = ui.isNumeric("100");
        assertTrue(shouldBeTrue);
        
    }

}
