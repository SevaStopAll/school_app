package ru.sevastopall.school_app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "school_week")
public class SchoolWeek {
    int id;
    @Column(name = "start_day")
    LocalDate startDay;
    @Column(name = "start_end")
    LocalDate endDay;
    Set<SchoolDay> schoolDays;
}
