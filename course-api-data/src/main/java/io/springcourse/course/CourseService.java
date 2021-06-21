package io.springcourse.course;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

    public List<Course> getCourses(String topicId) {
    	List<Course> list = new ArrayList<>();
    	courseRepository.findByTopicId(topicId).forEach(list::add);
    	return list;
    }

    public Course getCourse(String id){
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    	return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id){
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }
}