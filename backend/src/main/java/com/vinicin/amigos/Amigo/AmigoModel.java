package com.vinicin.amigos.Amigo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_amigo")
@NoArgsConstructor
@AllArgsConstructor
public class AmigoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="rating")
    private int rating;

    @Column(name="nickname")
    private String nickname;

}
