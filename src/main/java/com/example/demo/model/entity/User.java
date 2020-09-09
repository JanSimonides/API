package com.example.demo.model.entity;

import com.example.demo.model.entity.leagues.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "team")
    private String team;
    @Column(name = "points")
    private Integer points;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Italy italy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Germany germany;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private France france;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Spain spain;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private England england;




    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
