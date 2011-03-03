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
public class SalesLineTest {
	int size = 10;
	SalesLine salesLine = null; 

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
		salesLine = new SalesLine();
		for(int i=0; i<=size; i++){
			String itemName = "Test Item " + i;
			Integer itemNumber = Integer.valueOf(i);
			Float itemPrice = Float.valueOf(i*0.1f);
			float itemDiscountNum = i*0.5f;
			int pItemNumber = (i+1);
			Discount itemDiscount = new ProductDiscount(itemDiscountNum);
			Item item = new Item(itemName, itemNumber, itemPrice);
			item.setDiscount(itemDiscount);
			PurchaseItem pItem = new PurchaseItem(item, pItemNumber);
			salesLine.sumPrice += pItem.item.price;
			salesLine.itemRecord.add(pItem);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		salesLine = null;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testSalesLine() throws Exception {
		SalesLine salesLineTest = new SalesLine();
		for(int i=0; i<=size; i++){
			String itemName = "Test Item " + i;
			Integer itemNumber = Integer.valueOf(i);
			Float itemPrice = Float.valueOf(i*0.1f);
			float itemDiscountNum = i*0.5f;
			int pItemNumber = (i+1);
			Discount itemDiscount = new ProductDiscount(itemDiscountNum);
			Item item = new Item(itemName, itemNumber, itemPrice);
			item.setDiscount(itemDiscount);
			PurchaseItem pItem = new PurchaseItem(item, pItemNumber);
			salesLineTest.sumPrice += pItem.item.price;
			salesLineTest.itemRecord.add(pItem);
		}
		Assert.assertEquals(salesLineTest.sumPrice, salesLine.sumPrice, 0);
		for(int i=0; i<=size; i++){
			Assert.assertEquals(((PurchaseItem)salesLineTest.itemRecord.get(i)).item.discount.discount(),
					((PurchaseItem)salesLine.itemRecord.get(i)).item.discount.discount(), 0);
			Assert.assertEquals(((PurchaseItem)salesLineTest.itemRecord.get(i)).item.discount.discountMessage(),
					((PurchaseItem)salesLine.itemRecord.get(i)).item.discount.discountMessage());
			
			Assert.assertEquals(((PurchaseItem)salesLineTest.itemRecord.get(i)).item.itemName,
					((PurchaseItem)salesLine.itemRecord.get(i)).item.itemName);
			Assert.assertEquals(((PurchaseItem)salesLineTest.itemRecord.get(i)).item.number,
					((PurchaseItem)salesLine.itemRecord.get(i)).item.number);
			Assert.assertEquals(((PurchaseItem)salesLineTest.itemRecord.get(i)).item.price,
					((PurchaseItem)salesLine.itemRecord.get(i)).item.price);
			
			Assert.assertEquals(((PurchaseItem)salesLineTest.itemRecord.get(i)).number,
					((PurchaseItem)salesLine.itemRecord.get(i)).number);
		}
	}
}
