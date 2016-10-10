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

public class ExamTransactionTest {

    @Test
    public void testReduce1() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

    }

    @Test
    public void testCount() {

        List<Integer> integers = Arrays.asList(1, 2, 3);
        long count = integers.stream().count();
        System.out.println("count - " + count);
    }

    private class Trader {

        private final String name;
        private final String city;

        public Trader(String name, String city) {

            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

    }

    private class Transaction {
        private final Trader brian;
        private final int year;
        private final int value;

        public Transaction(Trader brian, int year, int value) {

            this.brian = brian;
            this.year = year;
            this.value = value;
        }

        public Trader getBrian() {
            return brian;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                   "brian=" + brian +
                   ", year=" + year +
                   ", value=" + value +
                   '}';
        }
    }
}
