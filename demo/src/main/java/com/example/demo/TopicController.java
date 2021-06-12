package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        return Arrays.asList(new Topic("124", "Spring course", "This is my description"),
                new Topic("126", "React", "This is my description"),
                new Topic("128", "Java", "This is my description"));
    }
}
