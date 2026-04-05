package Testng;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class FetchingData {
	
	
	
	
	@Test(dataProvider = "dataproviderchk",dataProviderClass =  dataProvider.class)
	public void dataproviderexample(String a,String b) {
		System.out.println("Distance from A  "+a+ "  Distance from B  "+b);
	}

}
