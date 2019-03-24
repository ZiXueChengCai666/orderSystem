package until;

import Bean.OrderBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;

public class JsonExplain {

    public static ArrayList<OrderBean> parseJson(String json){
        ArrayList<OrderBean> list = new ArrayList<>();

        try {
            JSONObject object = JSONObject.fromObject(json);
            int result =object.getInt("result");

            if(result == 1){
                JSONArray orderData = object.getJSONArray("orderData");
                for(int i=0; i<orderData.size();i++){
                    OrderBean order = new OrderBean();
                    JSONObject orderBean = orderData.getJSONObject(i);

                    int id = orderBean.getInt("id");
                    int count = orderBean.getInt("count");
                    String name = orderBean.getString("name");
                    String remark = orderBean.getString("remark");
                    int price = orderBean.getInt("price");

                    order.setId(id);
                    order.setName(name);
                    order.setCount(count);
                    order.setPrice(price);
                    order.setRemark(remark);
                    list.add(order);
                    System.out.println("传输成功");

                }
            }else{
                System.out.println("传输失败");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }
}
