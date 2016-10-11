/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.method.reference;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ExamTransactionTest {

    private Trader raoul;
    private Trader mario;
    private Trader alan;
    private Trader brian;
    private List<Transaction> transactions;

    @Before
    public void before() {
        raoul = new Trader("Raoul", "Cambridge");
        mario = new Trader("Mario", "Milan");
        alan = new Trader("Alan", "Cambridge");
        brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
    }

    @Test
    public void test1() {
        transactions.stream()
                    .filter((Transaction t) -> t.getYear() == 2011)
                    .sorted(comparing(Transaction::getValue))
                    .collect(toList())
                    .forEach(System.out::println);
    }

    @Test
    public void test2() {
        transactions.stream().map((Transaction t) -> t.getTrader().getCity())
                    .distinct()
                    .collect(toList())
                    .forEach(System.out::println);
    }

    @Test
    public void test3() {
        transactions.stream().map(t -> t.getTrader()).filter((t) -> t.getCity().equals("Cambridge"))
                    .sorted(comparing(Trader::getName)).collect(toList()).forEach(System.out::println);
    }

    @Test
    public void test4() {

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

        @Override
        public String toString() {
            return "Trader{" +
                   "name='" + name + '\'' +
                   ", city='" + city + '\'' +
                   '}';
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

        public Trader getTrader() {
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
