package com.example.springtransaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "BANK_USER",
        uniqueConstraints = {
                @UniqueConstraint(name = "BANK_USER_UK", columnNames = "user_name")
        })

public class bank_user {
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "user_password", nullable = false)
    private String user_password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
