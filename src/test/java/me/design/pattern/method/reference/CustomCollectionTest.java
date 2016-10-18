/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.method.reference;

import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class CustomCollectionTest {

	@Test
	public void test1() {


	}

	public static boolean isPrime(List<Integer> primes, int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return takeWhile(primes, i -> {
			return i <= candidateRoot;
		}).stream().noneMatch(p -> {
			return candidate % p == 0;
		});
	}

	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {

		int i = 0;
		for (A item : list) {
			if (!p.test(item)) {
				return list.subList(0, i);
			}
			i++;
		}

		return list;
	}

	public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>,
			Map<Boolean, List<Integer>>> {

		@Override
		public Supplier<Map<Boolean, List<Integer>>> supplier() {
			return () -> new HashMap<Boolean, List<Integer>>() {{

				put(true, new ArrayList<Integer>());
				put(false, new ArrayList<Integer>());
			}};
		}

		@Override
		public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
			return null;
		}

		@Override
		public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
			return null;
		}

		@Override
		public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
			return null;
		}

		@Override
		public Set<Characteristics> characteristics() {
			return null;
		}
	}


}
