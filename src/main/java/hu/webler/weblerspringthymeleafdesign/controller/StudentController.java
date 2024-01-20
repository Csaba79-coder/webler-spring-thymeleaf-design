package hu.webler.weblerspringthymeleafdesign.controller;

import hu.webler.weblerspringthymeleafdesign.model.Student;
import hu.webler.weblerspringthymeleafdesign.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @GetMapping({"", "/", "/home"}) // ({"", "/", "/home", "/index", "/index.html"})
    public List<Student> renderStudents() {
        return studentService.getStudents();
    }
}
