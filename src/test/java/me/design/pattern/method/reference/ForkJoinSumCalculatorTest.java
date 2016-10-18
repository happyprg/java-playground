/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.method.reference;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculatorTest {


	@Test
	public void test1() {
		long l = forkJoinSum((long) 10_001);
		System.out.println("l = " + l);
	}

	public static long forkJoinSum(Long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}

	public static class ForkJoinSumCalculator extends RecursiveTask<Long> {
		private static final int THRESHOLD = 10_000;
		private final long[] numbers;
		private final int start;
		private final int end;

		public ForkJoinSumCalculator(long[] numbers) {

			this(numbers, 0, numbers.length);
		}

		private ForkJoinSumCalculator(long[] numbers, int start, int end) {

			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}


		@Override
		protected Long compute() {
			int length = end - start;
			if (length <= THRESHOLD) {
				return computeSequentially();
			}
			ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
			leftTask.fork();

			ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
			Long rightResult = rightTask.compute();
			Long leftResult = leftTask.join();
			return leftResult + rightResult;
		}

		private long computeSequentially() {
			long sum = 0;
			for (int i = start; i < end; i++) {
				sum += numbers[i];
			}
			return sum;
		}

	}


}
