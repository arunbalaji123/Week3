package Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
@DataProvider
	public Object[][] dataproviderchk()
	{
		int k=0;
Object[][] og= new Object[5][2];
for(int i=0;i<5;i++) {
	for(int j=0;j<2;j++) {
		og[i][j]=k+" abc "+k;
		k++;
	}
}
return og;

	}

@Test(dataProvider = "dataproviderchk")
public void dataproviderexample(String a,String b) {
	System.out.println("Distance from A  "+a+ "  Distance from B  "+b);
}

}
