package info.rnowak.springFun.repository;

import info.rnowak.springFun.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface MessageRepository extends Repository<Message, Long> {
    Message findById(Long id);
    Page<Message> findAll(Pageable pageable);
}
