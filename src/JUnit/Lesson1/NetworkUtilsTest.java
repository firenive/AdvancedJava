package JUnit.Lesson1;

import org.junit.Test;

public class NetworkUtilsTest {
    @Test(timeout = 1000) // Максимальное время выполнения теста 1 секунда, иначе тест провален
    public void getConnectionShouldReturnResultFasterSecond() {
        NetworkUtils.getConnection();
        // // test timed out after 1000 milliseconds
    }
}
