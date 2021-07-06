package com.grubhub.lite.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * tests to test endpts functionality instead of the actual underlying
 * service beneath it
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {


    @Test
    void contextLoads(){

    }

    @Test
    public void testGetCustomers() {
        //Arrange
        final String baseUrl = "http://localhost:" + port + "/";


        //Act

        //Assert
    }




}
