package miu.lesson.midexam.service.impl;

import miu.lesson.midexam.model.Appointment;
import miu.lesson.midexam.repository.AppointmentRepository;
import miu.lesson.midexam.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository = AppointmentRepository.getInstance();

    public List<Appointment> getAllAppointmentsSortedDesc() {
        return appointmentRepository.findAll().stream()
                .sorted(Comparator
                        .comparing((Appointment a) -> LocalDateTime.of(a.getAppointmentDate(), a.getAppointmentTime()))
                        .reversed())
                .collect(Collectors.toList());
    }

    public List<Appointment> getQuarterlyUpcomingAppointments() {
        LocalDate start = getNextQuarterStart();
        LocalDate end = getNextQuarterEnd();
        return appointmentRepository.findAll().stream()
                .filter(a -> !a.getAppointmentDate().isBefore(start)
                        && !a.getAppointmentDate().isAfter(end))
                .sorted(Comparator.comparing(
                        (Appointment a) -> LocalDateTime.of(a.getAppointmentDate(), a.getAppointmentTime())))
                .collect(Collectors.toList());
    }

    public LocalDate getNextQuarterStart() {
        LocalDate today = LocalDate.now();
        int q = (today.getMonthValue() - 1) / 3 + 1;
        int nextQ = (q % 4) + 1;
        int year = q == 4 ? today.getYear() + 1 : today.getYear();
        return LocalDate.of(year, (nextQ - 1) * 3 + 1, 1);
    }

    public LocalDate getNextQuarterEnd() {
        return getNextQuarterStart().plusMonths(3).minusDays(1);
    }

    public int getNextQuarterNum() {
        LocalDate today = LocalDate.now();
        int q = (today.getMonthValue() - 1) / 3 + 1;
        return (q % 4) + 1;
    }

    public int getNextQuarterYear() {
        LocalDate today = LocalDate.now();
        int q = (today.getMonthValue() - 1) / 3 + 1;
        return q == 4 ? today.getYear() + 1 : today.getYear();
    }
}
