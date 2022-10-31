import Comparators.StudentComparator;
import Comparators.UniversityComparator;
import Utils.JsonUtil;
import Utils.StatisticUtil;
import Utils.UtilComparator;
import enums.StudentsComparatorEnum;
import enums.UniversityComparatorEnum;
import io.JsonWriter;
import io.ReadFromFile;
import io.XlsWriter;
import io.XmlWriter;
import model.FullInfo;
import model.Statistics;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {

    private static  final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");

        List<Student> students = ReadFromFile.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = UtilComparator.getStudentComparator(StudentsComparatorEnum.AVG_EXAM_SCORE);
        students.sort(studentComparator);
        /*String studentToJson = JsonUtil.studentListToJson(students);
        System.out.println(studentToJson);

        List<Student> fromJsonToStudent = JsonUtil.jsonToStudentList(studentToJson);
        System.out.println(students.size() == fromJsonToStudent.size());

        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student jsonStudent = JsonUtil.jsonToStudent(studentJson);
            System.out.println(jsonStudent);
        });*/

        List<University> universities = ReadFromFile.readUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = UtilComparator.getUniversityComparator(UniversityComparatorEnum.ID);
        universities.sort(universityComparator);
        /*String universityToJson = JsonUtil.universityListToJson(universities);
        System.out.println(universityToJson);

        List<University> fromJsonToUniversity = JsonUtil.jsonToUniversityList(universityToJson);
        System.out.println(universities.size() == fromJsonToUniversity.size());

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University jsonUniversity = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(jsonUniversity);
        });*/

        List<Statistics> statisticsList = StatisticUtil.createStatistics(students, universities);
        XlsWriter.writeXls(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
    }
}
