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
public class ItemTest {
	Item item = null;
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
		String itemName = "Test Item 01";
		Integer number = 1;
		Float price = 0.1f;
		
		item = new Item(itemName, number, price);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		item = null;
	}

	@Test
	public void testItem() throws Exception {
		String itemName = "Test Item 01";
		Integer number = 1;
		Float price = 0.1f;	
		
		Assert.assertEquals(itemName, item.itemName);
		Assert.assertEquals(number, item.number);
		Assert.assertEquals(price, item.price);
	}
	
	@Test
	public void testSetDiscount() throws Exception{
		Discount discount = null;
		item.setDiscount(discount);
		
		Assert.assertEquals(discount, item.discount);
	}
}
