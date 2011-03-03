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
public class TMVATTest {
	TMVAT tmvat = null;
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
		tmvat = new TMVAT();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tmvat = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testAfterTaxPrice() throws Exception {
		float expected = 0.1f;
		
		Assert.assertEquals(expected, tmvat.afterTaxPrice(expected), 0);
	}
}
