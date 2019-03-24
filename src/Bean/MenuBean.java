package Bean;

import java.io.Serializable;

public class MenuBean  {

    private int id;
    private String name;
    private String explain;
    private int cost;
    private String image;
    private String type;
    private int type_num;

    public int getType_num() {
        return type_num;
    }

    public void setType_num(int type_num) {
        this.type_num = type_num;
    }

    public MenuBean(){

    }

    public MenuBean(int id, String name, String explain, int cost) {
        this.id = id;
        this.name = name;
        this.explain = explain;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name+"  "+explain+"  "+cost;
    }
}
