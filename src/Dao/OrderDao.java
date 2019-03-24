package Dao;

import Bean.OrderBean;
import until.Conn;

import java.sql.*;
import java.util.ArrayList;

public class OrderDao {

    Connection conn = new Conn().getConn();

    public void insertOrder(OrderBean orderBean, int number) {

        Statement statement = null;
        try {
            String sql = "insert into `orderlist` (name,price,number,count) value ('"
                    + orderBean.getName() + "','"
                    + orderBean.getPrice() + "','"
                    + number + "','"
                    + orderBean.getCount() + "')";
            statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOrderNum() {
        Statement statement = null;
        try {
            String sql = "INSERT INTO `orderNum` VALUES ()";
            statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> searchOrderNum() {

        ArrayList<Integer> mlist = new ArrayList<>();
        try {
            String select = "select * from orderNum";
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                mlist.add(resultSet.getInt("Id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mlist;
    }

    public int searchADDNum() {
        int num = -1;
        try {
            String select = "select @@identity";
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                num = resultSet.getInt("@@identity");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public ArrayList<OrderBean> SearchOrderList(int number) {
        ArrayList<OrderBean> mlist = new ArrayList<>();
        OrderBean orderBean = null;
        try {
            String select = "select * from orderlist where number =" + number;
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                orderBean = new OrderBean();
                orderBean.setId(resultSet.getInt("Id"));
                orderBean.setName(resultSet.getString("Name"));
                orderBean.setPrice(resultSet.getInt("price"));
                orderBean.setCount(resultSet.getInt("count"));
                mlist.add(orderBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mlist;
    }

    public void deleteOrder(int number) {

        try {
            String SQLstr = "delete from ordernum where id  =" + number;
            String SQLstr1 = "delete from orderlist where number  =" + number;
            Statement statement = conn.createStatement();
            statement.execute(SQLstr1);
            statement.execute(SQLstr);
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;


    }

    public void deleteById(int id) {
        try {

            String SQLstr = "delete from orderlist where Id  =" + id;
            Statement statement = conn.createStatement();
            statement.execute(SQLstr);
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

    public void updateCount(int id, int count) {

        try {
            String SQLstr = null;
            SQLstr = "update orderlist set count ="+ count + "  where Id = " + id;
            Statement statement = conn.createStatement();
            statement.execute(SQLstr);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
