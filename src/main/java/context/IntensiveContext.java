package context;

import annotations.IntensiveComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Context managing components annotated with @IntensiveComponent
 */
public class IntensiveContext {

  private final String packageName;
  private final Map<Class<?>, Object> components =new HashMap<>();
  private final SearchService searchService=new IntensiveSearchService();;
  private final DependencyFactory dependencyFactory=new IntensiveDependencyFactory();;
  private final InjectionService injectionService=new IntensiveInjectionService();

    /**
     * Construct the context
     * @param packageName the package to search components
     */
    public IntensiveContext(String packageName) {
        this.packageName = packageName;
    }

    /**
     * Gets the instance of special class and puts in Map of components
     * @param type type of retrieved component
     * @return an instance of required type
     * @param <T> type of returning component
     * @throws Exception if it occurs during instantiation or injecting dependency
     */
    public <T>T getObject(Class<T> type) throws Exception {

    Set<Class<?>> implementations=searchService.findComponents(packageName, IntensiveComponent.class)
            .stream()
            .filter(type::isAssignableFrom)
            .collect(Collectors.toSet());

      if(implementations.isEmpty()){
          throw new Exception("No such implementations of " + type.getName());
      }
      if(implementations.size()>1){
          throw new Exception("Multiple implementations found for "+ type.getName());
      }
      Class<?> implementationClass = implementations.iterator().next();
      T instance = type.cast(dependencyFactory.createInstance(implementationClass));
      injectionService.injectDependency(instance, this);
      components.put(type, instance);
      return instance;
  }
}
