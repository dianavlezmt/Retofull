package co.usa.ciclo32022.Reto3.Repository;

import co.usa.ciclo32022.Reto3.Repository.crudrepository.MessageCrudRepository;
import co.usa.ciclo32022.Reto3.modelo.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    public List<MessageModel> getAll(){
        return (List<MessageModel>) messageCrudRepository.findAll();
    }
    public Optional<MessageModel> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public MessageModel save(MessageModel message){
        return messageCrudRepository.save(message);
    }
    public void delete(MessageModel message){
        messageCrudRepository.delete(message);
    }



      }



