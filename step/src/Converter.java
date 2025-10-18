public class Converter {

    public double convertToKm(int steps) {
        double distanceMeters = steps * 0.75;
        // переводим в километры
        return distanceMeters / 1000;
    }

    double convertStepsToKilocalories(int steps) {
        double calories = steps * 50;
        // переводим в килокалории
        return calories / 1000;
    }
}
