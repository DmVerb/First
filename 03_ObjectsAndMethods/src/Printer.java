public class Printer {
    public String queue = "";
    public String name = "";
    public int text = 0;
    public int pages = 0;
    public static int unprintedPages = 0;
    public static int totalPrintedPages = 0;

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.append(1);
        printer.append(2, "abc", 2);
    }

    private void append(int text) {
        this.name = "noName";
        this.queue = this.queue + " " + this. name ;
        this.text += text;
        this.pages = this.pages + 1;
        unprintedPages = this.pages;
    }

    public void append(int text, String name) {
        this.name = this.name + name;
        this.queue = this.queue + " " + name;
        this.text = this.text + text;
        this.pages = this.pages + 1;
        unprintedPages = this.pages;
    }

    public void append(int text, String name, int pages) {
        this.queue = this.queue + " " + name;
        this.text = this.text + text;
        this.pages = this.pages + pages;
        unprintedPages = this.pages;
    }

    public void clear() {
        queue = "";
        pages = 0;
        name = "";
        text = 0;
        unprintedPages = 0;
    }

    public void print() {
        System.out.println("Список документов: " + queue);
        System.out.println("Количество текстов: " + text);
        System.out.println("Количество странц: " + pages);
        totalPrintedPages += this.pages + pages;
        pages = 0;
        queue = "";
        unprintedPages= 0;
        text = 0;
    }

    public int getPendingPagesCounnt() {
        return unprintedPages;
    }

    public int getTotalPrintedPages() {
        return totalPrintedPages;
    }

}
