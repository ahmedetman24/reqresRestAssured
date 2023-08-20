package Testcases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class allAPIs extends testBase {

    @Test(dataProvider = "getAPIData", dataProviderClass = dataProviderClass.class, priority = 1)
    public void getAPI(String endpoint, String statusCode, String bodyItemPath, String bodyActualValue)
    {
        System.out.println("GET API:\nResponse Body:\n------------------");
        given().
                get(endpoint).
        then().
                statusCode(Integer.parseInt(statusCode)).
                body(bodyItemPath, equalTo(bodyActualValue)).
                log().status().
                log().body();
    }

    @Test(dataProvider = "postAPIData", dataProviderClass = dataProviderClass.class, priority = 2)
    public void postAPI(String name, String nameValue, String job, String jobValue, String endpoint, String responseStatus)
    {
        System.out.println("==========================\nPOST API:");
        // Entring Request Body
        request.put(name, nameValue);
        request.put(job, jobValue);
        System.out.println("Request Body:\n"+request.toJSONString());

        // Sending the request
        System.out.println("Response:");
        given().
                body(request.toJSONString()).
        when().
                post(endpoint).
        then().
                statusCode(Integer.parseInt(responseStatus)).
                log().status().
                log().body();
    }

    @Test(dataProvider = "putAPIData", dataProviderClass = dataProviderClass.class, priority = 3)
    public void putAPI(String name, String nameValue, String job, String jobValue, String endpoint, String responseStatus)
    {
        System.out.println("==========================\nPUT API:");
        // Entring Request Body
        request.put(name, nameValue);
        request.put(job, jobValue);
        System.out.println("Request Body:\n"+request.toJSONString());

        // Sending the request
        System.out.println("Response:");
        given().
                body(request.toJSONString()).
        when().
                put(endpoint).
        then().
                statusCode(Integer.parseInt(responseStatus)).
                log().status().
                log().body();
    }

    @Test(dataProvider = "putAPIData", dataProviderClass = dataProviderClass.class, priority = 4)
    public void patchAPI(String name, String nameValue, String job, String jobValue, String endpoint, String responseStatus)
    {
        System.out.println("==========================\nPATCH API:");
        // Entring Request Body
        request.put(name, nameValue);
        request.put(job, jobValue);
        System.out.println("Request Body:\n"+request.toJSONString());

        // Sending the request
        System.out.println("Response:");
        given().
                body(request.toJSONString()).
        when().
                patch(endpoint).
        then().
                statusCode(Integer.parseInt(responseStatus)).
                log().status().
                log().body();
    }

    @Test(dataProvider = "deleteAPIData", dataProviderClass = dataProviderClass.class, priority = 5)
    public void deleteAPI(String endpoint, String statusCode)
    {
        System.out.println("==========================\nDELETE API:");
        // Sending the request
        when().
                delete(endpoint).
        then().
                statusCode(Integer.parseInt(statusCode)).
                log().status().
                log().body();
    }

}
