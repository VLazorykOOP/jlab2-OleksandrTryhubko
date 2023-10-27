public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (isValidTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            throw new IllegalArgumentException("Неможливо створити трикутник із заданими сторонами.");
        }
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public boolean equals(Triangle other) {
        return (this.sideA == other.sideA && this.sideB == other.sideB && this.sideC == other.sideC) ||
                (this.sideA == other.sideB && this.sideB == other.sideC && this.sideC == other.sideA) ||
                (this.sideA == other.sideC && this.sideB == other.sideA && this.sideC == other.sideB);
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(5, 12, 13);
        Triangle triangle3 = new Triangle(7, 24, 25);

        System.out.println("Периметр трикутника 1: " + triangle1.calculatePerimeter());
        System.out.println("Площа трикутника 1: " + triangle1.calculateArea());

        System.out.println("Трикутник 1 і трикутник 2 однакові: " + triangle1.equals(triangle2));
        System.out.println("Трикутник 1 і трикутник 3 однакові: " + triangle1.equals(triangle3));
    }
}





