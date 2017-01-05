package by.notebook.mail.service;


import by.notebook.mail.entity.ClientsEntity;

import java.util.List;


public interface ClientsService {

    List<ClientsEntity> getAll();
    void add(ClientsEntity clientsEntity);
}
