package info.rnowak.springFun.web;

import info.rnowak.springFun.domain.Message;
import info.rnowak.springFun.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private static final int DEFAULT_PAGE_SIZE = 10;

    private MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> list() {
        return messageRepository.findAll(new PageRequest(0, DEFAULT_PAGE_SIZE)).getContent();
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Message find(@PathVariable Long id) {
        return messageRepository.findById(id);
    }
}
