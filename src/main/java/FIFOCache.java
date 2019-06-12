import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    public FIFOCache(int cacheSize) {
        super((int) (cacheSize / 0.75f)); // HashMap.DEFAULT_LOAD_FACTOR
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
}