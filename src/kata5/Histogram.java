package kata5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram <T> {
    
    private final Map<T, Integer> histogram = new HashMap<>();

    public Integer get(Object key) {
        return histogram.get(key);
    }

    public boolean containsKey(Object key) {
        return histogram.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return histogram.containsValue(value);
    }

    public Set<T> keySet() {
        return histogram.keySet();
    }
    
    public Integer increment(T key) {
        return histogram.put(key, histogram.containsKey(key)? histogram.get(key) + 1 : 1);
    }
    
}
