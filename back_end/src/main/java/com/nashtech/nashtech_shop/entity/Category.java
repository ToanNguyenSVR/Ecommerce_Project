package com.nashtech.nashtech_shop.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter

@Getter

@AllArgsConstructor()

@NoArgsConstructor



@Entity
public class  Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;
    private String imageUrl ;

    @ManyToOne
    @JoinColumn(name = "statusCategory_id")
    private StatusCategory statusCategory ;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<SubCategory> subCategories ;



}
