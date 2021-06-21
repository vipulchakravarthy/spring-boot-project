package io.springcourse.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springcourse.topic.Topic;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getCourses(id);
    }

    //get course by id
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getTopicById(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    //post method to add the course
    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
    	course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);        
    }

    //put method
    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
    	course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course, id);        
    }

    //delete method
    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);        
    }
}
