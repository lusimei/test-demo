package forkjoin;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Optional<NewMan> op = Optional.ofNullable(null);
        String name = getGodnessName(op);
        System.out.println(name);
    }

    public static String getGodnessName(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }
}
