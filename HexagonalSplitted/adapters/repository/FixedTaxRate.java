package adapters.repository;

import domain.ports.ForGettingTaxRates;

public class FixedTaxRate implements ForGettingTaxRates {
    @Override
    public double taxRate(double amount) {
        return 0.15;
    }
}
