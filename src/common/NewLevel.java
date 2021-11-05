package common;

import java.util.HashMap;
import java.util.Map;

public class NewLevel {
    public static Map<Integer, Integer> experienceLevelUp = new HashMap<>();

    static {
        experienceLevelUp.put(1, 9);
        experienceLevelUp.put(2, 19);
        experienceLevelUp.put(3, 49);
        experienceLevelUp.put(4, 99);
        experienceLevelUp.put(5, 149);
        experienceLevelUp.put(6, 199);
    }
}
