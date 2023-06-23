package ru.sevastopall.school_app.utils;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import ru.sevastopall.school_app.domain.Homework;
import ru.sevastopall.school_app.domain.Mark;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.domain.Teacher;
import ru.sevastopall.school_app.service.*;

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

    private CellStyle setStyle(Workbook book) {
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        style.setFont(font);
        return style;
    }

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

    private void writeHomework(Sheet sheet, Homework homework, AtomicInteger rowCounter) {
        Row tableRow = sheet.createRow(rowCounter.get());
        int cellCounter = 0;
        Cell subjectName = tableRow.createCell(cellCounter++);
        subjectName.setCellValue(homework.getSubject().getName());
        Cell description = tableRow.createCell(cellCounter++);
        description.setCellValue(homework.getDescription());
    }

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
            book.write(new FileOutputStream("./src/main/resources/data/report.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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