package com.module6.jpaapplication.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "accountType",
            cascade = CascadeType.ALL,
            orphanRemoval = true)

    private List<ClientBank> clientList = new ArrayList<>();

    public AccountType() {
    }

    public AccountType(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Bank getBank() {
        return bank;
    }

    public List<ClientBank> getClientList() {
        return clientList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setClientList(List<ClientBank> clientList) {
        this.clientList = clientList;
    }

    public ClientBank addClient(String name) {
        if (clientList == null) {
            clientList = new ArrayList<>();
        }
        ClientBank client = new ClientBank(name);
        clientList.add(client);
        client.setAccountType(this);
        return client;
    }

    @Override
    public String toString() {
        return name;
    }
}
