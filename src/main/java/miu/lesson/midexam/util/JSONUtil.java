package miu.lesson.midexam.util;

import miu.lesson.midexam.model.Appointment;
import org.json.JSONArray;

import java.util.List;

public class JSONUtil {

    public static String appointmentsToJson(List<Appointment> appointments) {
        JSONArray array = new JSONArray();
        appointments.forEach(a -> array.put(a.toJSONObject()));
        return array.toString(4);
    }
}
