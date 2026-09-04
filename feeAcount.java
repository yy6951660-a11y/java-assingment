class FeeAccount {
    String regNo;
    double totalFee;

    FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    // final method: cannot be overridden
    final double calculateLateFee(int daysLate) {
        return totalFee * 0.01 * daysLate;
    }

    // final method: cannot be overridden
    final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            double lateFee = calculateLateFee(daysLate);
            System.out.println(regNo + " | Total Fee: Rs " + totalFee
                    + " | Late Fee: Rs " + lateFee);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        // Single pass through the whole batch
        for (int i = 0; i < regNos.length; i++) {
            FeeAccount account = new FeeAccount(regNos[i], totalFees[i]);
            account.printSummary(daysLate[i]);
        }
    }
}
