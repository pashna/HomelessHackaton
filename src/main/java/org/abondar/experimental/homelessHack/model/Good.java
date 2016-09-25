package org.abondar.experimental.homelessHack.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alexabon on 9/24/2016.
 */
@XmlRootElement
public class Good {

    private int id;
    private String name;
    private GoodTypes type;
    private int weight;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
