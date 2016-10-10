/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.method.reference;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FlatMapTest {

    @Test
    public void testFlatMap() {

        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(3, 4);
        integers.stream()
                .flatMap(i -> integers2.stream()
                                       .filter(j -> (i + j) % 3 == 0)
                                       .map(j -> new int[] { i, j }))
                .map((int[] array) -> Arrays.toString(array))
                .collect(toList()).forEach(System.out::println);
    }
}
