package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyFileUtility {

	/**
	 * This method is used to read data from property file provided key
	 * @param Key
	 * @throws IOException
	 * @return
	 * 
	 */
	public String toReadDataFromPropertyFile(String Key) throws IOException {
		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		String value = prop.getProperty(Key);
		return value;
	}
}
