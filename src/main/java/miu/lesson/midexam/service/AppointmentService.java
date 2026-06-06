package miu.lesson.midexam.service;

import miu.lesson.midexam.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointmentsSortedDesc();

    List<Appointment> getQuarterlyUpcomingAppointments();
}
