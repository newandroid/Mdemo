package css.com.designpattern.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by css on 2018-03-17.
 * 容器管理单例模式
 */

public class SingletonManager {
    private static Map<String, Object> objectMap = new HashMap<>();

    public static void registerService(String key, Object instance) {
        if (objectMap.containsKey(key)) {
            objectMap.put(key, instance);
        }
    }
    public static Object getService(String key) {
        return objectMap.get(key);
    }
}
