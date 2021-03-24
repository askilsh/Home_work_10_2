
import java.util.stream.Collectors;


public class Main {
    private static final int AGE = 17;
    private static final int LIM = 4;

    public static void main(final String[] argc) {

        BoysList.BOYS.stream().
                filter(boy -> boy.getAge() > AGE).
                map(Boy::getName).
                distinct().
                sorted().
                limit(LIM).
                collect(Collectors.toMap((x -> x),
                        (x -> BoysList.BOYS.stream().
                                filter(boy -> boy.getName().
                                        equals(x)).
                                count() - 1))).
                forEach((boy, rep) -> {
                    System.out.println(boy + " = " + rep);
                });
    }

}
