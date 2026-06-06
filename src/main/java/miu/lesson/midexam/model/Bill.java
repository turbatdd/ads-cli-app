package miu.lesson.midexam.model;

import miu.lesson.midexam.model.person.Patient;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Bill {
    private String id;
    private Patient patient;
    private Appointment appointment;
    private BigDecimal amount;
    private LocalDate issueDate;
    private boolean paid;

    public Bill(String id, Patient patient, Appointment appointment,
                BigDecimal amount, LocalDate issueDate, boolean paid) {
        this.id          = id;
        this.patient     = patient;
        this.appointment = appointment;
        this.amount      = amount;
        this.issueDate   = issueDate;
        this.paid        = paid;
    }

    public String getId()               { return id; }
    public Patient getPatient()         { return patient; }
    public Appointment getAppointment() { return appointment; }
    public BigDecimal getAmount()       { return amount; }
    public LocalDate getIssueDate()     { return issueDate; }
    public boolean isPaid()             { return paid; }

    public boolean isOverdue() {
        return !paid && issueDate.isBefore(LocalDate.now().minusMonths(12));
    }
}
