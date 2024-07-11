package context;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * Interface for searching appropriate components within a package
 */
public interface SearchService {
    /**
    * Searching necessary classes
     *
     * @param packageName source for searching
     * @param appropriateClass appropriate mark for searching
     * @return a set of appropriate classes
     * @throws IOException if package doesn't exist
     * @throws ClassNotFoundException if gotten class not found
     */
    Set<Class<?>> findComponents(String packageName, Class<?> appropriateClass) throws IOException, ClassNotFoundException;
}

