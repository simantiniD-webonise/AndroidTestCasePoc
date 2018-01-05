package com.webonise.simtestcasesample;

/**model class to inflate list
 * Created by webonise on 3/1/18.
 */

public class ListDataModel {

    private String name;
    private String address;

    public ListDataModel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
