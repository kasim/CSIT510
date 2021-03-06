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
public class CurrencyTest {
	Currency c = null;
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
		c = new MockCurrency();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		c = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testShow() throws Exception {
		String expected = "test$";
		Assert.assertEquals(expected, c.show());
	}
	
	private class MockCurrency extends Currency{	
		@Override
		public String show() {
			String actual = "test$";
			return actual;
		}
	}
}