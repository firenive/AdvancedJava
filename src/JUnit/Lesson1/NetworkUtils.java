package JUnit.Lesson1;

public class NetworkUtils {
    public static void getConnection(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
