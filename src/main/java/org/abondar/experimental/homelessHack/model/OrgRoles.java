package org.abondar.experimental.homelessHack.model;

/**
 * Created by alexabon on 9/24/2016.
 */
public enum OrgRoles {
    Grocery, Charity;

    public static OrgRoles getType(String type){
        switch (type){
            case "grocery":
                return Grocery;
            case "Charity":
                return Charity;

        }
        return Grocery;
    }
}
