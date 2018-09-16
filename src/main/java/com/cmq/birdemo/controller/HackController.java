package com.cmq.birdemo.controller;

import com.cmq.birdemo.entity.Painting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xavier.qiu
 * 9/15/18 9:29 PM
 */
@RestController
@RequestMapping("hack")
public class HackController {

    @RequestMapping(value = "gallery", method = RequestMethod.GET)
    public List<Painting> gallery(int num) {

        return new ArrayList<>();// sort by ranks

    }

    @RequestMapping(value = "galleryByTime", method = RequestMethod.GET)
    public List<Painting> galleryByTime(int num) {

        return new ArrayList<>();// sort by time, the newest is on the top

    }


    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String submit(String email,
                         @RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("/Users/xavier.qiu/Documents/cs229/test/" + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";


    }

    @RequestMapping(value = "like", method = RequestMethod.GET)
    public String like(String ipAddress, long id) {

        return "";
    }

    @RequestMapping(value = "dislike", method = RequestMethod.GET)
    public String dislike(String ipAddress, long id) {

        return "";
    }


}
