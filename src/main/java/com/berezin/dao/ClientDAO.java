package com.berezin.dao;

import com.berezin.util.DBUtil;
import com.berezin.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.berezin on 27.02.2015.
 */
public class ClientDAO {
    private Connection con;

    public ClientDAO() {
        con = DBUtil.getConnection();
    }

    public void addClient(Client client) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into Clients(FIRSTNAME,SECONDNAME,LASTNAME) values (?, ?, ?)");
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getSecondName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientId){
        try{
            PreparedStatement preparedStatement = con.prepareStatement("delete from CLIENTS where CLIENTID=?");
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateClient(Client client){
        try{
            PreparedStatement preparedStatement = con.prepareStatement("update CLIENTS set FIRSTNAME=?, SECONDNAME=?, LASTNAME=?" +
                    "where CLIENTID=?");
            preparedStatement.setString(1,client.getFirstName());
            preparedStatement.setString(2,client.getSecondName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.setInt(4,client.getClientId());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Client> getAllClient(){
        List<Client> clients = new ArrayList<Client>();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT * from CLIENTS");
            while (rs.next()){
                Client client = new Client();
                client.setClientId(rs.getInt("clientId"));
                client.setFirstName(rs.getString("firstName"));
                client.setSecondName(rs.getString("secondName"));
                client.setLastName(rs.getString("lastName"));
                clients.add(client);
            }
        }catch(SQLException e){
            System.out.println("Ошибка получения данных из базы");
            e.printStackTrace();
        }
        return clients;
    }

    public Client getClientById (int clientId){
        Client client = new Client();
        try{
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * from CLIENTS WHERE CLIENTID=?");
            preparedStatement.setInt(1,clientId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                client.setClientId(rs.getInt("clientId"));
                client.setFirstName(rs.getString("firstName"));
                client.setSecondName(rs.getString("secondName"));
                client.setLastName(rs.getString("lastName"));
            }
        }catch(SQLException e){
            System.out.println("Неудалось получить объект из БД");
            e.printStackTrace();
        }
        return client;
    }
   }
