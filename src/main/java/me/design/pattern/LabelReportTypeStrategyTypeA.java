/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern;

import static me.design.pattern.LabelReportType.TypeA;

public class LabelReportTypeStrategyTypeA implements LabelReportTypePredicate {

    public boolean test(LabelReportType labelReportType) {
        return labelReportType.getType().equals(TypeA.getType());
    }

    public Integer toString(LabelReportType labelReportType) {
        return Integer.compare(1, labelReportType.getCode());
    }
}
