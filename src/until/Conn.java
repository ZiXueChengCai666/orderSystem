package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    private Connection conn;

    public Conn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功！");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?user=root&password=123654789wufan&useUnicode=true&characterEncoding=UTF-8");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
