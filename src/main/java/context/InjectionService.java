package context;


/**
 * Service for injecting dependencies into components
 */
public interface InjectionService {

    /**
     * Injects dependency into the component
     * @param instance the instance in which dependencies injected
     * @param context the context used for getting dependencies
     * @throws Exception if counters with issues through injecting dependency
     */

    void injectDependency(Object instance, IntensiveContext context) throws Exception;
}
