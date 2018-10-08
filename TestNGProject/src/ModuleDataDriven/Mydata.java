package ModuleDataDriven;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Mydata {
  /*@Test(dataProvider = "searchword")
  public void testdata(Integer n, String s)
  {
  
  }
*/
  @DataProvider(name="searchword")
  public static Object[][] testdata()
  {
    return new Object[][] {
      { "kalam" },
      { "mother" },
      { "appium" },
    };
  }
}
