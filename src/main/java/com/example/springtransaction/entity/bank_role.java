package com.example.springtransaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "BANK_ROLE",
        uniqueConstraints = {
                @UniqueConstraint(name = "BANK_ROLE_UK", columnNames = "tenvaitro")
        })
public class bank_role {

    @Id
    @GeneratedValue
    @Column(name = "mavaitro", nullable = false)
    private Long mavaitro;

    @Column(name = "tenvaitro", nullable = false)
    private String tenvaitro;

    public Long getMavaitro() {
        return mavaitro;
    }

    public void setMavaitro(Long mavaitro) {
        this.mavaitro = mavaitro;
    }

    public String getTenvaitro() {
        return tenvaitro;
    }

    public void setTenvaitro(String tenvaitro) {
        this.tenvaitro = tenvaitro;
    }
}

