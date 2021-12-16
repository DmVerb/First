public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.
        for (char i = 'А'; i<='я'; i++) {
            int codeI = i;
            System.out.println(i + "-" + codeI);
        }
        char a = 'Ё';
        int codeA = a;
        char b = 'ё';
        int codeB = b;
        System.out.println(a + "-" + codeA);
        System.out.println(b + "-" + codeB);


    }
}
