package co.usa.ciclo32022.Reto3.Repository;


import co.usa.ciclo32022.Reto3.Repository.crudrepository.ClientCrudRepository;
import co.usa.ciclo32022.Reto3.modelo.ClientModel;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;
    public List<ClientModel> getAll(){
        return (List<ClientModel>) clientCrudRepository.findAll();
    }
    public Optional<ClientModel> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public ClientModel save(ClientModel client){
        return clientCrudRepository.save(client);
    }
    public void delete(ClientModel client){
        clientCrudRepository.delete(client);
    }
}






