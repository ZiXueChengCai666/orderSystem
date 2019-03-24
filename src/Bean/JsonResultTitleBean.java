package Bean;

import java.util.ArrayList;

public class JsonResultTitleBean {

    private int result;
    private ArrayList<TitleBean> mlist;


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public ArrayList<TitleBean> getMlist() {
        return mlist;
    }

    public void setMlist(ArrayList<TitleBean> mlist) {
        this.mlist = mlist;
    }
}
