package me.design.pattern;

public class StrategyPattern {

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
