package org.abondar.experimental.homelessHack.model;

/**
 * Created by alexabon on 9/24/2016.
 */
public class Good {

    private int id;
    private String name;
    private GoodTypes type;

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

    public GoodTypes getType() {
        return type;
    }

    public void setType(GoodTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
