package optional;

import java.util.ArrayList;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
//        Optional<String> optional = Optional.of("HELLO");
//        System.out.println(optional.get());
//
//        Optional<Object> empty = Optional.empty();
//        System.out.println(empty.get());

        Optional<String> obj = Optional.ofNullable("4455345454356");
        if(!obj.isPresent()){
            System.out.println(obj.get());
        }else{
//            Object empty = obj.orElse("EMPTY");
//            System.out.println(empty);

            String o = obj.orElseGet(() -> "GG");
            System.out.println(o);

            Optional<Integer> integer = obj.map((e -> e.length()));
            System.out.println(integer.get());

            Optional<Object> str = obj.flatMap((e) -> Optional.of(e.length()));
            System.out.println(str.get());

            ArrayList<String> list = new ArrayList<>();
        }

    }
}
