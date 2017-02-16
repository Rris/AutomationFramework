package fsoft.com.vn.automationtestframework;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.util.HSSFColor.GOLD;
import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

// TODO: Auto-generated Javadoc
/**
 * The Class TestNGClass.
 */
public class TestNGClass {

	/** The se impl. */
	SeleniumImpl seImpl;

	/** The url. */
	List<File> url;

	/**
	 * Verify automation test.
	 *
	 * @param keyWord
	 *            the key word
	 * @param locatorID
	 *            the locator ID
	 * @param locatorString
	 *            the locator string
	 * @param inputValue
	 *            the input value
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @param listInput
	 *            the list input
	 * @param listOutput
	 *            the list output
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws NumberFormatException
	 *             the number format exception
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	@Test(dataProvider = "dp")
	public void verifyAutomationTest(Object[] object)
			throws FileNotFoundException, IOException, NumberFormatException, InterruptedException {
		SeleniumFactory seleniumFactory = new SeleniumFactory();
		seleniumFactory.getKeyword(object);
	}

	@DataProvider
	public Object[][] dp() throws IOException {
		Object[][] arrayList = ReadScript.readExcelData(url, 10);
		return arrayList;
	}

	/**
	 * Before class.
	 *
	 * @throws RemoteException
	 *             the remote exception
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	@BeforeClass
	public void beforeClass() {
		seImpl = new SeleniumImpl();
		url = new ArrayList<File>();

		String line = "";
		try {
			FileReader fr = new FileReader("../file-selected.txt");
			BufferedReader input = new BufferedReader(fr);
			while ((line = input.readLine()) != null) {
				url.add(new File(line));
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * After class.
	 *
	 * @param result
	 *            the result
	 */
	@AfterClass
	public void afterClass() {
		try {
			File file = new File("../file-selected.txt");
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
