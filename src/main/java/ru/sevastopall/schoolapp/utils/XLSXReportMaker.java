package ru.sevastopall.schoolapp.utils;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import ru.sevastopall.schoolapp.domain.Homework;
import ru.sevastopall.schoolapp.domain.Mark;
import ru.sevastopall.schoolapp.domain.Student;
import ru.sevastopall.schoolapp.domain.Teacher;
import ru.sevastopall.schoolapp.service.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@AllArgsConstructor
public class XLSXReportMaker implements ReportMaker {
    private HomeworkService homeworks;
    private MarkService marks;
    private StudentService students;
    private UserService users;
    private TeacherService teachers;

    /**
     * Создать стиль
     *
     * @return стиль для заголовков таблицы.
     */
    private CellStyle setStyle(Workbook book) {
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        style.setFont(font);
        return style;
    }

    /**
     * Создать страницу с общими данными по оценкам
     *
     * @return страница с общими данными по оценкам.
     */
    private XSSFSheet createStaticSheet(XSSFWorkbook book, CellStyle style) {
        XSSFSheet sheet = book.createSheet("Общие данные");
        Row row = sheet.createRow(0);
        Cell subject = row.createCell(0);
        subject.setCellValue("Предмет");
        subject.setCellStyle(style);
        Cell avgMark = row.createCell(1);
        avgMark.setCellValue("Средняя оценка");
        avgMark.setCellStyle(style);
        Cell countMark = row.createCell(2);
        countMark.setCellValue("Количество оценок");
        countMark.setCellStyle(style);
        return sheet;
    }

    /**
     * Создать страницу с оценками
     *
     * @return страница с оценками для ученика/учителя.
     */
    private XSSFSheet createMarkSheet(XSSFWorkbook book, CellStyle style) {
        XSSFSheet sheet = book.createSheet("Оценки");
        Row row = sheet.createRow(0);
        Cell mark = row.createCell(0);
        mark.setCellValue("Оценка");
        mark.setCellStyle(style);
        Cell subject = row.createCell(1);
        subject.setCellValue("Предмет");
        subject.setCellStyle(style);
        Cell students = row.createCell(2);
        students.setCellValue("Студент / Преподаватель");
        students.setCellStyle(style);
        return sheet;
    }

    /**
     * Создать страницу с домашними заданиями
     *
     * @return страница с домашними заданиями для ученика/учителя.
     */
    private XSSFSheet createHomeworkSheet(XSSFWorkbook book, CellStyle style) {
        XSSFSheet homeworkSheet = book.createSheet("Домашние задания");
        Row row1 = homeworkSheet.createRow(0);
        Cell subject1 = row1.createCell(0);
        subject1.setCellValue("Предмет");
        subject1.setCellStyle(style);
        Cell homework = row1.createCell(1);
        homework.setCellValue("Домашнее задание");
        homework.setCellStyle(style);
        return homeworkSheet;
    }

    /**
     * Записать оценку на страницу
     * @param sheet текущий лист
     * @param mark текущая оценка
     * @param lastCellValue клетка для записи
     * @param rowCounter строка для записи
     */
    private void writeMark(Sheet sheet, Mark mark, String lastCellValue, AtomicInteger rowCounter) {
        Row tableRow = sheet.createRow(rowCounter.get());
        int cellCounter = 0;
        Cell studentMarkValue = tableRow.createCell(cellCounter++);
        studentMarkValue.setCellValue(mark.getScore().getId());
        Cell subjectName = tableRow.createCell(cellCounter++);
        subjectName.setCellValue(mark.getSubject().getName());
        Cell name = tableRow.createCell(cellCounter++);
        name.setCellValue(lastCellValue);
    }

    /**
     * Записать оценку на страницу
     * @param sheet текущий лист
     * @param homework домашнее задание для записи
     */
    private void writeHomework(Sheet sheet, Homework homework, AtomicInteger rowCounter) {
        Row tableRow = sheet.createRow(rowCounter.get());
        int cellCounter = 0;
        Cell subjectName = tableRow.createCell(cellCounter++);
        subjectName.setCellValue(homework.getSubject().getName());
        Cell description = tableRow.createCell(cellCounter++);
        description.setCellValue(homework.getDescription());
    }

    /**
     * Создать и подготовить к загрузке отчет для ученика:
     * @param studentId идентификатор ученика
     */
    @Override
    public void makeStudentReport(int studentId) {
        var studentOptional = students.findByUser(users.findById(studentId).get());
        Student student = studentOptional.get();
        try (XSSFWorkbook book = new XSSFWorkbook()) {
            CellStyle style = setStyle(book);
            XSSFSheet sheet = createMarkSheet(book, style);
            AtomicInteger rowCounter = new AtomicInteger(1);
            for (Mark studentMark : marks.findByStudent(student)) {
                writeMark(sheet, studentMark, studentMark.getTeacher().getFirstName() + " " + studentMark.getTeacher().getLastName(), rowCounter);
                rowCounter.incrementAndGet();
            }
            rowCounter.set(1);
            XSSFSheet homeworkSheet = createHomeworkSheet(book, style);
            for (Homework homework1 : homeworks.findBySchoolClass(student.getSchoolClass())) {
                writeHomework(homeworkSheet, homework1, rowCounter);
                rowCounter.incrementAndGet();
            }
            // Demo of new feature
            XSSFSheet infoSheet = createStaticSheet(book, style);
            rowCounter.set(1);
            Row tableRow = infoSheet.createRow(rowCounter.get());
            int cellCounter = 0;
            Cell subjectName = tableRow.createCell(cellCounter++);
            subjectName.setCellValue(homework.getSubject().getName());
            Cell avgMark = tableRow.createCell(cellCounter++);
            avgMark.setCellValue(homework.getDescription());
            Cell counterMark = tableRow.createCell(cellCounter++);
            counterMark.setCellValue(marks.getResults());

            // End of new demo
            book.write(new FileOutputStream("./src/main/resources/data/report.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Создать и подготовить к загрузке отчет для учителя:
     * @param teacherId идентификатор учителя
     */
    @Override
    public void makeTeacherReport(int teacherId) {
        var teacherOptional = teachers.findByUser(users.findById(teacherId).get());
        Teacher teacher = teacherOptional.get();
        try (XSSFWorkbook book = new XSSFWorkbook()) {
            CellStyle style = setStyle(book);
            XSSFSheet sheet = createMarkSheet(book, style);
            AtomicInteger rowCounter = new AtomicInteger(1);
            for (Mark studentMark : marks.findByTeacher(teacher)) {
                writeMark(sheet, studentMark, studentMark.getStudent().getFirstName() + " " + studentMark.getStudent().getLastName(), rowCounter);
                rowCounter.incrementAndGet();
            }
            XSSFSheet homeworkSheet = createHomeworkSheet(book, style);
            rowCounter.set(1);
            for (Homework homework1 : homeworks.findByTeacher(teacher)) {
                writeHomework(homeworkSheet, homework1, rowCounter);
                rowCounter.incrementAndGet();
            }
            book.write(new FileOutputStream("./src/main/resources/data/report.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
