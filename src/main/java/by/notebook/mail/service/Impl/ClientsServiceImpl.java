package by.notebook.mail.service.Impl;

import by.notebook.mail.entity.ClientsEntity;
import by.notebook.mail.repository.ClientsRepository;
import by.notebook.mail.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    @Override
    @Transactional
    public List<ClientsEntity> getAll() {
        return clientsRepository.findAll();
    }

    @Override
    public void add(ClientsEntity clientsEntity) {
        clientsRepository.saveAndFlush(clientsEntity);
    }


}
