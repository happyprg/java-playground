/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.method.reference;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ReduceTest {

    @Test
    public void testReduce1() {

        List<Integer> integers = Arrays.asList(1, 2, 3);
        Integer reduce = integers.stream()
                                 .map(d -> 1)
                                 .reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);
    }

    @Test
    public void testCount() {

        List<Integer> integers = Arrays.asList(1, 2, 3);
        long count = integers.stream().count();
        System.out.println("count - " + count);
    }

}
