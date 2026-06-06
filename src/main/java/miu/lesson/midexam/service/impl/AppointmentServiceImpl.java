package miu.lesson.midexam.service.impl;

import miu.lesson.midexam.model.Appointment;
import miu.lesson.midexam.repository.AppointmentRepository;
import miu.lesson.midexam.service.AppointmentService;
import miu.lesson.midexam.service.ReportService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository = AppointmentRepository.getInstance();
    private final ReportService reportService = new ReportServiceImpl();

    @Override
    public List<Appointment> getAllAppointmentsSortedDesc() {
        return appointmentRepository.findAll().stream()
                .sorted(Comparator
                        .comparing((Appointment a) -> LocalDateTime.of(a.getAppointmentDate(), a.getAppointmentTime()))
                        .reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> getQuarterlyUpcomingAppointments() {
        LocalDate start = reportService.getNextQuarterStart();
        LocalDate end   = reportService.getNextQuarterEnd();
        return appointmentRepository.findAll().stream()
                .filter(a -> !a.getAppointmentDate().isBefore(start)
                        && !a.getAppointmentDate().isAfter(end))
                .sorted(Comparator.comparing(
                        (Appointment a) -> LocalDateTime.of(a.getAppointmentDate(), a.getAppointmentTime())))
                .collect(Collectors.toList());
    }
}
