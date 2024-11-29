package application.service;

import domain.ports.ForCalculatingTaxes;
import domain.ports.ForGettingTaxRates;

public class TaxCalculator implements ForCalculatingTaxes {
    private final ForGettingTaxRates taxRateRepository;

    public TaxCalculator(ForGettingTaxRates taxRateRepository) {
        this.taxRateRepository = taxRateRepository;
    }

    public double taxOn(double amount) {
        return amount * taxRateRepository.taxRate(amount);
    }
}
