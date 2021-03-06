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
        
    @Test
    public void testAddNewLineDelim() {
        String numbers = "1,2\n5,3";
        assertEquals(Calculator.add(numbers), 11);
    }
    
    @Test
    public void testAddNewLineDelims() {
        String numbers = "1,2\n5,3\n7";
        assertEquals(Calculator.add(numbers), 18);
    }
    
    @Test
    public void testAddCustomDelim() {
        String numbers = "//;\n1;2;7";
        assertEquals(Calculator.add(numbers), 10);
    }
    
    @Test
    public void testAdd1Negative() {
        String numbers = "1,2,-4";
        try{
            Calculator.add(numbers);
        }catch(NumberFormatException nfe){
            assertTrue(nfe.getMessage().contains("-4"));
        }
    }
    
    @Test
    public void testAddManyNegative() {
        String numbers = "1,2,-4,5,-7,-2";
        try{
            Calculator.add(numbers);
        }catch(NumberFormatException nfe){
            assertTrue(nfe.getMessage().contains("-4") && nfe.getMessage().contains("-7") && nfe.getMessage().contains("-2"));
        }
    }
    
    @Test
    public void testAddIgnoreOver1000() {
        String numbers = "1,2,1020";
        assertEquals(Calculator.add(numbers), 3);
    }
    
    @Test
    public void testAddIgnoreMultipleOver1000() {
        String numbers = "1,2,1020,2000,4,1001";
        assertEquals(Calculator.add(numbers), 7);
    }
    
    @Test
    public void testAdd1000() {
        String numbers = "1,2,1000";
        assertEquals(Calculator.add(numbers), 1003);
    }
    
    @Test
    public void testAddLongCustomDelim() {
        String numbers = "//***\n1***2***7";
        assertEquals(Calculator.add(numbers), 10);
    }    
    
    @Test
    public void testAddLongerCustomDelim() {
        String numbers = "//longerDelim\n1longerDelim2longerDelim7";
        assertEquals(Calculator.add(numbers), 10);
    }  
    
    @Test
    public void testAdd2CustomDelim() {
        String numbers = "//[*][%]\n1*2%3";
        assertEquals(Calculator.add(numbers), 6);
    }  
    
    @Test
    public void testAddMultipleCustomDelim() {
        String numbers = "//[*][%][Q]\n1*2%3*10Q11Q5%1009";
        assertEquals(Calculator.add(numbers), 32);
    }  
    
    @Test
    public void testAddCustomDelimSquare() {
        String numbers = "//[\n1[2[7";
        assertEquals(Calculator.add(numbers), 10);
    }
    
    @Test
    public void testAddCustomDelimSquares() {
        String numbers = "//[]\n1[]2[]7";
        assertEquals(Calculator.add(numbers), 10);
    }
    
    @Test
    public void testAddMultipleLongCustomDelim() {
        String numbers = "//[***][longerDelim][Q]\n1***2longerDelim3***10Q11Q5longerDelim1009";
        assertEquals(Calculator.add(numbers), 32);
    }      
}
