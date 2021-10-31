public class Arithmetic {
    public int a = 0;
    public int b = 0;

    public static void main(String[] args) {
        Arithmetic primer1 = new Arithmetic(166, 320);
    }

    public Arithmetic(int a, int b) {
        sum(a, b);
        composition(a, b);
        max(a, b);
        min(a, b);
    }

    public void sum(int s, int b) {
        System.out.println("Сумма " + (a + b));
    }

    public void composition(int a, int b) {
        System.out.println("Произведение " + (a * b));
    }

    public void max(int a, int b) {
        System.out.println("Максимальное значение " + Math.max(a, b));
    }

    public void min(int a, int b) {
        System.out.println("Минимальное значение " + Math.min(a, b));
    }


}