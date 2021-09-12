package date;

import java.lang.reflect.Method;

public class TestAnnotation {

    public static void main(String[] args) throws Exception {
        Class<TestAnnotation> ac = TestAnnotation.class;
        Method method = ac.getMethod("show");

        MyAnnotation[] annotations = method.getAnnotationsByType(MyAnnotation.class);
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i].value());
        }
    }

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(){

    }

}
