package com.finance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pots")
public class Pots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "pot_name")
    String potname;

    @Column(name = "money_saved")
    long moneysaved;

    @Column(name = "target")
    long target;

    @Column(name = "color")
    String color = "green";
}
