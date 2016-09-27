/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern;

import static me.design.pattern.LabelReportType.TypeA;
import static me.design.pattern.LabelReportType.TypeB;

public class StrategyPatternWithAnonymousClass {

    //    https://en.wikipedia.org/wiki/Strategy_pattern
    public static void main(String[] args) {

        process(TypeA, new LabelReportTypePredicate() {
            @Override
            public boolean test(LabelReportType labelReportType) {
                return labelReportType.getType().equals(TypeA.getType());
            }

            @Override
            public Integer toString(LabelReportType labelReportType) {
                return Integer.compare(1, labelReportType.getCode());
            }
        });
        process(TypeB, new LabelReportTypeStrategyTypeA());
    }

    public static void process(LabelReportType labelreportType, LabelReportTypePredicate
            labelReportTypePredicate) {

        if (labelReportTypePredicate.test(labelreportType)) {
            System.out.println(
                    "It's typeA. resultCode - " + labelReportTypePredicate.toString(labelreportType));
        } else {
            System.out.println(
                    "It's not typeA. resultCode - " + labelReportTypePredicate.toString(labelreportType));
        }
    }

}
