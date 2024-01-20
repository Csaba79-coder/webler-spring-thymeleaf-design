package hu.webler.weblerspringthymeleafdesign.service;

import hu.webler.weblerspringthymeleafdesign.bootstrap.DataInitializer;
import hu.webler.weblerspringthymeleafdesign.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final DataInitializer dataInitializer;

    public List<Student> getStudents() {
        return dataInitializer.getSTUDENTS_ENGLISH()
                .stream()
                .sorted()
                .toList();
    }

    public List<Student> searchStudentsByEmail(String email) {
        return dataInitializer.getSTUDENTS_ENGLISH()
                .stream()
                .filter(student -> student.getEmail().contains(email))
                .sorted()
                .toList();
    }

    // if we don't have Comparator interface!
    /*public List<Student> searchStudentsByEmail(String email) {
        return dataInitializer.getSTUDENTS()
                .stream()
                .filter(student -> student.getEmail().contains(email))
                .sorted(Comparator.comparing(Student::getEmail))
                .collect(Collectors.toList());
    }
    */

    public List<Student> getStudentsHungarian() {
        String hungarianRules = "< a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS < e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J < k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó < ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T < ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS";
        RuleBasedCollator huCollator = null;
        try {
            huCollator = new RuleBasedCollator(hungarianRules);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RuleBasedCollator finalHuCollator = huCollator;
        return dataInitializer.getSTUDENTS_HUNGARIAN()
                .stream()
                .distinct()
                .sorted((s1, s2) -> Objects.requireNonNull(finalHuCollator).compare(s1.getLastName(), s2.getLastName()))
                .toList();
    }
}