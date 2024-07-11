package annotations;

import java.lang.annotation.*;

/**
 * Annotation for marking class as a component fot IntensiveContext
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IntensiveComponent {
}
