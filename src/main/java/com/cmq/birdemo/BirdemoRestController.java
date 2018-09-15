package com.cmq.birdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xavier.qiu
 * 9/15/18 2:16 PM
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("rest")
public class BirdemoRestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("")
    public String demo(String des) {


        final String uri = "http://35.231.132.43:5678/api/v1.0/bird";
        Map<String , String > map = new HashMap();
        map.put("caption","this bird is red with white and has a very short beak");
        map = restTemplate.postForObject(uri, map, Map.class);

        System.out.println(map.keySet().iterator().next());

        return "";
    }
}
