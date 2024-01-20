package hu.webler.weblerspringthymeleafdesign.service;

import hu.webler.weblerspringthymeleafdesign.bootstrap.DataInitializer;
import hu.webler.weblerspringthymeleafdesign.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final DataInitializer dataInitializer;

    public List<Student> getStudents() {
        return dataInitializer.getSTUDENTS()
                .stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.toList());
    }

    public List<Student> searchStudentsByEmail(String email) {
        return dataInitializer.getSTUDENTS()
                .stream()
                .filter(student -> student.getEmail().contains(email))
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.toList());
    }
}