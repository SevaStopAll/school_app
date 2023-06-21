package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.ClassDay;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.SchoolDay;
import ru.sevastopall.school_app.repository.ClassDayRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleClassDayService implements ClassDayService {
    private ClassDayRepository classDays;

    @Override
    public Optional<ClassDay> save(ClassDay classDay) {
        return Optional.of(classDays.save(classDay));
    }

    @Override
    public Optional<ClassDay> findById(int id) {
        return classDays.findById(id);
    }

    @Override
    public Collection<ClassDay> findBySchoolClass(SchoolClass schoolClass) {
        return classDays.findBySchoolClass(schoolClass);
    }

    @Override
    public Collection<ClassDay> findBySchoolDay(SchoolDay schoolDay) {
        return classDays.findBySchoolDay(schoolDay);
    }

    @Override
    public Collection<ClassDay> findAll() {
        return classDays.findAll();
    }

    @Override
    public Optional<ClassDay> findBySchoolClassAndDate(SchoolClass schoolClass, LocalDate date) {
        return classDays.findBySchoolClassAndDate(schoolClass, date);
    }
}
