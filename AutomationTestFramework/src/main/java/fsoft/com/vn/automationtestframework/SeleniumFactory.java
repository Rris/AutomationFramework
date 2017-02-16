package fsoft.com.vn.automationtestframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

public class SeleniumFactory {

	SeleniumImpl seImpl;

	/** The i. */
	int index = 0;

	int i = 0;

	boolean flag = false;

	boolean flag1 = false;

	List<Map<String, String>> listMultiData;

	List<Object[]> listLoop;

	public void getKeyword(Object[] object) {
		String keyWord = (String) object[0];
		String locatorID = (String) object[1];
		String locatorString = (String) object[2];
		String inputValue = (String) object[3];
		String row = (String) object[4];
		String col = (String) object[5];
		String inputQuery = (String) object[6];
		String expected = (String) object[7];
		List<String> listInput = (List<String>) object[8];
		List<String> listOutput = (List<String>) object[9];
		if (flag1 && listMultiData.get(index).get(inputValue) != null) {
			inputValue = listMultiData.get(index).get(inputValue);
		}
		switch (keyWord) {
		case "setup_browser":
			seImpl.setup_browser(inputValue);
			break;
		case "explicit_wait":
			Assert.assertTrue(seImpl.explicit_wait(inputValue));
			break;
		case "load_page":
			Assert.assertTrue(seImpl.load_page(inputValue));
			break;
		case "click_element":
			Assert.assertTrue(seImpl.click_element(locatorID, locatorString));
			break;
		case "enter_input":
			Assert.assertTrue(seImpl.enter_input(locatorID, locatorString, inputValue));
			break;
		case "select_drop_down":
			Assert.assertTrue(seImpl.select_drop_down(locatorID, locatorString, inputValue));
			break;
		case "verify_element_present":
			Assert.assertTrue(seImpl.verify_element_present(locatorID, locatorString, inputValue));
			break;
		case "enter_input_hidden":
			Assert.assertTrue(seImpl.enter_input_hidden(locatorID, locatorString, inputValue));
			break;
		case "count_drop_down":
			Assert.assertTrue(seImpl.count_drop_down(locatorID, locatorString, inputValue));
			break;
		case "verify_text":
			Assert.assertTrue(seImpl.verify_text(locatorID, locatorString, inputValue));
			break;
		case "verify_field_text":
			Assert.assertTrue(seImpl.verify_field_text(locatorID, locatorString, inputValue));
			break;
		case "verify_text_contains":
			Assert.assertTrue(seImpl.verify_text_contains(locatorID, locatorString, inputValue));
			break;
		case "verify_table_cell_text":
			Assert.assertTrue(seImpl.verify_table_cell_text(locatorID, locatorString, inputValue, row, col));
			break;
		case "table_row_sel":
			List<String> l_table_row_sel = new ArrayList<String>();
			l_table_row_sel.add(String.valueOf(seImpl.table_row_sel(locatorID, locatorString, listInput.get(0), col)));
			/*
			 * ReadScript.store_data_return(new File(url), i, l_table_row_sel);
			 */
			break;
		case "store_cell_data":
			List<String> l_store_cell_data = new ArrayList<String>();
			l_store_cell_data
					.add(String.valueOf(seImpl.store_cell_data(locatorID, locatorString, col, listInput.get(0))));
			/*
			 * ReadScript.store_data_return(new File(url), i,
			 * l_store_cell_data);
			 */
			break;
		case "switch_alert_ok":
			Assert.assertTrue(seImpl.switch_alert_ok());
			break;
		case "compare_JSAlert_msg":
			Assert.assertTrue(seImpl.compare_JSAlert_msg(inputValue));
			break;
		case "page_scroll":
			Assert.assertTrue(seImpl.page_scroll(inputValue));
			break;
		case "screen_shot":
			Assert.assertTrue(seImpl.screen_shot(inputValue));
			break;
		default:
			break;
		}
		if (flag) {
			listLoop.add(object);
		}
		i++;
	}
}
