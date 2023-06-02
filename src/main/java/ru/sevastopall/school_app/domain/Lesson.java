package ru.sevastopall.school_app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "lesson_date")
    private LocalDate lessonDate;

    private int number;

    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Lesson(String name) {
        this.name = name;
    }
}
