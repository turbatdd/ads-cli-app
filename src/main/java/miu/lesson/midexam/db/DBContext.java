package miu.lesson.midexam.db;

import miu.lesson.midexam.model.Appointment;
import miu.lesson.midexam.model.AppointmentStatus;
import miu.lesson.midexam.model.Bill;
import miu.lesson.midexam.model.Surgery;
import miu.lesson.midexam.model.person.Dentist;
import miu.lesson.midexam.model.person.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DBContext {
    private static DBContext instance;

    private final List<Patient>      patients      = new ArrayList<>();
    private final List<Dentist>      dentists      = new ArrayList<>();
    private final List<Surgery>      surgeries     = new ArrayList<>();
    private final List<Appointment>  appointments  = new ArrayList<>();
    private final List<Bill>         bills         = new ArrayList<>();

    private DBContext() {
        loadData();
    }

    public static synchronized DBContext getInstance() {
        if (instance == null) {
            instance = new DBContext();
        }
        return instance;
    }

    public List<Patient>     getPatients()     { return patients; }
    public List<Dentist>     getDentists()     { return dentists; }
    public List<Surgery>     getSurgeries()    { return surgeries; }
    public List<Appointment> getAppointments() { return appointments; }
    public List<Bill>        getBills()        { return bills; }

    private void loadData() {
        // --- Dentists ---
        Dentist d1 = new Dentist("D001", "Michael", "Brown",
                "m.brown@ads.com", "(515) 200-0001",
                "General Dentistry", "LIC-001");
        Dentist d2 = new Dentist("D002", "Sarah", "Williams",
                "s.williams@ads.com", "(515) 200-0002",
                "Orthodontics", "LIC-002");
        dentists.add(d1);
        dentists.add(d2);

        // --- Surgery ---
        Surgery s1 = new Surgery(
                "S001", "ADS Downtown Clinic",
                "123 Main Street", "Des Moines", "(515) 555-0101");
        surgeries.add(s1);

        // --- Patients ---
        Patient p1 = new Patient("P001", "John", "Smith",
                "john.smith@email.com", "(641) 001-1234",
                LocalDate.of(1987, 1, 19),
                "456 Oak Avenue, Iowa City, Iowa 52240");

        Patient p2 = new Patient("P002", "Anna", "Jones",
                "anna.jones@email.com", "(319) 716-1987",
                LocalDate.of(2001, 7, 26),
                "789 Elm Street, Cedar Rapids, Iowa 52401");

        Patient p3 = new Patient("P003", "Carlos", "Jimenez",
                "carlos.jimenez@email.com", "(319) 098-7711",
                LocalDate.of(1969, 11, 5),
                "321 Pine Road, Davenport, Iowa 52801");

        Patient p4 = new Patient("P004", "Albert", "Einstein",
                "albert.einstein@email.com", "(641) 119-6142",
                LocalDate.of(1955, 12, 28),
                "999 Science Boulevard, Ames, Iowa 50010");

        patients.add(p1);
        patients.add(p2);
        patients.add(p3);
        patients.add(p4);

        // --- Appointments (seed data) ---
        LocalDate today = LocalDate.now();

        appointments.add(new Appointment(
                1, LocalDate.of(2026, 2, 28), LocalTime.of(10, 5),
                today, p1, d1, s1, AppointmentStatus.CONFIRMED));

        appointments.add(new Appointment(
                2, LocalDate.of(2025, 12, 31), LocalTime.of(13, 45),
                today, p2, d2, s1, AppointmentStatus.CONFIRMED));

        appointments.add(new Appointment(
                3, LocalDate.of(2027, 5, 4), LocalTime.of(14, 0),
                today, p3, d1, s1, AppointmentStatus.CONFIRMED));

        appointments.add(new Appointment(
                4, LocalDate.of(2026, 9, 16), LocalTime.of(11, 15),
                today, p4, d2, s1, AppointmentStatus.CONFIRMED));
    }
}
