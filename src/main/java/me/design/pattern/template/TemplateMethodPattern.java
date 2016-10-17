/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.template;

import java.util.function.Consumer;

import org.junit.Test;

public class TemplateMethodPattern {

    @Test
    public void test1() {

        new OnlineBanking() {

            @Override
            void makeCustomerHappy(Customer c) {
                System.out.println("c = " + c);
            }
        }.processCustomer(10);

        new OnlineBankingLambda().processCustomer(10, (Customer c) -> {
            String s = c.getId() + "lambda";
            System.out.println("s = " + s);
        });
    }

    public class OnlineBankingLambda {

        public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
            Customer c = Database.getCustomerWithId(id);
            makeCustomerHappy.accept(c);
        }
    }

    public abstract class OnlineBanking {

        public void processCustomer(int id) {
            Customer c = Database.getCustomerWithId(id);
            makeCustomerHappy(c);
        }

        abstract void makeCustomerHappy(Customer c);
    }
}
