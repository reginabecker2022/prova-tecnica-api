package br.com.restassuredapitesting.tests.base.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {
    
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/v1/";
    }
}

