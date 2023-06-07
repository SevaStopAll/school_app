package ru.sevastopall.school_app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "school_day")
public class SchoolDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "school_day_date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "week_id")
    private SchoolWeek week;

}
