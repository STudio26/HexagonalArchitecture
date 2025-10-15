package domain.ports;

import adapters.repository.TaxRateReadException;

public interface ForGettingTaxRates {
    double taxRate() throws TaxRateReadException;
}
