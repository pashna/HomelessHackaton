package org.abondar.experimental.homelessHack.model;

/**
 * Created by alexabon on 9/24/2016.
 */
public enum  GoodTypes {
    Vegetables, Clothes, Job, Shelter;

    public static  GoodTypes getType(String type){
        switch (type){
            case "vegetables":
               return Vegetables;
            case "clothes":
                return Clothes;

            case "job":
                return Job;

            case "shelter":
                return Shelter;

        }
        return Vegetables;
    }
}
