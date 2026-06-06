package miu.lesson.midexam.service;

import miu.lesson.midexam.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointmentsSortedDesc();

    List<Appointment> getQuarterlyUpcomingAppointments();

    LocalDate getNextQuarterStart();

    LocalDate getNextQuarterEnd();

    int getNextQuarterNum();

    int getNextQuarterYear();
}
