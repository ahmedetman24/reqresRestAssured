package Testcases;

import TestData.excelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class dataProviderClass {

    @DataProvider(name = "getAPIData")
    public static Object [][] readGetAPIData() throws IOException
    {
        excelReader er = new excelReader();
        return er.getExcelData("APIsData.xlsx",0);
    }

    @DataProvider(name = "postAPIData")
    public static Object [][] readPostAPIData() throws IOException
    {
        excelReader er = new excelReader();
        return er.getExcelData("APIsData.xlsx",1);
    }

    @DataProvider(name = "putAPIData")
    public static Object [][] readPutAPIData() throws IOException
    {
        excelReader er = new excelReader();
        return er.getExcelData("APIsData.xlsx",2);
    }

    @DataProvider(name = "deleteAPIData")
    public static Object [][] readDeleteAPIData() throws IOException
    {
        excelReader er = new excelReader();
        return er.getExcelData("APIsData.xlsx",3);
    }
}
