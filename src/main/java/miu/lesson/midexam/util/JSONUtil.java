package miu.lesson.midexam.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtil {

    public static String convertListToJson(List<?> objects) {
        // Serialize list to JSON
        JSONArray jsonArray = new JSONArray();
        objects.forEach(obj -> jsonArray.put(new JSONObject(obj)));
        return jsonArray.toString(4); // Pretty print with indentation
    }    
    
}
