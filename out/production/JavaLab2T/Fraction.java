public class Fraction {
    private long wholePart;
    private short fractionalPart;

    public Fraction(long wholePart, short fractionalPart) {
        this.wholePart = wholePart;
        this.fractionalPart = fractionalPart;
    }


    public Fraction add(Fraction other) {
        long newWholePart = this.wholePart + other.wholePart;
        short newFractionalPart = (short) (this.fractionalPart + other.fractionalPart);
        if (newFractionalPart >= 100) {
            newWholePart += 1;
            newFractionalPart -= 100;
        }
        return new Fraction(newWholePart, newFractionalPart);
    }


    public Fraction subtract(Fraction other) {
        long newWholePart = this.wholePart - other.wholePart;
        short newFractionalPart = (short) (this.fractionalPart - other.fractionalPart);
        if (newFractionalPart < 0) {
            newWholePart -= 1;
            newFractionalPart += 100;
        }
        return new Fraction(newWholePart, newFractionalPart);
    }


    public Fraction multiply(Fraction other) {
        long newWholePart = (this.wholePart * other.wholePart);
        long newNumerator = (this.wholePart * other.fractionalPart + this.fractionalPart * other.wholePart) * 100 + (this.fractionalPart * other.fractionalPart);

        newWholePart += newNumerator / 10000;
        newNumerator = newNumerator % 10000;

        return new Fraction(newWholePart, (short)(newNumerator / 100));
    }

    
    public int compareTo(Fraction other) {
        long thisValue = this.wholePart * 100 + this.fractionalPart;
        long otherValue = other.wholePart * 100 + other.fractionalPart;
        return Long.compare(thisValue, otherValue);
    }


    public String toString() {
        return wholePart + "." + String.format("%02d", fractionalPart);
    }

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(3, (short) 50);
        Fraction fraction2 = new Fraction(3, (short) 50);

        Fraction sum = fraction1.add(fraction2);
        Fraction difference = fraction1.subtract(fraction2);
        Fraction multiply = fraction1.multiply(fraction2);

        System.out.println("Fraction 1: " + fraction1);
        System.out.println("Fraction 2: " + fraction2);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("multiply: " + multiply);

        int comparison = fraction1.compareTo(fraction2);
        if (comparison > 0) {
            System.out.println("Fraction 1 is greater than Fraction 2");
        } else if (comparison < 0) {
            System.out.println("Fraction 1 is less than Fraction 2");
        } else {
            System.out.println("Fraction 1 is equal to Fraction 2");
        }
    }
}
