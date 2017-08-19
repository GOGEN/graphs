import java.util.*;
import java.util.function.Consumer;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    List<Tuple<Integer, Integer>> edgeList = new LinkedList<Tuple<Integer, Integer>>();
    edgeList.add(new Tuple(1, 0));
    edgeList.add(new Tuple(1, 4));
    edgeList.add(new Tuple(0, 1));
    edgeList.add(new Tuple(2, 3));
    edgeList.add(new Tuple(0, 4));
    edgeList.add(new Tuple(4, 1));
    List<Tuple<Integer, List<Integer>>> resultList = new LinkedList<Tuple<Integer, List<Integer>>>();

    for (Tuple<Integer, Integer> edge : edgeList) {
      Optional<Tuple<Integer, List<Integer>>> o = resultList.stream()
                                                        .filter(res -> res.x.equals(edge.x))
                                                        .findFirst();
      OptionalConsumer.of(o).ifPresent(res -> res.y.add(edge.y))
                            .ifNotPresent(() -> {
                              List l = new LinkedList<Integer>();
                              Tuple t = new Tuple<Integer, List<Integer>>(edge.x, l);
                              resultList.add(t);
                              resultList.get(resultList.size() - 1).y.add(edge.y);
                            });
    }

    for (Tuple<Integer, List<Integer>>item : resultList) {
      System.out.print(item.x + ": " + item.y.toString());
    }
  }

}

class Tuple<X, Y> {
  public final X x;
  public final Y y;
  public Tuple(X x, Y y) {
    this.x = x;
    this.y = y;
  }
}

class OptionalConsumer<T> {
  private Optional<T> optional;

  private OptionalConsumer(Optional<T> optional) {
    this.optional = optional;
  }

  public static <T> OptionalConsumer<T> of(Optional<T> optional) {
    return new OptionalConsumer<>(optional);
  }

  public OptionalConsumer<T> ifPresent(Consumer<T> c) {
    optional.ifPresent(c);
    return this;
  }

  public OptionalConsumer<T> ifNotPresent(Runnable r) {
    if (!optional.isPresent())
      r.run();
    return this;
  }
}