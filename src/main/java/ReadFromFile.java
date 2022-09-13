import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFromFile {

    private ReadFromFile() {
    }

    public static List<Student> readStudents(String filepath) throws IOException {
        List<Student> students = new ArrayList<>();

        FileInputStream fin = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fin);
        XSSFSheet sheet = workbook.getSheet("Студенты");

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            Student student = new Student();
            students.add(student);
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
        }

        return students;
    }

    public static List<University> readUniversity(String filepath) throws IOException{
        List<University> universities = new ArrayList<>();

        FileInputStream fin = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fin);
        XSSFSheet sheet = workbook.getSheet("Университеты");

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            University university = new University();
            universities.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
        }

        return universities;
    }
}