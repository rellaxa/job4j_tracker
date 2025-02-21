public class Main {
    private static final double PERCENT = 0.12;
    private static final int MONTHS_IN_YEAR = 12;

    public static double calculateTotalSum(int years, int monthlyBenefit) {
        double annualBenefit = MONTHS_IN_YEAR * monthlyBenefit;
        double totalSum = 0;

        for (int i = 1; i <= years; i++) {
            totalSum += annualBenefit * Math.pow(1 + PERCENT, i);
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int years = 2;
        int monthlyBenefit = 200000;
        double result = calculateTotalSum(years, monthlyBenefit);
        System.out.printf("%.2f%n", result);
    }
}
