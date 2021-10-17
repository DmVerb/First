public class Arithmetic {
    public int a = 0;
    public int b = 0;

    public static void main(String[] args) {
        Arithmetic primer1 = new Arithmetic(5, 12);
    }

    public Arithmetic(int a, int b) {
        System.out.println("Сумма " + (a + b));
        System.out.println("Произведение " + (a * b));
        System.out.println("Максимальное значение " + Math.max(a,b));
        System.out.println("Минимальное значение " + Math.min(a,b));
    }


}