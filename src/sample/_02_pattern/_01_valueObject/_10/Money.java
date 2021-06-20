package sample._02_pattern._01_valueObject._10;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal value;
    private final String currency;

    public Money(BigDecimal value, String currency) {
        Objects.requireNonNull(currency);

        this.value = value;
        this.currency = currency;
    }

    public Money(int value, String currency) {
        this(new BigDecimal(value), currency);
    }

    public Money add(Money arg) {
        Objects.requireNonNull(arg);

        if (!currency.equals(arg.currency)) {
            throw new IllegalArgumentException("通貨単位が異なります。");
        }

        return new Money(value.add(arg.value), arg.currency);
    }
}
