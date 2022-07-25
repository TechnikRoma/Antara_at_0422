package org.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Order {
    @SerializedName("id")
    private int id;

    @SerializedName("petId")
    private int petId;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("shipDate")
    private Date shipDate;

    @SerializedName("status")
    private Status status;

    @SerializedName("complete")
    private boolean complete;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return
                "Order{" +
                        "id='" + id + '\'' +
                        ",petId= '" + petId + '\'' +
                        ",quantity= '" + quantity + '\'' +
                        ",shipDate= '" + shipDate + '\'' +
                        ",status = '" + status + '\'' +
                        " ,complete = '" + complete + '\'' +
                        "}" ;
    }

}
