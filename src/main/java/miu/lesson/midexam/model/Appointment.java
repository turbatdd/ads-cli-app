package miu.lesson.midexam.model;

import miu.lesson.midexam.model.person.Dentist;
import miu.lesson.midexam.model.person.Patient;
import org.json.JSONObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("hh:mm a");

    private String id;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private LocalDate bookingDate;
    private AppointmentStatus status;
    private Patient patient;
    private Dentist dentist;
    private Surgery surgery;

    public Appointment(String id, LocalDate appointmentDate, LocalTime appointmentTime,
                       LocalDate bookingDate, Patient patient, Dentist dentist,
                       Surgery surgery, AppointmentStatus status) {
        this.id              = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.bookingDate     = bookingDate;
        this.patient         = patient;
        this.dentist         = dentist;
        this.surgery         = surgery;
        this.status          = status;
    }

    public String getId()                     { return id; }
    public LocalDate getAppointmentDate()    { return appointmentDate; }
    public LocalTime getAppointmentTime()    { return appointmentTime; }
    public LocalDate getBookingDate()        { return bookingDate; }
    public AppointmentStatus getStatus()     { return status; }
    public Patient getPatient()              { return patient; }
    public Dentist getDentist()              { return dentist; }
    public Surgery getSurgery()              { return surgery; }

    public void confirm() { this.status = AppointmentStatus.CONFIRMED; }
    public void cancel()  { this.status = AppointmentStatus.CANCELLED; }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id",              id);
        json.put("appointmentDate", appointmentDate.toString());
        json.put("appointmentTime", appointmentTime.format(TIME_FMT));
        json.put("bookingDate",     bookingDate.toString());
        json.put("status",          status.name());
        if (patient != null) json.put("patient",  patient.toJSONObject());
        if (dentist != null) json.put("dentist",  dentist.toJSONObject());
        if (surgery != null) json.put("surgery",  surgery.toJSONObject());
        return json;
    }
}
