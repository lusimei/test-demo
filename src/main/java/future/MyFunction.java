package future;

@FunctionalInterface
public interface MyFunction<T,R> {

    R getValue(T t1,T t2);
}
