package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(
        name = "c_laptop"
)
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "model",
            columnDefinition = "text",
            nullable = false
    )
    private String model;

    @Column(
            name = "producer",
            columnDefinition = "text",
            nullable = false
    )
    private String producer;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonProperty(
            access = JsonProperty.Access.WRITE_ONLY
    )
    private User user;

    public Laptop() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
