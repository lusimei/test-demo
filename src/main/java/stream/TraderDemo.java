package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderDemo {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader cambridge = new Trader("Mario","Cambridge");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brain","Cambridge");
        Trader milan = new Trader("Brain","Milan");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2021, 300),
            new Transaction(brian, 2022, 400),
            new Transaction(raoul, 2011, 940),
            new Transaction(mario, 2012, 950),
            new Transaction(cambridge, 2011, 950),
            new Transaction(milan, 2021, 950),
            new Transaction(alan, 2012,400 )
        );

//        List<Transaction> collect = transactions.stream()
//                .filter((e) -> e.getYear() == 2012)
//                .sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()))
//                .collect(Collectors.toList());
//        System.out.println(collect);

//        List<String> collect = transactions.stream()
//                .map((e) -> e.getTrader().getCity())
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(collect);

//        transactions.stream()
//                .filter((e) -> "Cambridge".equals(e.getTrader().getCity()))
//                .distinct()
//                .sorted((e1,e2) -> e1.getTrader().getName().compareTo(e2.getTrader().getName()))
//                .forEach(System.out::println);

//        transactions.stream()
////                .filter((e) -> "Cambridge".equals(e.getTrader().getCity()))
//                .map((e) -> e.getTrader().getName())
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);

//        String reduce = transactions.stream()
//                .map((e) -> e.getTrader().getName())
//                .distinct()
//                .sorted()
//                .reduce("", String::concat);
//        System.out.println(reduce);

//        boolean b = transactions.stream()
//                .anyMatch((e) -> "Milan".equals(e.getTrader().getCity()));
//        System.out.println(b);
//        Integer collect = transactions.stream()
//                .filter((e) -> "Cambridge".equals(e.getTrader().getCity()))
//                .map(Transaction::getValue)
//                .collect(Collectors.summingInt(Integer::intValue));
//
//        System.out.println(collect);

//        Optional<Integer> first = transactions.stream()
//                .map(Transaction::getValue)
//                .sorted((e1,e2) -> -Integer.compare(e1,e2))
//                .findFirst();
//        System.out.println(first.get());
//        Optional<Integer> max = transactions.stream()
//                .map(Transaction::getValue)
//                .max(Integer::compareTo);
//        System.out.println(max.get());
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compareTo);
        System.out.println(max.get());
    }
}
