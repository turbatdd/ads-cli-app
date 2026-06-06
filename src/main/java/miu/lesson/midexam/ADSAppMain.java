package miu.lesson.midexam;

import miu.lesson.midexam.model.Appointment;
import miu.lesson.midexam.service.AppointmentService;
import miu.lesson.midexam.service.impl.AppointmentServiceImpl;
import miu.lesson.midexam.util.JSONUtil;

import java.time.LocalDate;
import java.util.List;

public class ADSAppMain {
    public static void main(String[] args) {
        AppointmentService appointmentService = new AppointmentServiceImpl();

        System.out.println("=================================================================");
        System.out.println("     ADS Dental Appointment Management System                    ");
        System.out.println("=================================================================");

        System.out.println("\n--- 4.2.1: All Appointments (sorted by Date/Time DESC) ---\n");
        List<Appointment> all = appointmentService.getAllAppointmentsSortedDesc();
        System.out.println(JSONUtil.appointmentsToJson(all));

        System.out.println("\n=================================================================");

        LocalDate today = LocalDate.now();
        int nextQ = appointmentService.getNextQuarterNum();
        int nextQYear = appointmentService.getNextQuarterYear();
        LocalDate start = appointmentService.getNextQuarterStart();
        LocalDate end = appointmentService.getNextQuarterEnd();

        System.out.printf("%n--- 4.2.2: Quarterly Upcoming Appointments (sorted by Date/Time ASC) ---%n");
        System.out.printf("    Today: %s  |  Next Quarter: Q%d %d  [%s to %s]%n%n",
                today, nextQ, nextQYear, start, end);

        List<Appointment> quarterly = appointmentService.getQuarterlyUpcomingAppointments();
        System.out.println(JSONUtil.appointmentsToJson(quarterly));
    }
}
