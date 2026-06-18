public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        HelloWorld hw = new HelloWorld();
        double result = hw.priceCalculation(8.50, 2);
        System.out.println("Стоимость товара: " + result);
        calcCircleRadius(123);
    }

    public int drawsMonitorsCounter(int monitors, int programmers) {
        return monitors % programmers;
    }

    public double priceCalculation(double price, int count) {
        return price * count;
    }

    public static void calcCircleRadius(double area) {
        double radius = Math.sqrt(area / Math.PI);
        System.out.printf("%.3f", radius);
    }
}