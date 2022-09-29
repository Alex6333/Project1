import Comparators.StudentComparator;
import Comparators.UniversityComparator;
import Utils.JsonUtil;
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
        students.sort(studentComparator);
        String studentToJson = JsonUtil.studentListToJson(students);
        System.out.println(studentToJson);

        List<Student> fromJsonToStudent = JsonUtil.jsonToStudentList(studentToJson);
        System.out.println(students.size() == fromJsonToStudent.size());

        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student jsonStudent = JsonUtil.jsonToStudent(studentJson);
            System.out.println(jsonStudent);
        });

        List<University> universities = ReadFromFile.readUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = UtilComparator.getUniversityComparator(UniversityComparatorEnum.ID);
        universities.sort(universityComparator);
        String universityToJson = JsonUtil.universityListToJson(universities);
        System.out.println(universityToJson);

        List<University> fromJsonToUniversity = JsonUtil.jsonToUniversityList(universityToJson);
        System.out.println(universities.size() == fromJsonToUniversity.size());

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University jsonUniversity = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(jsonUniversity);
        });
    }
}
