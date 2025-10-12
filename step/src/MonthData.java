
public class MonthData {
    int[] days = new int[30];
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
        i = days[i];
        }
    }
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 1; i < days.length; i++) {
        sumSteps = days[i];
        }    return sumSteps;
    }
    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
        maxSteps = days[i];
        }   return maxSteps;
    }
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            finalSeries = days[i];
        }   return finalSeries;
    }
}
