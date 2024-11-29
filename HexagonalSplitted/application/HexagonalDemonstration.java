package application;

import adapters.repository.FileTaxRate;
import adapters.repository.FixedTaxRate;
import adapters.repository.TaxRateReadException;
import domain.ports.ForGettingTaxRates;
import application.service.TaxCalculator;

class Main {
    public static void main(String[] args) {
        ForGettingTaxRates taxRateRepository = new FixedTaxRate();
        TaxCalculator myCalculator = new TaxCalculator(taxRateRepository);
        System.out.println(myCalculator.taxOn(100));

        String filePath = "taxrate.txt";
        try {
            ForGettingTaxRates otherTaxRateRepository = new FileTaxRate(filePath);
            TaxCalculator myOtherCalculator = new TaxCalculator(otherTaxRateRepository);
            System.out.println(myOtherCalculator.taxOn(100));
        } catch (TaxRateReadException e) {
            System.err.println(("Error retrieving tax rate: " + e.getMessage()));
            e.printStackTrace();
        }
    }
}