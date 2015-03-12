package com.berezin.dao;

import com.berezin.model.Client;
import com.berezin.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.berezin on 11.03.2015.
 */
public class ClientDAO_Hibernate {
    private Session con;

    public ClientDAO_Hibernate() {
        con = HibernateUtil.getSessionFactory().openSession();

    }

    public void addClient(Client client) {
        try {
            con.beginTransaction();
            con.save(client);
            con.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (con != null && con.isOpen()) {
                con.close();
                System.out.println("Закрыто подключение к базе");
            }
        }
    }

    public void deleteClient(int clientId){
        try{
            con.beginTransaction();
            Client client = (Client)con.load(Client.class, clientId);
            con.delete(client);
            con.getTransaction().commit();
        } catch (HibernateException e){
            e.printStackTrace();
        }finally {
            if (con != null && con.isOpen()) {
                con.close();
                System.out.println("Закрыто подключение к базе");
            }
        }
    }

    public void updateClient(Client client){
        try{
            con.beginTransaction();
            con.update(client);
            con.getTransaction().commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            if (con != null && con.isOpen()) {
                con.close();
                System.out.println("Закрыто подключение к базе");
            }
        }

    }

    public List<Client> getAllClient(){
        List clients = new ArrayList<Client>();
        try{
            con.beginTransaction();
            clients = con.createCriteria(Client.class).list();
        }catch(HibernateException e){
            System.out.println("Ошибка получения данных из базы");
            e.printStackTrace();
        }
        finally {
            if (con != null && con.isOpen()) {
                con.close();
                System.out.println("Закрыто подключение к базе");
            }
            return clients;
        }
    }

    public Client getClientById (int clientId){
        Client client = null;
        try{
            con.beginTransaction();
            client = (Client)con.load(Client.class,clientId);
            //костыль для отладки
            System.out.println("Я попытался вытащить клиента номер "+clientId);
            System.out.println("Вот что получил: "+client.getClientId()+" "+client.getFirstName()+" "+client.getSecondName()+" "+client.getLastName());
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            if (con != null && con.isOpen()) {
                con.close();
                System.out.println("Закрыто подключение к базе");
            }
        }
        return client;
    }

    public void close(){
        con.close();
        System.out.println("Закрыто подключение к базе");
    }
}
