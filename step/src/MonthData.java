
public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        System.out.println("количество пройденных шагов по дням");

        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " День: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;

        for (int i = 1; i < days.length; i++) {
            sumSteps += days[i];
        }

        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) maxSteps = days[i];
        }

        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else currentSeries = 0;
        }

        return finalSeries;
        }
    }

