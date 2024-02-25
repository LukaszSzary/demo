package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity

@Data
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private Double milomiter;
    private String VIN;
    @Transient
    @ManyToOne
    @JoinColumn(name ="user_id")
    private Person person;

}
