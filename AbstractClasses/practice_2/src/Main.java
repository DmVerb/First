public class Main {
    public static void main(String[] args) {

        Company company1 = new Company("sfs");
        for (int i = 0; i < 180; i++) {
            company1.hire(new Operator());
        }
        for (int i = 0; i < 10; i++) {
            company1.hire(new TopManager());
        }
        for (int i = 0; i < 80; i++) {
            company1.hire(new Manager());
        }
        System.out.println(company1.employees.size());
//        System.out.println(company1.getTopSalaryStaff(10));
//        System.out.println(company1.getLowestSalaryStaff(30));
//
//
//        System.out.println(company1);
//        System.out.println(company1.getTopSalaryStaff(10));
//        System.out.println(company1.getLowestSalaryStaff(30));
//        System.out.println(company1.employees.size());

    }
}
