package miu.lesson.midexam.model.person;

import org.json.JSONObject;
import java.time.LocalDate;
import java.time.Period;

public class Patient extends Person {
    private LocalDate dateOfBirth;
    private String mailingAddress;

    public Patient(String id, String firstName, String lastName,
                   String email, String phone,
                   LocalDate dateOfBirth, String mailingAddress) {
        super(id, firstName, lastName, email, phone);
        this.dateOfBirth    = dateOfBirth;
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getDateOfBirth()  { return dateOfBirth; }
    public String getMailingAddress()  { return mailingAddress; }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public void viewAppointments() { }
    public void requestCancel()    { }
    public void requestChange()    { }
    public boolean hasUnpaidBill() { return false; }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id",             id);
        json.put("firstName",      firstName);
        json.put("lastName",       lastName);
        json.put("email",          email);
        json.put("phone",          phone);
        json.put("dateOfBirth",    dateOfBirth.toString());
        json.put("age",            getAge());
        json.put("mailingAddress", mailingAddress);
        return json;
    }
}
