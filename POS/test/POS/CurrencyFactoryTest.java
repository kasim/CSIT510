package POS;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.IsNull;

/**
 * @author kasim
 *
 */
public class CurrencyFactoryTest {
	CurrencyFactory cFactory = null;
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
		cFactory = new CurrencyFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cFactory = null;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testCurrencyFactory() throws Exception{

	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testCountry() throws Exception {
		Assert.assertThat(CurrencyFactory.Country.valueOf("HK"), IsNull.notNullValue());
		Assert.assertThat(CurrencyFactory.Country.valueOf("US"), IsNull.notNullValue());
	}
			
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testCreateCurrency() throws Exception {
		Assert.assertEquals(CurrencyFactory.createCurrency(CurrencyFactory.Country.HK).show(), (new HKCurrency()).show());
		Assert.assertEquals(CurrencyFactory.createCurrency(CurrencyFactory.Country.US).show(), (new USCurrency()).show());
		Assert.assertEquals(CurrencyFactory.createCurrency(null), null);
	}
}
