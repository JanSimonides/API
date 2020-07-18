package com.example.demo.model.entity.leagues;

import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "germany")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Germany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "place_1", unique = true, nullable = false)
    private String place_1;
    @Column(name = "place_2", unique = true, nullable = false)
    private String place_2;
        /*@Column(name = "place_3", unique = true, nullable = false)
        private String place_3;
        @Column(name = "place_4", unique = true, nullable = false)
        private String place_4;
        @Column(name = "place_5", unique = true, nullable = false)
        private String place_5;
        @Column(name = "place_6", unique = true, nullable = false)
        private String place_6;
        @Column(name = "place_7", unique = true, nullable = false)
        private String place_7;
        @Column(name = "place_8", unique = true, nullable = false)
        private String place_8;
        @Column(name = "place_9", unique = true, nullable = false)
        private String place_9;
        @Column(name = "place_10", unique = true, nullable = false)
        private String place_10;
        @Column(name = "place_11", unique = true, nullable = false)
        private String place_11;
        @Column(name = "place_12", unique = true, nullable = false)
        private String place_12;
        @Column(name = "place_13", unique = true, nullable = false)
        private String place_13;
        @Column(name = "place_14", unique = true, nullable = false)
        private String place_14;
        @Column(name = "place_15", unique = true, nullable = false)
        private String place_15;
        @Column(name = "place_16", unique = true, nullable = false)
        private String place_16;
        @Column(name = "place_17", unique = true, nullable = false)
        private String place_17;
        @Column(name = "place_18", unique = true, nullable = false)
        private String place_18;*/

    @Column(name = "user_Id",unique = true)
    private int userId;

}
