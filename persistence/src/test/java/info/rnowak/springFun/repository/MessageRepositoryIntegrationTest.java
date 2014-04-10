package info.rnowak.springFun.repository;

import info.rnowak.springFun.SpringFun;
import info.rnowak.springFun.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringFun.class)
public class MessageRepositoryIntegrationTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void shouldFindAllMessages() {
        //when:
        Page<Message> messages = messageRepository.findAll(new PageRequest(0, 3));
        //then:
        assertThat(messages.getTotalElements()).isEqualTo(10L);
    }

    @Test
    public void shouldFindMessageWithId() {
        //when:
        Message message = messageRepository.findOne(0L);
        //then:
        assertThat(message).isNotNull();
        assertThat(message.getHeader()).isNotNull().isEqualTo("Header1");
    }

    @Test
    public void shouldReturnNullWhenMessageWithIdDoesNotExist() {
        //when:
        Message message = messageRepository.findOne(999L);
        //then:
        assertThat(message).isNull();
    }
}
