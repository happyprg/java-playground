/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.method.reference;

import org.junit.Test;

import java.util.stream.Stream;

public class PitagorasNumber {

	@Test
	public void test1() {

		Stream.iterate(new int[]{0, 1}
				, t -> new int[]{t[1], t[0] + t[1]})
				.limit(20)
				.map(t -> t[0])
				.forEach(System.out::println);
//				.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
	}

}
