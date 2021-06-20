package sample._07_common_troubles._02;

import java.util.Objects;

public class CircleId {
    private final String value;

    public CircleId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircleId circleId = (CircleId) o;
        return Objects.equals(value, circleId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
