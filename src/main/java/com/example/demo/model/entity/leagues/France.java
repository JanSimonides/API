package com.example.demo.model.entity.leagues;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "france")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class France {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "place_1",  nullable = false)
    private String place_1;
    @Column(name = "place_2",  nullable = false)
    private String place_2;
        /*@Column(name = "place_3",  nullable = false)
        private String place_3;
        @Column(name = "place_4",  nullable = false)
        private String place_4;
        @Column(name = "place_5",  nullable = false)
        private String place_5;
        @Column(name = "place_6",  nullable = false)
        private String place_6;
        @Column(name = "place_7",  nullable = false)
        private String place_7;
        @Column(name = "place_8",  nullable = false)
        private String place_8;
        @Column(name = "place_9",  nullable = false)
        private String place_9;
        @Column(name = "place_10",  nullable = false)
        private String place_10;
        @Column(name = "place_11",  nullable = false)
        private String place_11;
        @Column(name = "place_12",  nullable = false)
        private String place_12;
        @Column(name = "place_13",  nullable = false)
        private String place_13;
        @Column(name = "place_14",  nullable = false)
        private String place_14;
        @Column(name = "place_15",  nullable = false)
        private String place_15;
        @Column(name = "place_16",  nullable = false)
        private String place_16;
        @Column(name = "place_17",  nullable = false)
        private String place_17;
        @Column(name = "place_18",  nullable = false)
        private String place_18;
        @Column(name = "place_19", unique = true)
        private String place_19;
        @Column(name = "place_20", unique = true)
        private String place_20;*/

    @Column(name = "user_Id",unique = true)
    private int userId;
}
