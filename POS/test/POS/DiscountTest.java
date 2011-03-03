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
public class DiscountTest {
	MockDiscount mDiscount = null;
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
		mDiscount = new MockDiscount();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		mDiscount = null;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testDiscount() throws Exception {
		float expected = 0.1f;
		mDiscount.setDiscount(expected);
		Assert.assertEquals(expected, mDiscount.discount(), 0.0);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testDiscountMessage() throws Exception {
		String expected = "Test";
		mDiscount.setDiscountMessage(expected);
		Assert.assertEquals(expected, mDiscount.discountMessage());
	}
	
	private class MockDiscount implements Discount{
		private float discount;
		private String discountMessage;
		
		public float getDiscount() {
			return this.discount;
		}

		public void setDiscount(float discount) {
			this.discount = discount;
		}

		public String getDiscountMessage() {
			return this.discountMessage;
		}

		public void setDiscountMessage(String discountMessage) {
			this.discountMessage = discountMessage;
		}
		
		public MockDiscount(){
			this(0.0f, "");
		}
		
		public MockDiscount(float discount, String discountMessage){
			setDiscount(discount);
			setDiscountMessage(discountMessage);
		}
		
		@Override
		public float discount() {
			return getDiscount();
		}

		@Override
		public String discountMessage() {
			return getDiscountMessage();
		}
	}
}
