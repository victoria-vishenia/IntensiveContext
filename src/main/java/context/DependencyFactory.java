package context;


/**
 * Responsible fot creating and managing dependencies.
 */
public interface DependencyFactory {
    /**
     * Create an instance of required class.
     * @param tClass type of created instance
     * @return an instance of required type
     * @param <T> type of return instance
     * @throws Exception if counters with issues through creating an instance
     */

    <T> T createInstance(Class<T> tClass) throws Exception;
}
