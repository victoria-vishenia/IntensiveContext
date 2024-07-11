# IntensiveContext

A custom implementation of framework similar to Spring ApplicationContext. Responsible for managing components within a specifies package using annotations.

## Features

-Annotation-based component scanning ('@IntensiveComponent')
-Dependency injection of annotated fields
-Lazy instantiation of components
-Dependency management using 'SearchService', 'InjectionService'and 'DependencyFactory'

## Project Structure

- **IntensiveContext**: The main context class responsible for managing components.
- **@IntensiveComponent**: Custom annotation used to mark classes as components.
- **SearchSercice**: Service for scanning package for required components.
- **InjectionService**: Service for injecting components fields.
- **DependencyFactory**: Factory for creating component instances.
