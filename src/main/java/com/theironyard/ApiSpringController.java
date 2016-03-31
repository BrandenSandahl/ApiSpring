package com.theironyard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Created by branden on 3/31/16 at 11:18.
 */
@RestController
public class ApiSpringController {

    static final String SAMPLE_URL = "http://gturnquist-quoters.cfapps.io/api/random";




    @RequestMapping(path = "/quote", method = RequestMethod.GET)
    public HashMap getQuote() {
        RestTemplate query = new RestTemplate();
        HashMap results = query.getForObject(SAMPLE_URL, HashMap.class);
        String type = (String) results.get("type");
        if (type.equals("success")) {
            HashMap value = (HashMap) results.get("value");
            return value;
        }

        return null;
    }


}