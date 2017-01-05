package by.notebook.mail.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.notebook.mail.entity.ClientsEntity;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, Integer> {
}
