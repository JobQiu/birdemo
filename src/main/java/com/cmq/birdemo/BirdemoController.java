package com.cmq.birdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xavier.qiu
 * 9/15/18 1:42 PM
 */
@Controller
@RequestMapping("")
public class BirdemoController {

    public static final String DEFAULT_DESCRIPTION = "this bird is red with white and has a very short beak";

    public static final String uri = "http://35.231.132.43:5678/api/v1.0/bird";

    @RequestMapping("")
    public String index(Model model) {

        Map<String, String> result = postForImages(DEFAULT_DESCRIPTION);

        model.addAttribute("time", String.valueOf(result.get("elapsed")) + " seconds");
        model.addAttribute("caption", result.get("caption"));

        for (String key : result.keySet()) {
            if (key.equals("elapsed")) {
                continue;
            } // end of if
            if (result.get(key).startsWith("https")) {
                model.addAttribute(key, result.get(key));
            } // end of if
        }
        return "index";
    }

    @RequestMapping("request")
    public String req(String description,
                      Model model) {

        Map<String, String> result = postForImages(description);

        model.addAttribute("time", String.valueOf(result.get("elapsed")) + " seconds");
        model.addAttribute("caption", result.get("caption"));

        for (String key : result.keySet()) {
            if (key.equals("elapsed")) {
                continue;
            } // end of if
            if (result.get(key).startsWith("https")) {
                model.addAttribute(key, result.get(key));
            } // end of if
        }

        return "index";
    }

    @Autowired
    private BirdemoRestController birdemoRestController;

    @RequestMapping("random")
    public String random(Model model) {
        model.addAttribute("caption", birdemoRestController.caption());
        return "index";
    }

    @Autowired
    RestTemplate restTemplate;

    public Map<String, String> postForImages(String des) {

        if (StringUtils.isEmpty(des)) {
            des = DEFAULT_DESCRIPTION;
        } // end of if


        Map<String, String> map = new HashMap();
        map.put("caption", des.toLowerCase());
        Map<String, Map<String, String>> map2 = restTemplate.postForObject(uri, map, Map.class);
        map = map2.get("bird");
        map.put("caption", des);
        return map;

    }

}
