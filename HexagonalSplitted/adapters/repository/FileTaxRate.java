package adapters.repository;

import domain.ports.ForGettingTaxRates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileTaxRate implements ForGettingTaxRates {
    private final String filePath;

    public FileTaxRate(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public double taxRate() throws TaxRateReadException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line != null) {
                return Double.parseDouble(line.trim());
            } else {
                throw new TaxRateReadException("Tax rate file is empty.", null);
            }
        } catch (IOException e) {
            throw new TaxRateReadException("Failed to read tax rate from file: " + filePath, e);
        } catch (NumberFormatException e) {
            throw new TaxRateReadException("Invalid tax rate format in file: " + filePath, e);
        }
    }
}