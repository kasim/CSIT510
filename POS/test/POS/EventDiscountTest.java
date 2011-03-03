/**
 * 
 */
package POS;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

/**
 * @author kasim
 *
 */
public class EventDiscountTest {
	float testValue = 1.5f;
	EventDiscount eDiscount = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		eDiscount = new EventDiscount(testValue);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		eDiscount = null;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testDiscount() throws Exception {
		float expected = testValue; 
		Assert.assertEquals(expected, eDiscount.discount(), 0);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testDiscountMessage() throws Exception {
		String expected = "\tEvent Discount: " + eDiscount.discount()*100 + "%" + "\n";
		
		Assert.assertEquals(expected, eDiscount.discountMessage());
	}
}
