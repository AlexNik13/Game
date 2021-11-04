package common;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NewLevel {
    public static Map<Integer, Integer> experienceLevelUp = new HashMap<>();

    static {
        experienceLevelUp.put(1, 9);
        experienceLevelUp.put(2, 19);
        experienceLevelUp.put(3, 49);
        experienceLevelUp.put(4, 99);
    }

}
