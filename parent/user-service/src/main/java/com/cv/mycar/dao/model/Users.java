package com.cv.mycar.dao.model;

import java.util.Date;

public class Users {
    private Long id;

    private String name;

    private String cardId;

    private String phone;

    private Date createAt;

    private Date lastUpdate;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", phone='" + phone + '\'' +
                ", createAt=" + createAt +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public Users(Long id, String name, String cardId, String phone, Date createAt, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.cardId = cardId;
        this.phone = phone;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
    }

    public Users() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}