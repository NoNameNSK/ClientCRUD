package com.berezin.controller;

import com.berezin.model.Client;
import com.berezin.dao.ClientDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by a.berezin on 27.02.2015.
 */
@WebServlet("/index")
public class ClientController extends HttpServlet{
    private static final long serialVersionUID = 1L;   //?? I don't think what is it, but manual say write it.
    private static String INSERT_OR_EDIT = "client.jsp";
    private static String LIST_CLIENT = "listClient.jsp";
    private ClientDAO dao;

    public ClientController(){
        super();
        dao = new ClientDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String forward = "";
        String action = request.getParameter("action");

        if(action.equalsIgnoreCase("delete")){
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            dao.deleteClient(clientId);
            forward = LIST_CLIENT;
            request.setAttribute("clients",dao.getAllClient());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            Client client = dao.getClientById(clientId);
            request.setAttribute("client", client);
        } else if (action.equalsIgnoreCase("listClient")){
            forward = LIST_CLIENT;
            request.setAttribute("clients",dao.getAllClient());
        } else {
            forward = INSERT_OR_EDIT;
        }

        forward = LIST_CLIENT;
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Client client = new Client();
        client.setFirstName(request.getParameter("firstName"));
        client.setSecondName(request.getParameter("secondName"));
        client.setLastName(request.getParameter("lastName"));

        String clientId =  request.getParameter("clientId");
        if (clientId == null || clientId.isEmpty()){
            dao.addClient(client);
        } else{
            client.setClientId(Integer.parseInt(clientId));
            dao.updateClient(client);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENT);
        request.setAttribute("clients", dao.getAllClient());
        view.forward(request, response);
    }
}
