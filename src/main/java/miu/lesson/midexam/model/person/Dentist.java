package miu.lesson.midexam.model.person;

import org.json.JSONObject;

public class Dentist extends Person {
    private String speciality;
    private String licenceNo;

    public Dentist(String id, String firstName, String lastName,
                   String email, String phone,
                   String speciality, String licenceNo) {
        super(id, firstName, lastName, email, phone);
        this.speciality = speciality;
        this.licenceNo  = licenceNo;
    }

    public String getSpeciality() { return speciality; }
    public String getLicenceNo()  { return licenceNo; }

    public void viewSchedule() { }
    public int weeklyCount()   { return 0; }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id",         id);
        json.put("firstName",  firstName);
        json.put("lastName",   lastName);
        json.put("email",      email);
        json.put("phone",      phone);
        json.put("speciality", speciality);
        json.put("licenceNo",  licenceNo);
        return json;
    }
}
