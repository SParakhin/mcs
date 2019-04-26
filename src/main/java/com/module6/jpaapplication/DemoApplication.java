/**
 * Сергей Парахин
 * Практика: Модуль 6
 * ormts@mail.ru
 */

package com.module6.jpaapplication;

import com.module6.jpaapplication.DAO.Bank2DAO;
import com.module6.jpaapplication.entity.AccountType;
import com.module6.jpaapplication.entity.Bank;
import com.module6.jpaapplication.entity.ClientBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    Bank2DAO bank2DAO;

    @Override
    public void run(String... args) throws Exception {

        /**
         *Entity creation
         */
        Bank bank = new Bank("Village");

        AccountType debit = bank.addAccountType("debit");
        AccountType credit = bank.addAccountType("credit");

        debit.setBank(bank);
        credit.setBank(bank);

        ClientBank clientBank = debit.addClient("Ivan");
        ClientBank clientBank1 = credit.addClient("Sergey");
        ClientBank clientBank2 = debit.addClient("Petya");
        ClientBank clientBank3 = credit.addClient("Dima");

        clientBank.setAccountType(debit);
        clientBank1.setAccountType(credit);
        clientBank2.setAccountType(debit);
        clientBank3.setAccountType(credit);
        bank2DAO.saveBank(bank);

        /**
         * Get the entity id for update or delete demonstration
         */
        List<Integer> listId = new ArrayList<>();
        listId.addAll(bank2DAO.getIdClient());
        int idForDelete = listId.get(0);
        int idForUpdate = listId.get(listId.size() - 1);

        /**
         *Show entity updates
         */
        ClientBank updateClient = bank2DAO.getClientBankById(idForUpdate);
        System.out.println("-----------Entity before change in db-----------" + "\n");
        System.out.println(updateClient + "\n");
        updateClient.setName("Name after update");
        bank2DAO.updateClientBank(updateClient);
        ClientBank clientBankAfterUpdate = bank2DAO.getClientBankById(idForUpdate);
        System.out.println("-----------Entity after change in db-----------" + "\n");
        System.out.println(clientBankAfterUpdate + "\n");

        /**
         * Show delete entity
         */
        ClientBank deleteClient = bank2DAO.getClientBankById(idForDelete);
        System.out.println("-----------Entity before delete from db-----------" + "\n");
        System.out.println(deleteClient + "\n");
        bank2DAO.deleteClientBank(idForDelete);
        ClientBank afterDeleteClient = bank2DAO.getClientBankById(idForDelete);
        System.out.println("-----------Entity after delete from db-----------" + "\n");
        System.out.println(afterDeleteClient + "\n");
    }
}
