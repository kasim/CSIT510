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
public class CustomerDiscountTest {
	float testValue = 1.5f;
	CustomerDiscount cDiscount = null;

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
		cDiscount = new CustomerDiscount(1.5f);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cDiscount = null;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testDiscount() throws Exception {
		Assert.assertEquals(testValue, cDiscount.discount(), 0);
	}

	/**
	 * 
	 */
	@Test
	public void testDiscountMessage() throws Exception {
		String expected = "\tMembership Discount: " + cDiscount.discount()*100 + "%" + "\n";
		
		Assert.assertEquals(expected, cDiscount.discountMessage());
	}
}
