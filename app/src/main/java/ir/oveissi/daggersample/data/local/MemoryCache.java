package ir.oveissi.daggersample.data.local;

import android.support.v4.util.LruCache;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by abbas on 9/5/17.
 */

public class MemoryCache {

    LruCache<String, Object> objectCacher;

    @Inject
    public MemoryCache(@Named("cacheSize") int cacheSize) {
        objectCacher = new LruCache<>(cacheSize);
    }

    public void add(String key,Object value)
    {
        objectCacher.put(key,value);
    }

    public Object get(String key)
    {
        return objectCacher.get(key);
    }
}
