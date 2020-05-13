package glim.antony.timecontroller.utils.random;

import glim.antony.timecontroller.model.entities.Task;

import java.util.SplittableRandom;

public class RandomGenerator {
    public static final SplittableRandom RANDOM = new SplittableRandom();
    public static final char[] UPPERCASE_ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) {
        generateDataForTasksTable(30);
    }

    /**
     * (title, description, type, user_id, total_time, until_time)
     * @param rowsCount
     */
    private static void generateDataForTasksTable(int rowsCount){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rowsCount; i++) {
            builder
                    .append("(")
                    .append("'").append("0").append("', ")
                    .append("'").append("0").append("', ")
                    .append("'").append(Task.Type.values()[RANDOM.nextInt(0, Task.Type.values().length)]).append("', ")
                    .append(1).append(", ")
                    .append(RANDOM.nextInt(3000, 450000)).append(", ")
                    .append("'").append(generateRandomDate(false)).append("'),")
            ;
            System.out.println(builder.toString());
            builder.setLength(0);
        }
    }

    public static char getRandomChar() {
        return UPPERCASE_ALPHABET[RANDOM.nextInt(0, 26)];
    }

    private static String generateRandomDate(boolean withTime) {
        StringBuilder builder = new StringBuilder();
        int month = RANDOM.nextInt(1, 13);
        int days = RANDOM.nextInt(1, 30);
        builder
                .append(20).append(RANDOM.nextInt(10, 30)).append("-")
                .append(addZeros(month, 2)).append("-")
                .append(addZeros(days, 2))
        ;
        if (withTime){
            int hours = RANDOM.nextInt(0, 25);
            int minutes = RANDOM.nextInt(0, 61);
            int seconds = RANDOM.nextInt(0, 61);
            builder
                    .append("T")
                    .append(addZeros(hours, 2))
                    .append(addZeros(minutes, 2))
                    .append(addZeros(seconds, 2))
            ;
        }
        return builder.toString();
    }

    private static String addZeros(int number, int stringNeededLength) {
        StringBuilder builder = new StringBuilder().append(number).reverse();
        while (stringNeededLength - builder.length() != 0) {
            builder.append("0");
        }
        return builder.reverse().toString();
    }

}
