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
public class TaxModelTest {
	MockTaxModel mTaxModel = null;

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
		mTaxModel = new MockTaxModel();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		mTaxModel = null;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testAfterTaxPrice() throws Exception {
		float expected = 0.1f;
		
		Assert.assertEquals(expected, mTaxModel.afterTaxPrice(expected), 0);
	}
	
	private class MockTaxModel implements TaxModel{
		public MockTaxModel(){
		}
				
		@Override
		public float afterTaxPrice(float price) {
			return price;
		}
	}
}
