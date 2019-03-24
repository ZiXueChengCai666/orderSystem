package Dao;

import Bean.MenuBean;
import Bean.TitleBean;
import until.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TitleDao {
    Connection conn = new Conn().getConn();

    public ArrayList<TitleBean> findTitleList() {
        ArrayList<TitleBean> mlist = new ArrayList<>();
        TitleBean titleBean = null;
        try {
            String select = "select * from TitleList";
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                titleBean = new TitleBean();
                titleBean.setId(resultSet.getInt("Id"));
                titleBean.setName(resultSet.getString("Name"));
                mlist.add(titleBean);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mlist;
    }
}
