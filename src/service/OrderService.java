package service;

import Bean.OrderBean;
import Dao.OrderDao;

import java.util.ArrayList;

public class OrderService {

    OrderDao orderDao = new OrderDao();

    public int payBill(int OrderNum){
        ArrayList<OrderBean> list = orderDao.SearchOrderList(OrderNum);
        int sum = 0;
        for(int i=0;i<list.size();++i){
            OrderBean order = list.get(i);
            sum = sum + (order.getPrice()*order.getCount());
        }
        return sum;
    }

    public void deleteOrder(int OrderNum){
            orderDao.deleteOrder(OrderNum);
    }

    public void deleteById(int id){
        orderDao.deleteById(id);
    }


}
