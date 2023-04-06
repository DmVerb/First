import java.io.File;

public class Main {

    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\user\\Desktop\\src";
        String dstFolder = "C:\\Users\\user\\Desktop\\dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int fourth = files.length / 4;

        File[] files1 = new File[fourth];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        new Thread(resizer1).start();

        File[] files2 = new File[files.length - fourth];
        System.arraycopy(files, fourth, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        new Thread(resizer2).start();

        File[] files3 = new File[files.length - files2.length];
        System.arraycopy(files, files2.length, files3, 0, files3.length);
        ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder, start);
        new Thread(resizer3).start();

        File[] files4 = new File[files.length - files3.length];
        System.arraycopy(files, files3.length, files4, 0, files4.length);
        ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder, start);
        new Thread(resizer4).start();

    }
}
