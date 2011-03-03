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
public class ProductDiscountTest {
	float testValue = 1.5f;
	ProductDiscount pDiscount = null;

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
		pDiscount = new ProductDiscount(testValue);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pDiscount = null;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testDiscount() throws Exception {
		Assert.assertEquals(testValue, pDiscount.discount(), 0);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testDiscountMessage() throws Exception {
		String expected = "\tProduct Discount: ";
		Assert.assertEquals(expected, pDiscount.discountMessage());
	}
}
