package context;

import annotations.IntensiveComponent;

import java.lang.reflect.Field;


/**
*Implementation of InjectionService interface.
 *
 */
public class IntensiveInjectionService implements InjectionService{

    /**
     * Injects fields annotated with IntensiveComponent in component
     * @param instance the instance in which dependencies injected
     * @param context the context used for getting dependencies
     * @throws Exception if counters with issues through creating an instance
     */
    public void injectDependency(Object instance, IntensiveContext context) throws Exception {
        Field[]fields=instance.getClass().getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(IntensiveComponent.class)){
                Object injectedObject = context.getObject(field.getType());
                field.setAccessible(true);
                field.set(instance, injectedObject);
            }
        }
    }
}
