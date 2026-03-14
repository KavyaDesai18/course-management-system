package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService){  //This is a constructor
        this.courseService = courseService;
    }
    //whenever user makes request by this mapping name browser directly comes to that get mapping annotation.
    //That is not the context path of our tomcat server. it just a called name only.

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id){          //that {id} comes as URL but Path variable takes that values and put it to the java variables!
        return courseService.getCourse(id);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course){         //Takes jason values and convert it into Course object
        courseService.addCourse(course);
    }

     @PutMapping("/{id}")
    public void updateCourse(@PathVariable String id , @RequestBody Course course){
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }

    @GetMapping("/name/{name}")
    public List<Course> getCoursesByName(@PathVariable String name){
        return courseService.getCoursesByName(name);
    }
}
