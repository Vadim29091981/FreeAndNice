package com.example.freeandnice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ElementCollection
    @CollectionTable(name = "item_photo_urls", joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "photo_url")
    private List<String> photoPicturesUrls;

    @Column(name = "category")
    private String category;
//todo enum types ebay

    @Column(name = "subcategory")
    private String subcategory;
//todo enum types ebay

    @Column(name = "address")
    private String address;

    @Column(name = "favorites_count")
    private int favoritesCount;

    @Column(name = "views_count")
    private int viewsCount;

    @ElementCollection
    @CollectionTable(name = "item_tags", joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "tag")
    private List<String> tags;

    public Item() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhotoPicturesUrls() {
        return photoPicturesUrls;
    }

    public void setPhotoPicturesUrls(List<String> photoPicturesUrls) {
        this.photoPicturesUrls = photoPicturesUrls;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(int favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
