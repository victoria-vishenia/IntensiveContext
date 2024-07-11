package context;

import java.lang.reflect.Constructor;

/**
 * Implementation of DependencyFactory interface
 */

public class IntensiveDependencyFactory implements DependencyFactory{
    /**
     * Creates an instance of required type
     * @param type type of created instance
     * @return instance
     * @param <T> type of created instance
     * @throws Exception if counters with issues through creating an instance
     */

    public <T>T createInstance(Class<T> type) throws Exception {
           Constructor<T> constructor = type.getDeclaredConstructor();
           constructor.setAccessible(true);
           T instance =constructor.newInstance();
            return instance;
        }
    }

