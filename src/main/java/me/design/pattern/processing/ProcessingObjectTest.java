/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.processing;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.junit.Test;

public class ProcessingObjectTest {

    @Test
    public void test1() {

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String expected = p1.handle("statText");
        System.out.println(expected);

        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("stat", "start");

        Function<String, String> pipeLine = headerProcessing.andThen(spellCheckerProcessing);
        String actual = pipeLine.apply("statText");
        assertEquals(expected, actual);
    }

    public abstract class ProcessingObject<T> {
        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        protected ProcessingObject<T> successor;

        public T handle(T text) {
            T r = handleWork(text);
            if (successor != null) {
                return successor.handle(r);
            }
            return r;
        }

        protected abstract T handleWork(T input);
    }

    public class HeaderTextProcessing extends ProcessingObject<String> {
        public String handleWork(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }
    }

    public class SpellCheckerProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String text) {

            return text.replaceAll("stat", "start");
        }
    }
}
