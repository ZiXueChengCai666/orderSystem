package Dao;

import Bean.MenuBean;
import Bean.OrderBean;
import until.Conn;

import java.sql.*;
import java.util.ArrayList;

public class MenuDao {

    Connection conn = new Conn().getConn();

    public ArrayList<MenuBean> findMenuListByType(int type) {
        ArrayList<MenuBean> mlist = new ArrayList<>();
        MenuBean menuBean = null;
        try {
            String select = "select * from ordersystem where type =" + type;
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                menuBean = new MenuBean();
                menuBean.setId(resultSet.getInt("Id"));
                menuBean.setName(resultSet.getString("Name"));
                menuBean.setExplain(resultSet.getString("remark"));
                menuBean.setCost(resultSet.getInt("price"));
                menuBean.setImage("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551956729470&di=4cbafb17b83990dc7caede9abbeb5a66&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fa5c27d1ed21b0ef4b9e8896ad3c451da81cb3e85.jpg");
                mlist.add(menuBean);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mlist;
    }

    public MenuBean findMenuListById(int id) {

        MenuBean menuBean = null;
        try {
            String select = "select * from ordersystem join TitleList on type = titlelist.Id WHERE orderSystem.id =" + id + " ";
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                menuBean = new MenuBean();
                menuBean.setId(resultSet.getInt("Id"));
                menuBean.setName(resultSet.getString("Name"));
                menuBean.setExplain(resultSet.getString("remark"));
                menuBean.setCost(resultSet.getInt("price"));
                menuBean.setType(resultSet.getString("TitleList.Name"));
                menuBean.setType_num(resultSet.getInt("TitleList.Id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuBean;
    }

    public ArrayList<MenuBean> searchByName(String name){
        ArrayList<MenuBean> list = new ArrayList<>();
        try {
            String select = "select * from orderSystem where Name LIKE '%" + name + "%'";
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            MenuBean menuBean;
            while (resultSet.next()) {
                menuBean = new MenuBean();
                menuBean.setId(resultSet.getInt("Id"));
                menuBean.setName(resultSet.getString("Name"));
                menuBean.setCost(resultSet.getInt("price"));
               // menuBean.setType(resultSet.getString("TitleList.Name"));
                menuBean.setExplain(resultSet.getString("remark"));


                list.add(menuBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<MenuBean> findMenuList(String name) {
        ArrayList<MenuBean> mlist = new ArrayList<>();
        MenuBean menuBean = null;
        try {
            String select = "select * from ordersystem join TitleList on type = titlelist.Id WHERE orderSystem.Name LIKE '%" + name + "%' " ;
            PreparedStatement preparedStatement = conn.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                menuBean = new MenuBean();
                menuBean.setId(resultSet.getInt("Id"));
                menuBean.setName(resultSet.getString("Name"));
                menuBean.setExplain(resultSet.getString("remark"));
                menuBean.setCost(resultSet.getInt("price"));
                menuBean.setType(resultSet.getString("TitleList.Name"));
                mlist.add(menuBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mlist;
    }

    public void deleteMenu(int id) {

        try {
            String SQLstr = "delete from orderSystem where Id =" + id;
            Statement statement = conn.createStatement();
            statement.execute(SQLstr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;


    }


    public void insertMenu(MenuBean menuBean) {

        Statement statement = null;
        try {
            String sql = "insert into `orderSystem` (Name,remark,price,type) value ('"
                    + menuBean.getName() + "','"
                    + menuBean.getExplain() + "','"
                    + menuBean.getCost() + "','"
                    + menuBean.getType_num() + "')";
            statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMenu(MenuBean menuBean){

        try{
            String str ="update orderSystem set `Name`='"+menuBean.getName()+"',`remark`='"+menuBean.getExplain()+ "',`price`="+menuBean.getCost()+",`type`="+menuBean.getType_num() +" where `Id`="+menuBean.getId()+" ";

            Statement statement = conn.createStatement();
            statement.execute(str);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }


}
