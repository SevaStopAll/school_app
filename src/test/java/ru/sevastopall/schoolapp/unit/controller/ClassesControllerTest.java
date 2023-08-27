package ru.sevastopall.schoolapp.unit.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.springframework.ui.ConcurrentModel;
import ru.sevastopall.schoolapp.controller.ClassesController;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.service.MarkService;
import ru.sevastopall.schoolapp.service.SchoolClassService;
import ru.sevastopall.schoolapp.service.StudentService;


import java.util.Optional;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class ClassesControllerTest {

    private ClassesController classesController;
    private SchoolClassService classService;
    private StudentService students;
    private MarkService marks;

    @BeforeEach
    public void initServices() {
        classService = mock(SchoolClassService.class);
        students = mock(StudentService.class);
        marks = mock(MarkService.class);
        classesController = new ClassesController(classService, students, marks);
    }

    @Test
    public void whenRequestClassesListThenGetPageWithClasses() {
        SchoolClass class1 = new SchoolClass(1, "class1");
        SchoolClass class2 = new SchoolClass(2, "class2");
        Set<SchoolClass> classes = Set.of(class1, class2);
        when(classService.findAll()).thenReturn(classes);
        var model = new ConcurrentModel();
        var view = classesController.getClasses(model);
        var actualClasses = model.getAttribute("classes");
        assertThat(view).isEqualTo("admin/classes/list");
        assertThat(actualClasses).isEqualTo(classes);
    }

    @Test
    public void whenRequestCreateClassThenGetCreationClass() {
        var view = classesController.getClassCreationPage();
        assertThat(view).isEqualTo("admin/classes/create");
    }

    @Test
    public void whenSaveClassThenRedirect() {
        SchoolClass class1 = new SchoolClass(1, "1a");
        var classArgumentCaptor = ArgumentCaptor.forClass(SchoolClass.class);
        when(classService.save(classArgumentCaptor.capture())).thenReturn(Optional.of(class1));
        var model = new ConcurrentModel();
        var view = classesController.saveClass(class1);
        var actualClass = classArgumentCaptor.getValue();
        assertThat(view).isEqualTo("redirect:/");
        assertThat(actualClass).isEqualTo(class1);
    }

}