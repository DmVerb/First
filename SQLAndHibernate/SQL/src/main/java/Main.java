import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "rootroot";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pl.course_name," +
                    " round(count(*)/(max(month(subscription_date))-min(month(subscription_date))+1), 2) avr" +
                    " FROM PurchaseList pl " +
                    " where subscription_date BETWEEN '2018-01-01 00:00:00' AND '2018-12-31 23:59:59'" +
                    " group by pl.course_name");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                Double avr = resultSet.getDouble("avr");
                System.out.println("Среднее количество купленных за месяц курсов " + courseName + " " + avr);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}