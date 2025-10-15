package adapters.repository;

import domain.ports.ForGettingTaxRates;

public class FixedTaxRate implements ForGettingTaxRates {
    @Override
    public double taxRate() {
        return 0.15;
    }
}
