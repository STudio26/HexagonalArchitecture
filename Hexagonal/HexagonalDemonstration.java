interface ForCalculatingTaxes {
    double taxOn(double amount);
}

interface ForGettingTaxRates {
    double taxRate(double amount);
}

class TaxCalculator implements ForCalculatingTaxes {
    private final ForGettingTaxRates taxRateRepository;

    public TaxCalculator(ForGettingTaxRates taxRateRepository) {
        this.taxRateRepository = taxRateRepository;
    }

    public double taxOn(double amount) {
        return amount * taxRateRepository.taxRate(amount);
    }
}

class FixedTaxRateRepository implements ForGettingTaxRates {
    public double taxRate(double amount) {
        return 0.15;
    }
}

class Main {
    public static void main(String[] args) {
        ForGettingTaxRates taxRateRepository = new FixedTaxRateRepository();
        TaxCalculator myCalculator = new TaxCalculator(taxRateRepository);
        System.out.println(myCalculator.taxOn(100));
    }
}
