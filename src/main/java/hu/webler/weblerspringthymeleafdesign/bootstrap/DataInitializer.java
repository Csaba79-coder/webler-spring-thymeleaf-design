package hu.webler.weblerspringthymeleafdesign.bootstrap;

import hu.webler.weblerspringthymeleafdesign.model.Student;
import lombok.Getter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataInitializer implements ApplicationRunner {

    private final List<Student> STUDENTS = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createStudents();
    }

    private void createStudents() {
        Student laszlo = Student.builder().
                firstName("László").
                lastName("Földházi").
                midName(null).
                email("foldi44@hotmail.com").build();
        Student janos = Student.builder().
                firstName("János").
                lastName("Kovács").
                midName("Pál").
                email("kovacs.janos.pal@gmail.com").build();
        Student miklos = Student.builder().
                firstName("Miklós").
                lastName("Ábrahám").
                midName(null).
                email("mikcsek2@gmail.com").build();
        Student gyepi = Student.builder().
                firstName("Peter").
                lastName("Antal").
                midName("Attila").
                email("antipet@gmail.com").build();
        Student roland = Student.builder().
                firstName("Roland").
                lastName("Szőke").
                midName(null).
                email("szokeroland0@gmail.com").build();
        Student peter = Student.builder().
                firstName("Péter").
                lastName("Futó").
                midName(null).
                email("futopeter97@gmail.com").build();
        Student gabor = Student.builder().
                firstName("Gábor").
                lastName("Perczel").
                midName(null).
                email("kapusgabor64@gmail.com").build();
        Student norbi = Student.builder().
                firstName("Norbert").
                lastName("Balint").
                midName(null).
                email("norbaa79@gmail.com").build();
        Student geri = Student.builder().
                firstName("Gergely").
                lastName("Tóth").
                midName(null).
                email("thgeri17@gmail.com").build();

        STUDENTS.add(laszlo);
        STUDENTS.add(janos);
        STUDENTS.add(miklos);
        STUDENTS.add(gyepi);
        STUDENTS.add(roland);
        STUDENTS.add(peter);
        STUDENTS.add(gabor);
        STUDENTS.add(norbi);
        STUDENTS.add(geri);
    }
}
