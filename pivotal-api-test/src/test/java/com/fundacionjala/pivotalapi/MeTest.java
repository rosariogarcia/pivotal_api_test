package com.fundacionjala.pivotalapi;


import com.jayway.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MeTest {

    private Request request;

    @Before
    public void SetUp(){
        request = new Request();
    }
    @Test
    public void testGetRequest() {
        final int expected_status = 200;
        assertEquals(expected_status, request.getRequest("/projects").statusCode());
    }

    @Test
    public void testPostRequest(){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put( "name", "newwe Project" );
        parameters.put( "public", true );
        Response response = request.postRequest("projects", parameters );
        System.out.println(response.prettyPrint());
        System.out.println(response.jsonPath().get("name"));

    }
}
