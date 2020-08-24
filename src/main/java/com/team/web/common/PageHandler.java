package com.team.web.common;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class PageHandler {
    public void skipExample() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)
                .skip(2)
                .forEach(i -> System.out.print(i + " "));
    }

    public void limitExample() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)
                .limit(2)
                .forEach(i -> System.out.print(i + " "));
    }

    public void limitInfiniteStreamExample() {
        Stream.iterate(0, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .limit(10)
                .forEach(System.out::println);
    }

    private List<Integer> getEvenNumbers(int offset, int limit) {
        return Stream.iterate(0, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }
    private List<Integer> jpa(int offset, int limit) {
        /*final int total = entityManager.createNamedQuery("Person.countAll", Number.class).getSingleResult().intValue();
        final double ratio = total * 1. / pageSize;
        return IntStream.range(0, (int) (ratio == (int) ratio ? ratio : 1 + Math.floor(ratio)))
                .mapToObj(pageIdx ->
                        entityManager.createNamedQuery("Person.findAll", Person.class)
                                .setFirstResult(pageIdx * pageSize)
                                .setMaxResults(pageSize))
                .flatMap(q -> q.getResultList().stream());*/
        return null;
    }
}
