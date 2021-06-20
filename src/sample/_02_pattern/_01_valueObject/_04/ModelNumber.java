package sample._02_pattern._01_valueObject._04;

import java.util.Objects;

public class ModelNumber {
    private final String productCode;
    private final String branch;
    private final String lot;

    public ModelNumber(String productCode, String branch, String lot) {
        this.productCode = productCode;
        this.branch = branch;
        this.lot = lot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelNumber that = (ModelNumber) o;
        return Objects.equals(productCode, that.productCode) && Objects.equals(branch, that.branch) && Objects.equals(lot, that.lot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, branch, lot);
    }

    @Override
    public String toString() {
        return productCode + "-" + branch + "-" + lot;
    }
}
