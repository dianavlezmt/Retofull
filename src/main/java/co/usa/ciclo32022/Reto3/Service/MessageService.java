package co.usa.ciclo32022.Reto3.Service;

import co.usa.ciclo32022.Reto3.Repository.MessageRepository;
import co.usa.ciclo32022.Reto3.modelo.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAll(){
        return messageRepository.getAll();
    }

    public Optional<MessageModel> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public MessageModel save(MessageModel message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<MessageModel> e= messageRepository.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public MessageModel update(MessageModel message){
        if(message.getIdMessage()!=null){
            Optional<MessageModel> e= messageRepository.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
