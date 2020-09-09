package com.example.demo.model.entity.leagues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "spain")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "place_1",  nullable = false)
    private String place_1;
    @Column(name = "place_2",  nullable = false)
    private String place_2;
        @Column(name = "place_3",  nullable = false)
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
        @Column(name = "place_19",  nullable = false)
        private String place_19;
        @Column(name = "place_20",  nullable = false)
        private String place_20;

    @Column(name = "user_Id",unique = true)
    private int userId;

    public String[] betToArray (){
        String [] array = new String[21];

        array[1] = this.getPlace_1();
        array[2] = this.getPlace_2();
        array[3] = this.getPlace_3();
        array[4] = this.getPlace_4();
        array[5] = this.getPlace_5();
        array[6] = this.getPlace_6();
        array[7] = this.getPlace_7();
        array[8] = this.getPlace_8();
        array[9] = this.getPlace_9();
        array[10] = this.getPlace_10();
        array[11] = this.getPlace_11();
        array[12] = this.getPlace_12();
        array[13] = this.getPlace_13();
        array[14] = this.getPlace_14();
        array[15] = this.getPlace_15();
        array[16] = this.getPlace_16();
        array[17] = this.getPlace_17();
        array[18] = this.getPlace_18();
        array[19] = this.getPlace_19();
        array[20] = this.getPlace_20();

        return array;
    }

    public int score (){
        String [] array = this.betToArray();
        String[] result  = {"null","Real Madrid", "Barcelona", "Atletico", "Valencia", "Villareal", "Sevilla", "Osasuna", "Mallorca", "Real Sociedad", "Getafe",
                "Levante", "Leganes", "Betis", "Eibar", "Alaves", "Celta Vigo", "Espanyol", "Granda", "Valladolid", "Athletic Bilbao"};

        int i,j,points=0;

        for (i=1; i<=20;i++){
            for (j=1; j<=20;j++){
                if (array[i].equals(result[j])){
                    points +=  Math.abs(i-j);
                }
            }
        }

        System.out.println("Tvoj vylsedok je: "+points);
        return points;
    }

}
