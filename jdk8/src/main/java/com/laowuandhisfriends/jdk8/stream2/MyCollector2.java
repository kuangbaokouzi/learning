package com.laowuandhisfriends.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
//        return Set::add;
        return (set, item) -> {
//            System.out.println("accumulator: " + set + Thread.currentThread().getName());
            System.out.println("accumulator: " + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        return (x, y) -> {
            x.addAll(y);
            return x;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        return x -> x.stream().collect(Collectors.toMap(y -> y, z -> z));
    }

    @Override
    public Set<Characteristics> characteristics() {
//        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT));
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }
}
