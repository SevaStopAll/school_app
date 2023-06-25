package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.ClassDay;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.SchoolDay;
import ru.sevastopall.schoolapp.repository.ClassDayRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleClassDayService implements ClassDayService {
    private ClassDayRepository classDays;

    /**
     * Добавить расписание для класса на день
     * @param classDay расписание для класса
     * @return Optional расписания.
     */
    @Override
    public Optional<ClassDay> save(ClassDay classDay) {
        return Optional.of(classDays.save(classDay));
    }

    /**
     * Найти расписание для класса на день по идентификатору
     * @param id идентификатор
     * @return Optional расписания.
     */
    @Override
    public Optional<ClassDay> findById(int id) {
        return classDays.findById(id);
    }

    /**
     * Найти расписания для класса на день по классу
     * @param schoolClass класс
     * @return список расписаний на день.
     */
    @Override
    public Collection<ClassDay> findBySchoolClass(SchoolClass schoolClass) {
        return classDays.findBySchoolClass(schoolClass);
    }

    /**
     * Найти расписания для класса на день по учебному дню
     * @param schoolDay учебный день
     * @return список расписаний на день.
     */
    @Override
    public Collection<ClassDay> findBySchoolDay(SchoolDay schoolDay) {
        return classDays.findBySchoolDay(schoolDay);
    }

    /**
     * Найти все расписания для всех классов на день
     * @return список всех расписаний на день на все классы.
     */
    @Override
    public Collection<ClassDay> findAll() {
        return classDays.findAll();
    }

    /**
     * Найти расписания для класса на день по классу и дате
     * @param schoolClass класс
     * @param date - дата
     * @return Optional расписания.
     */
    @Override
    public Optional<ClassDay> findBySchoolClassAndDate(SchoolClass schoolClass, LocalDate date) {
        return classDays.findBySchoolClassAndDate(schoolClass, date);
    }
}
