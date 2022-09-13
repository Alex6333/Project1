import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Student> students = ReadFromFile.readStudents("C:\\Users\\ferfe\\IdeaProjects\\module_gradle\\Project1\\src\\main\\resources\\universityInfo.xlsx");
        for (Student student: students) {
            System.out.println(student);
        }

        List<University> universities = ReadFromFile.readUniversity("C:\\Users\\ferfe\\IdeaProjects\\module_gradle\\Project1\\src\\main\\resources\\universityInfo.xlsx");
        for (University university: universities) {
            System.out.println(university);
        }
    }
}
