/**
 * 
 */
package POS;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author kasim
 *
 */
public class CompositeDiscountTest {
	int size = 10;
	CompositeDiscount expected = null;
	CompositeDiscount cd = null;
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
		cd = new CompositeDiscount();
		expected = new CompositeDiscount();
		MockDiscount mDiscount = new MockDiscount();
		for(int i=0; i<=size; i++){
			mDiscount.setDiscount(i*0.1f);
			mDiscount.setDiscountMessage("" + (i*0.1f));
			expected.add(mDiscount);
			cd.add(mDiscount);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		expected = null;
		cd = null;
	}

	/**
	 * Test method for {@link POS.CompositeDiscount#CompositeDiscount()}.
	 */
	@Test
	public void testCompositeDiscount() {
		Assert.assertEquals(expected.discount(), cd.discount());
		Assert.assertEquals(expected.discountMessage(), cd.discountMessage());
	}

	/**
	 * Test method for {@link POS.CompositeDiscount#discount()}.
	 */
	@Test
	public void testDiscount() {
		Assert.assertEquals(expected.discount(), cd.discount());
	}

	/**
	 * Test method for {@link POS.CompositeDiscount#add(POS.Discount)}.
	 */
	@Test
	public void testAdd() {
		cd = new CompositeDiscount();
		expected = new CompositeDiscount();
		MockDiscount mDiscount = new MockDiscount();
		for(int i=0; i<=size; i++){
			mDiscount.setDiscount(i*0.1f);
			mDiscount.setDiscountMessage("" + (i*0.1f));
			expected.add(mDiscount);
			cd.add(mDiscount);
			Assert.assertEquals(expected.discount(), cd.discount());
			Assert.assertEquals(expected.discountMessage(), cd.discountMessage());
		}
	}

	/**
	 * Test method for {@link POS.CompositeDiscount#remove(POS.Discount)}.
	 */
	@Test
	public void testRemove() {
		MockDiscount mDiscount = new MockDiscount();
		for(int i=size; i>=0; i--){
			mDiscount.setDiscount(i*0.1f);
			mDiscount.setDiscountMessage("" + (i*0.1f));
			expected.remove(mDiscount);
			cd.remove(mDiscount);
			Assert.assertEquals(expected.discount(), cd.discount());
			Assert.assertEquals(expected.discountMessage(), cd.discountMessage());
		}
	}

	/**
	 * Test method for {@link POS.CompositeDiscount#discountMessage()}.
	 */
	@Test
	public void testDiscountMessage() {
		Assert.assertEquals(expected.discountMessage(), cd.discountMessage());
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
