import java.util.HashMap;

/**
 * Author: chunxing
 * Date: 2018/8/1  下午9:49
 * Description:
 */
public class MainTest {

    public static void main(String[] args) {
        HashMap<Integer, ObjectTest> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            map.put(1, new ObjectTest());
        }
    }
}
