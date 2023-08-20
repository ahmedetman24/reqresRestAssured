package Testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;
public class testBase {

    public JSONObject request;
    @BeforeTest()
    protected void setGeneralData() {
        baseURI = "https://reqres.in/api";
        request = new JSONObject();
    }
}
