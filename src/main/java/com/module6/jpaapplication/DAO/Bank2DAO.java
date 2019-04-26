package com.module6.jpaapplication.DAO;

import com.module6.jpaapplication.entity.Bank;
import com.module6.jpaapplication.entity.ClientBank;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class Bank2DAO {

    @PersistenceContext
    EntityManager entityManager;

    public void saveBank(Bank bank) {
        entityManager.persist(bank);
    }

    public Bank getBank(int id) {
        Bank bank = entityManager.find(Bank.class, id);
        return bank;
    }

    public void printClientBank(int id) {
        ClientBank clientBank = entityManager.find(ClientBank.class, id);
        if (clientBank != null) {
            System.out.println(clientBank);
        } else {
            System.out.println("Client is not found");
        }
    }

    public ClientBank updateClientBank(ClientBank clientBank) {
        entityManager.merge(clientBank);
        return clientBank;
    }

    public ClientBank getClientBankById(int id) {
        ClientBank clientBank = entityManager.find(ClientBank.class, id);
        return clientBank;
    }

    public ClientBank getClientBank(ClientBank clientBank) {
        ClientBank clientBankEntity = entityManager.find(ClientBank.class, clientBank);
        return clientBankEntity;
    }

    public void deleteClientBank(int id) {
        ClientBank clientBank = entityManager.find(ClientBank.class, id);
        entityManager.remove(clientBank);
    }

    public List<ClientBank> getAllClientBank() {
        return entityManager.createNativeQuery("select * from client_bank").getResultList();
    }

    public List<Integer> getIdClient() {
        return entityManager.createNativeQuery("select id from client_bank").getResultList();
    }
}
