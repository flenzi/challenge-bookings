package f.l.challenge.dto;

public enum BookingTypeEnum {
    BOOKING(1),
    BLOCK(2);

    private final int value;

    BookingTypeEnum(final int value) {
        this.value = value;
    }

    public static BookingTypeEnum fromValue(int value) {
        for (BookingTypeEnum enumValue : BookingTypeEnum.values()) {
            if (enumValue.getValue() == value) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }

    public int getValue() {
        return value;
    }
}
