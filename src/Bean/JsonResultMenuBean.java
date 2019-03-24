package Bean;

import java.util.ArrayList;
import java.util.List;

public class JsonResultMenuBean {
    private int result;
    private ArrayList<MenuBean> MenuData;

    public JsonResultMenuBean(){}

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<MenuBean> getMenuData() {
        return MenuData;
    }

    public void setMenuData(ArrayList<MenuBean> menuData) {
        MenuData = menuData;
    }

    @Override
    public String toString() {
        return result+"  ";
    }
}
