import classes.SomeClass1;
import context.IntensiveContext;

public class Main {

    public static void main(String[] args) throws Exception {
        IntensiveContext context = new IntensiveContext("classes");
        SomeClass1 class1 =  context.getObject(SomeClass1.class);
        class1.run();
    }
}
