package application;

import adapters.repository.FileTaxRate;
import adapters.repository.FixedTaxRate;
import adapters.repository.TaxRateReadException;
import domain.ports.ForGettingTaxRates;
import application.service.TaxCalculator;

class Main {
    public static void main(String[] args) {
        computeWithFixedTaxRate();
        computeWithTaxRateInFile();
    }

    private static void computeWithFixedTaxRate() {
        ForGettingTaxRates taxRateRepository = new FixedTaxRate();
        TaxCalculator myCalculator = new TaxCalculator(taxRateRepository);
        System.out.println(myCalculator.taxOn(100));
    }

    private static void computeWithTaxRateInFile() {
        String filePath = "taxrate.txt";
        try {
            ForGettingTaxRates taxRateRepository = new FileTaxRate(filePath);
            TaxCalculator myCalculator = new TaxCalculator(taxRateRepository);
            System.out.println(myCalculator.taxOn(100));
        } catch (TaxRateReadException e) {
            System.err.println(("Error retrieving tax rate: " + e.getMessage()));
            e.printStackTrace();
        }
    }
}