package ru.sevastopall.schoolapp.unit.controller;

import org.junit.jupiter.api.BeforeEach;
import ru.sevastopall.schoolapp.service.HomeworkService;
import ru.sevastopall.schoolapp.service.MarkService;
import ru.sevastopall.schoolapp.service.StudentService;
import ru.sevastopall.schoolapp.service.UserService;
import ru.sevastopall.schoolapp.utils.ReportSender;
import ru.sevastopall.schoolapp.utils.XLSXReportMaker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class StudentControllerTest {

    private HomeworkService homeworks;
    private MarkService marks;
    private StudentService students;
    private UserService users;

    private XLSXReportMaker maker;

    private ReportSender sender;

    @BeforeEach
    public void initServices() {
        homeworks = mock(HomeworkService.class);
        marks = mock(MarkService.class);
        students = mock(StudentService.class);
        users = mock(UserService.class);
        maker = mock(XLSXReportMaker.class);
        sender = mock(ReportSender.class);
    }

}