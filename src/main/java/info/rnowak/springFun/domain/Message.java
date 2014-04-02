package info.rnowak.springFun.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String header;

    @Column(nullable = false)
    private String body;

    protected Message() {

    }

    public Message(String header, String body) {
        this.header = header;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public String getHeader() {
        return this.header;
    }

    public String getBody() {
        return this.body;
    }
}
