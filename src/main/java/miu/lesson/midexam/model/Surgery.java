package miu.lesson.midexam.model;

import org.json.JSONObject;

public class Surgery {
    private String id;
    private String name;
    private String address;
    private String city;
    private String phone;

    public Surgery(String id, String name, String address, String city, String phone) {
        this.id      = id;
        this.name    = name;
        this.address = address;
        this.city    = city;
        this.phone   = phone;
    }

    public String getId()      { return id; }
    public String getName()    { return name; }
    public String getAddress() { return address; }
    public String getCity()    { return city; }
    public String getPhone()   { return phone; }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id",      id);
        json.put("name",    name);
        json.put("address", address);
        json.put("city",    city);
        json.put("phone",   phone);
        return json;
    }
}
