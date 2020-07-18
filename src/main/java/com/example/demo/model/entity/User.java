package com.example.demo.model.entity;

import com.example.demo.model.entity.leagues.Germany;
import com.example.demo.model.entity.leagues.Italy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int points;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Italy italy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Germany germany;

    /*@ManyToOne
    @JoinColumn(name="france")//, nullable = false)
    private France france;

    @ManyToOne
    @JoinColumn(name="spain")//, nullable = false)
    private Spain spain;

    @ManyToOne
    @JoinColumn(name="england")//, nullable = false)
    private England england;*/




    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
}
