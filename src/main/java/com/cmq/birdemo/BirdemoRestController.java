package com.cmq.birdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author xavier.qiu
 * 9/15/18 2:16 PM
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("rest")
public class BirdemoRestController {

    static final ArrayList<String> RANDOM_CAPTIONS = new ArrayList<>();
    static final int RANDOM_SIZE;

    static {
        RANDOM_CAPTIONS.add("this bird is red with white and has a very short beak");
        RANDOM_CAPTIONS.add("this small bird has a pink breast and crown, and black primaries and secondaries.");
        RANDOM_CAPTIONS.add("this magnificent fellow is almost all black with a red crest, and white cheek patch.");
        RANDOM_CAPTIONS.add("an all black bird with a distinct thick, rounded bill.");
        RANDOM_CAPTIONS.add("this small bird has a yellow breast, brown crown, and black superciliary");
        RANDOM_CAPTIONS.add("a tiny bird, with a tiny beak, tarsus and feet, a blue crown, blue coverts, and black cheek patch");
        RANDOM_CAPTIONS.add("this bird is different shades of brown all over with white and black spots on its head and back");

        RANDOM_CAPTIONS.add("the gray bird has a light grey head and grey webbed feet");
        RANDOM_CAPTIONS.add("The bird has a yellow breast with grey features and a small beak.");
        RANDOM_CAPTIONS.add("This is a large white bird with black wings and a red head.");
        RANDOM_CAPTIONS.add("A small bird with a black head and wings and features grey wings.");
        RANDOM_CAPTIONS.add("This bird has a white breast, brown and white coloring on its head and wings, and a thin pointy beak.");
        RANDOM_CAPTIONS.add("A small bird with white base and black stripes throughout its belly, head, and feathers.");
        RANDOM_CAPTIONS.add("A small sized bird that has a cream belly and a short pointed bill.");
        RANDOM_CAPTIONS.add("This bird is completely red.");
        RANDOM_CAPTIONS.add("This bird is completely white.");
        RANDOM_CAPTIONS.add("This is a yellow bird. The wings are bright blue.");

        RANDOM_CAPTIONS.add("This bird is completely red with black wings");

        RANDOM_CAPTIONS.add("Blue bird with black beak");
        RANDOM_CAPTIONS.add("Red bird with black beak");
        RANDOM_CAPTIONS.add("Small blue bird with black wings");
        RANDOM_CAPTIONS.add("Small yellow bird with black wings");
        RANDOM_CAPTIONS.add("this bird is all blue, the top part of the bill is blue, but the bottom half is white");

        RANDOM_CAPTIONS.add("This bird is bright.");
        RANDOM_CAPTIONS.add("This is a yellow bird. The wings are bright blue");
        RANDOM_CAPTIONS.add("the bird has a yellow crown and a black eyering that is round ");
        RANDOM_CAPTIONS.add("this bird has a green crown black primaries and a white belly");
        RANDOM_CAPTIONS.add("this bird has wings that are black and has a white belly");
        RANDOM_CAPTIONS.add("this bird has wings that are red and has a yellow belly");
        RANDOM_CAPTIONS.add("this bird has wings that are blue and has a red belly");


        RANDOM_SIZE = RANDOM_CAPTIONS.size();

    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("caption")
    public String caption() {
        return RANDOM_CAPTIONS.get(new Random().nextInt(RANDOM_SIZE));
    }

    @RequestMapping("")
    public String demo(String des) {


        final String uri = "http://35.231.132.43:5678/api/v1.0/bird";
        Map<String, String> map = new HashMap();
        map.put("caption", "this bird is red with white and has a very short beak");
        map = restTemplate.postForObject(uri, map, Map.class);

        System.out.println(map.keySet().iterator().next());

        return "";
    }
}
