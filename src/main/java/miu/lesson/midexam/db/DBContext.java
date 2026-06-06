package miu.lesson.midexam.db;
import java.util.List;
import java.util.UUID;

public class DBContext {
    private static DBContext instance;

    private DBContext() {
    }

    public static synchronized DBContext getInstance() {
        if (instance == null) {
            instance = new DBContext();
        }
        return instance;
    }

    private void loadData() {

    }
}
