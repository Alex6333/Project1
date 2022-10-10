package io;

import model.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    private XlsWriter() {
    }

    public static void writeXls(List<Statistics> statisticsList, String filepath) throws IOException {

        XSSFWorkbook  xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Статистика");

        Font headerFont = xssfWorkbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 13);
        CellStyle headerStyle = xssfWorkbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int row = 0;
        Row headerRow = xssfSheet.createRow(row++);
        Cell profileCellHeader = headerRow.createCell(0);
        profileCellHeader.setCellValue("Профиль обучения");
        profileCellHeader.setCellStyle(headerStyle);
        Cell avgExamScoreCellHeader = headerRow.createCell(1);
        avgExamScoreCellHeader.setCellValue("Средний балл за экзамен");
        avgExamScoreCellHeader.setCellStyle(headerStyle);
        Cell numberOfStudentsCellHeader = headerRow.createCell(2);
        numberOfStudentsCellHeader.setCellValue("Количество студентов по профилю");
        numberOfStudentsCellHeader.setCellStyle(headerStyle);
        Cell numberOfUniversitiesCellHeader = headerRow.createCell(3);
        numberOfUniversitiesCellHeader.setCellValue("Количество университетов по профилю");
        numberOfUniversitiesCellHeader.setCellStyle(headerStyle);
        Cell univertityCellHeader = headerRow.createCell(4);
        univertityCellHeader.setCellValue("Университеты");
        univertityCellHeader.setCellStyle(headerStyle);

        for (Statistics statistics: statisticsList) {
            Row dataRow = xssfSheet.createRow(row++);
            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistics.getProfile().getProfileName());
            Cell avgScoreCell = dataRow.createCell(1);
            avgScoreCell.setCellValue(statistics.getAvgExamScore());
            Cell numberOfStudents = dataRow.createCell(2);
            numberOfStudents.setCellValue(statistics.getNumberOfStudents());
            Cell numberOfUniversities = dataRow.createCell(3);
            numberOfUniversities.setCellValue(statistics.getNumberOfUniversities());
            Cell universityCell = dataRow.createCell(4);
            universityCell.setCellValue(statistics.getUniversityName());
        }

        try(FileOutputStream outputStream = new FileOutputStream(filepath)) {
            xssfWorkbook.write(outputStream);
        }
    }
}
