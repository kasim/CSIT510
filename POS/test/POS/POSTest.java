/**
 * 
 */
package POS;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.Permission;
import java.util.Scanner;

import org.hamcrest.core.IsNull;
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
public class POSTest {
	POS pos = null;

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
		pos = new POS();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pos = null;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testGetInst() throws Exception{
		Assert.assertThat(POS.getInst(), IsNull.notNullValue());
		Assert.assertEquals(POS.getInst().getClass(), POS.class);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testInt2Str() throws Exception {
		int i = 50;
		String []ss = {"00","0",""};
    	String xs = String.valueOf(i);
    	xs = ss[xs.length()]+xs;
    	
		Assert.assertThat(POS.int2Str(i), IsNull.notNullValue());
		Assert.assertEquals(POS.int2Str(i).getClass(), String.class);
		Assert.assertEquals(POS.int2Str(i), xs);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testTest() throws Exception {
		Assert.assertEquals(1, pos.test());
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testRound() throws Exception {
		double value = Math.PI;
		int scale = 9;
		int roundingMode = BigDecimal.ROUND_HALF_EVEN;
		
		BigDecimal bd = new BigDecimal(value);  
        bd = bd.setScale(scale, roundingMode);  
        double d = bd.doubleValue();  
        bd = null;  
        
        Assert.assertThat(POS.round(value, scale, roundingMode), IsNull.notNullValue());
		Assert.assertEquals(POS.round(value, scale, roundingMode), d, scale);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testGetFloat() throws Exception{
		SecurityManager securityManager = new SecurityManager() {
		    public void checkPermission(Permission permission) {
		        if ("exitVM".equals(permission.getName())) {
		                //throw new SecurityException("System.exit attempted and blocked.");
		        	/*throw null;*/
		        }
		    }
		};
		System.setSecurityManager(securityManager);
		
		String sMode  = "0.0001";
		//boolean batchMode = POS.batchMode;
		float mode = 0;
		boolean flag = true;
		
		while(flag) {
			/*try {*/
				mode = Float.parseFloat(sMode);
				if (mode < 0){
					/*if (batchMode){
						String log = "Incorrect number!";
						pos.logInfo(log);
						System.exit(1);
					}*/
					/*System.out.print("You should enter a valid number:");
					Scanner sc = new Scanner(System.in);
					sMode = sc.next();*/
				}else{
					flag = false;
				}
			/*}catch(NumberFormatException e) {
				if (batchMode){
					String log = "Incorrect number!";
					pos.logInfo(log);
					System.exit(1);
				}
				System.out.print("You should enter a valid number:");
				Scanner sc = new Scanner(System.in);
				sMode = sc.next();
			}catch(Exception e){
				
			}*/
		}
		
		Assert.assertThat(pos.getFloat(sMode), IsNull.notNullValue());
		Assert.assertEquals(pos.getFloat(sMode), mode, 0);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testGetLine() throws Exception{
		String expected = null;
		POS.batchFile = "resource/batchFile";
		BufferedReader bReader = new BufferedReader(new FileReader(POS.batchFile)); 
		pos.loadBatchFile();
		expected = bReader.readLine();
		
		Assert.assertEquals(expected, pos.getLine());
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testGetNum() throws Exception{
		String sMode = "10";
		int mode = 0;
		boolean flag = true;
		while(flag) {
			mode = Integer.parseInt(sMode);
			if(mode >= 0)
				flag = false;
		}
		Assert.assertEquals(mode, pos.getNum(sMode));
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testInit() throws Exception{
		Assert.fail("not yet implemented");
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testloadBatchFile() throws Exception{
		POS.batchFile = "resource/batchFile";
		BufferedReader bReader = new BufferedReader(new FileReader(POS.batchFile)); 
		pos.loadBatchFile();
		Assert.assertEquals(bReader.readLine(), pos.baReader.readLine());
		Assert.assertEquals(bReader.read(), pos.baReader.read());
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testLogInfo() throws Exception{
		String outputFileName1 = "resource/logAndSales1";
		String outputFileName2 = "resource/logAndSales2";
		String str = "Testing\n";
		
		pos.fWriter = new BufferedWriter(new FileWriter(outputFileName1));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName2));
		
		pos.logInfo(str);
		
		pos.fWriter.close();
		
		writer.write(str);
		writer.newLine();
		writer.flush();
		
		writer.close();
						
		File outputFile1 = new File(outputFileName1);
		File outputFile2 = new File(outputFileName2);
		
		long length1 = outputFile1.length();
		long length2 = outputFile2.length();
		
		Assert.assertEquals(length1, length2);
		
		InputStream is1 = new FileInputStream(outputFile1);
		InputStream is2 = new FileInputStream(outputFile2);
		
		byte[] bytes1 = new byte[(int)length1];
		byte[] bytes2 = new byte[(int)length2];
		
		int offset = 0;
        int numRead = 0;
        while (offset < bytes1.length
               && (numRead=is1.read(bytes1, offset, bytes1.length-offset)) >= 0) {
            offset += numRead;
        }
        
        offset = 0;
        numRead = 0;
        while (offset < bytes2.length
                && (numRead=is2.read(bytes2, offset, bytes2.length-offset)) >= 0) {
             offset += numRead;
         }
        
        Assert.assertEquals(bytes1.length, bytes2.length);
        
        for(int i=0; i<bytes1.length; i++){
        	Assert.assertEquals(bytes1[i], bytes2[i]);
        }
        
        is1.close();
        is2.close();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testRecordSalesLine() throws Exception{
		Assert.fail("not yet implemented");
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testRegister() throws Exception{
		Assert.fail("not yet implemented");
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testSaleRegister() throws Exception{
		Assert.fail("not yet implemented");
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testMain() throws Exception{
		Assert.fail("not yet implemented");
	}
}
