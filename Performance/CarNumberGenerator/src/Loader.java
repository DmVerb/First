import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Loader implements Runnable {
    private final int threadPool;
    private final int regionFirst;
    private final int regionEnd;

    public Loader(int threadPool, int regionFirst, int regionEnd) {
        this.threadPool = threadPool;
        this.regionFirst = regionFirst;
        this.regionEnd = regionEnd;
    }

    @Override
    public void run() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("D:\\Skillbox\\java_basics\\Performance\\CarNumberGenerator\\res\\numbers" + threadPool + ".txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        StringBuilder builder = new StringBuilder();
        for (int regionCode = regionFirst; regionCode < regionEnd; regionCode++) {
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append("\n");
                        }
                    }
                }
            }
            writer.write(builder.toString());
        }

        writer.flush();
        writer.close();
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }

        return numberStr.toString();
    }
}
