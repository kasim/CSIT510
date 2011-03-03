/**
 * 
 */
package POS;


import static org.junit.Assert.fail;

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
public class PaymentTest {
	int size = 10;
	double sum = 100.5d;
	Payment p = null;
	Payment expected = null;
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
		p = new Payment();
		expected = new Payment();
		MockDiscount mDiscount = new MockDiscount();
		for(int i=0; i<=size; i++){
			mDiscount.setDiscount(i*0.1f);
			mDiscount.setDiscountMessage("" + (i*0.1f));
			expected.addDiscount(mDiscount);
			p.addDiscount(mDiscount);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void testPayment() throws Exception {
		Assert.assertEquals(expected.afterDiscount(sum), p.afterDiscount(sum), 0);
		Assert.assertEquals(expected.showDiscount(), p.showDiscount());
	}

	@Test
	public void addDiscount() throws Exception {
		p = new Payment();
		expected = new Payment();
		MockDiscount mDiscount = new MockDiscount();
		for(int i=0; i<=size; i++){
			mDiscount.setDiscount(i*0.1f);
			mDiscount.setDiscountMessage("" + (i*0.1f));
			expected.addDiscount(mDiscount);
			p.addDiscount(mDiscount);
			Assert.assertEquals(expected.afterDiscount(sum), p.afterDiscount(sum), 0);
			Assert.assertEquals(expected.showDiscount(), p.showDiscount());
		}
	}

	@Test
	public void afterDiscount() throws Exception {
		Assert.assertEquals(expected.afterDiscount(sum), p.afterDiscount(sum), 0);
	}

	@Test
	public void showDiscount() throws Exception {
		Assert.assertEquals(expected.showDiscount(), p.showDiscount());
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
