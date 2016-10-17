/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ObserverPatternTest {

    @Test
    public void test1() {

        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("firstTestMsg");
    }

    @Test
    public void test2() {

        Feed f = new Feed();
        f.registerObserver((String tweet) -> {
            System.out.println("NYTimes tweet = " + tweet);
        });

        f.registerObserver((String tweet) -> {
            System.out.println("LeMonde tweet = " + tweet);
        });
        f.registerObserver((String tweet) -> {
            System.out.println("Guardian tweet = " + tweet);
        });

//        f.registerObserver(new Guardian());
//        f.registerObserver(new LeMonde());
        f.notifyObservers("firstTestMsg");
    }

    interface Subject {
        void registerObserver(Observer p);

        void notifyObservers(String tweet);
    }

    class Feed implements Subject {

        private final List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer p) {
            observers.add(p);
        }

        @Override
        public void notifyObservers(String tweet) {
            observers.forEach(o -> o.notify(tweet));
        }
    }

    @FunctionalInterface
    public interface Observer {
        void notify(String tweet);
    }

    class NYTimes implements Observer {

        @Override
        public void notify(String tweet) {
            System.out.println("NYTimes tweet = " + tweet);
        }
    }

    class Guardian implements Observer {

        @Override
        public void notify(String tweet) {
            System.out.println("Guardian tweet = " + tweet);
        }
    }

    class LeMonde implements Observer {

        @Override
        public void notify(String tweet) {
            System.out.println("LeMonde tweet = " + tweet);
        }
    }
}
