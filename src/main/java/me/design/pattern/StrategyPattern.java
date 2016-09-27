/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern;

public class StrategyPattern {

    //    https://en.wikipedia.org/wiki/Strategy_pattern
    public static void main(String[] args) {

        LabelReportTypeStrategyTypeA strategyTypeA = new LabelReportTypeStrategyTypeA();
        LabelReportType typeA = LabelReportType.TypeA;
        if (strategyTypeA.test(typeA)) {
            System.out.println("It's typeA. resultCode - " + strategyTypeA.toString(typeA));
        } else {
            System.out.println("It's not typeA. resultCode - " + strategyTypeA.toString(typeA));
        }

        LabelReportType typeB = LabelReportType.TypeB;
        if (strategyTypeA.test(typeB)) {
            System.out.println("It's typeA. resultCode - " + strategyTypeA.toString(typeB));
        } else {
            System.out.println("It's not typeA. resultCode - " + strategyTypeA.toString(typeB));
        }

    }

    public enum LabelReportType {

        TypeA(1, "typeA"),
        TypeB(2, "typeB");

        private Integer code;
        private String type;

        LabelReportType(Integer code, String type) {
            this.code = code;
            this.type = type;
        }

        public Integer getCode() {
            return code;
        }

        public String getType() {
            return type;
        }
    }

    public static class LabelReportTypeStrategyTypeA implements LabelReportTypePredicate {

        public boolean test(LabelReportType labelReportType) {
            return labelReportType.getType().equals(LabelReportType.TypeA.getType());
        }

        public Integer toString(LabelReportType labelReportType) {
            return Integer.compare(1, labelReportType.getCode());
        }
    }

    public interface LabelReportTypePredicate

    {

        boolean test(LabelReportType reportType);

        Integer toString(LabelReportType labelReportType);
    }

}
