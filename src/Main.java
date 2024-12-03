import java.util.Arrays;

abstract class Integer {
    protected int[] digits;

    public Integer(int[] digits) {
        this.digits = digits;
    }

    public abstract Integer add(Integer other);

    public abstract Integer subtract(Integer other);

    public abstract Integer multiply(Integer other);

    @Override
    public String toString() {
        return Arrays.toString(digits);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Integer integer = (Integer) obj;
        return Arrays.equals(digits, integer.digits);
    }
}

class Heximal extends Integer {

    public Heximal(int[] digits) {
        super(digits);
    }

    @Override
    public Integer add(Integer other) {
        int sum = toDecimal() + ((Heximal) other).toDecimal();
        return fromDecimal(sum);
    }

    @Override
    public Integer subtract(Integer other) {
        int diff = toDecimal() - ((Heximal) other).toDecimal();
        return fromDecimal(diff);
    }

    @Override
    public Integer multiply(Integer other) {
        int product = toDecimal() * ((Heximal) other).toDecimal();
        return fromDecimal(product);
    }

    private int toDecimal() {
        int decimal = 0;
        for (int digit : digits) {
            decimal = decimal * 16 + digit;
        }
        return decimal;
    }

    private static Heximal fromDecimal(int decimal) {
        String hexString = java.lang.Integer.toHexString(decimal).toUpperCase();
        int[] hexDigits = hexString.chars().map(c -> Character.digit(c, 16)).toArray();
        return new Heximal(hexDigits);
    }

    @Override
    public String toString() {
        StringBuilder hexString = new StringBuilder();
        for (int digit : digits) {
            hexString.append(java.lang.Integer.toHexString(digit).toUpperCase());
        }
        return hexString.toString();
    }
}

class Binary extends Integer {

    public Binary(int[] digits) {
        super(digits);
    }

    @Override
    public Integer add(Integer other) {
        int sum = toDecimal() + ((Binary) other).toDecimal();
        return fromDecimal(sum);
    }

    @Override
    public Integer subtract(Integer other) {
        int diff = toDecimal() - ((Binary) other).toDecimal();
        return fromDecimal(diff);
    }

    @Override
    public Integer multiply(Integer other) {
        int product = toDecimal() * ((Binary) other).toDecimal();
        return fromDecimal(product);
    }

    private int toDecimal() {
        int decimal = 0;
        for (int digit : digits) {
            decimal = decimal * 2 + digit;
        }
        return decimal;
    }

    private static Binary fromDecimal(int decimal) {
        String binaryString = java.lang.Integer.toBinaryString(decimal);
        int[] binaryDigits = binaryString.chars().map(c -> c - '0').toArray();
        return new Binary(binaryDigits);
    }

    @Override
    public String toString() {
        StringBuilder binaryString = new StringBuilder();
        for (int digit : digits) {
            binaryString.append(digit);
        }
        return binaryString.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[4];

        numbers[0] = new Heximal(new int[] { 1, 10, 15 });
        numbers[1] = new Binary(new int[] { 1, 0, 1, 1 });

        numbers[2] = new Heximal(new int[] { 2, 15 });
        numbers[3] = new Binary(new int[] { 1, 1, 0, 0 });

        for (Integer number : numbers) {
            System.out.println(number);
        }

        System.out.println("\nОперації між Heximal:");
        Heximal hex1 = (Heximal) numbers[0];
        Heximal hex2 = (Heximal) numbers[2];
        System.out.println("Сума: " + hex1.add(hex2));
        System.out.println("Різниця: " + hex1.subtract(hex2));
        System.out.println("Добуток: " + hex1.multiply(hex2));

        System.out.println("\nОперації між Binary:");
        Binary bin1 = (Binary) numbers[1];
        Binary bin2 = (Binary) numbers[3];
        System.out.println("Сума: " + bin1.add(bin2));
        System.out.println("Різниця: " + bin1.subtract(bin2));
        System.out.println("Добуток: " + bin1.multiply(bin2));
    }
}
