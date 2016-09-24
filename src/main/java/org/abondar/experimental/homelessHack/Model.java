package org.abondar.experimental.homelessHack;


import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alex
 */
@XmlRootElement
public class Model {

    private String name;
    private String codeName;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", codeName='" + codeName + '\'' +
                '}';
    }
}

