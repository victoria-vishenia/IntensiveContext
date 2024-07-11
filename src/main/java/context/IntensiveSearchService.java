package context;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Looking for classes,annotated with Intensive annotation.
 *
 */

public class IntensiveSearchService implements SearchService{

    /**
     * @param packageName - package for searching,
     * @param annotation - necessary annotation
     * @return - Set of classes which have this annotation
     * @throws IOException if package doesn't exist
     * @throws ClassNotFoundException if gotten class not found
     */

    public Set<Class<?>> findComponents(String packageName, Class<?> annotation) throws IOException, ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        String path = packageName.replace('.', '/');
         ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL resource = loader.getResource(path);

        if (resource == null) {
            throw new IOException("There are no package with name " + packageName);
        }

        File directory = new File(resource.getFile());
        if (!directory.exists()) {
            throw new IOException("There are no directory " + directory);
        }
        for (File file: directory.listFiles()){
            if (file.getName().endsWith(".class")){
                String className = packageName + '.' + file.getName().substring(0, file.getName().length()-6);
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) annotation)){
                classes.add(clazz);
            }
            }
        }
            return classes;
    }
}
