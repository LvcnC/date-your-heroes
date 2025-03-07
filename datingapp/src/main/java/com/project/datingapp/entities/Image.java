package com.project.datingapp.entities;

public class Image extends Entity{

    private String ownerType;
    private int ownerId;
    private String imageUrl;
    private String description;
    private String createdAt;

    public Image(){

    }

    public Image(int id, String ownerType, int ownerId, String imageUrl, String description,
                String createdAt){

    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    public String toString(){
        return super.toString() +  " - "  + ownerType + " - " + ownerId + " - " + imageUrl + " - "    
                                + description + " - " + createdAt;
    }


}
