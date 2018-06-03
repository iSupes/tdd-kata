package tdd.kata.calc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tdd.kata.calc.Calculator;

/**
 * Test class for Calculator.java
 * @author Khalil Hassim
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd0() {
        String numbers = "";
        assertEquals(Calculator.add(numbers), 0);
    }
    
    @Test
    public void testAddSpaces() {
        String numbers = "   ";
        assertEquals(Calculator.add(numbers), 0);
    }
    
    @Test
    public void testAdd1() {
        String numbers = "1";
        assertEquals(Calculator.add(numbers), 1);
    }
    
    @Test
    public void testAdd2() {
        String numbers = "1,2";
        assertEquals(Calculator.add(numbers), 3);
    }
    
    @Test
    public void testAddMany() {
        String numbers = "1,2,3,4,5,6,7,8,9,10,11";
        assertEquals(Calculator.add(numbers), 66);
    }
    
}
