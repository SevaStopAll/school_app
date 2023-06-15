package ru.sevastopall.school_app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "class_day")
public class ClassDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="class_day_date")
    private LocalDate date;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "class_day_lesson",
            joinColumns = { @JoinColumn(name = "class_day_id") },
            inverseJoinColumns = { @JoinColumn(name = "lesson_id") }
    )
    private List<Lesson> lessons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_day_id")
    private SchoolDay schoolDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

    public Lesson findLessonByNumber(int number) {
        Optional<Lesson> result = lessons.stream().filter(l -> l.getNumber() == number).findFirst();
        if (result.isPresent()) {
            return result.get();
        }
        return new Lesson("Нет урока");
    }
}
