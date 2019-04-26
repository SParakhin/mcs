package com.module6.jpaapplication.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "bank",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private List<AccountType> account_typeList = new ArrayList<>();

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount_typeList(List<AccountType> account_typeList) {
        this.account_typeList = account_typeList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AccountType> getAccount_typeList() {
        return account_typeList;
    }

    public AccountType addAccountType(String name) {
        AccountType accountType = new AccountType(name);
        account_typeList.add(accountType);
        accountType.setBank(this);
        return accountType;
    }
}
