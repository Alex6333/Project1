import Comparators.StudentComparator;
import Comparators.UniversityComparator;
import Utils.UtilComparator;
import enums.StudentsComparatorEnum;
import enums.UniversityComparatorEnum;
import io.ReadFromFile;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Student> students = ReadFromFile.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = UtilComparator.getStudentComparator(StudentsComparatorEnum.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);

        List<University> universities = ReadFromFile.readUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = UtilComparator.getUniversityComparator(UniversityComparatorEnum.ID);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
    }
}
