package org.example.model;

public class Supply {
    private int id;
    private SupplyType type;
    private int astronautId;
    private int value;

    public Supply(int id, SupplyType type, int astronautId, int value) {
        this.id = id;
        this.type = type;
        this.astronautId = astronautId;
        this.value = value;
    }

    public Supply(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SupplyType getType() {
        return type;
    }

    public void setType(SupplyType type) {
        this.type = type;
    }

    public int getAstronautId() {
        return astronautId;
    }

    public void setAstronautId(int astronautId) {
        this.astronautId = astronautId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
