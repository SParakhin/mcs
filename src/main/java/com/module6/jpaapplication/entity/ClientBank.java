package com.module6.jpaapplication.entity;

import javax.persistence.*;

@Entity
public class ClientBank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private AccountType accountType;

    public ClientBank() {
    }

    public ClientBank(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return "ClientBank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountType=" + accountType +
                '}';
    }
}
