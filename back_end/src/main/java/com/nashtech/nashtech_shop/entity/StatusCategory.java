package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class StatusCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String status ;

    @OneToMany(mappedBy = "statusCategory" , cascade = CascadeType.ALL)
    private List<Category>  categories ;


    @OneToMany(mappedBy = "statusSubCategory" , cascade = CascadeType.ALL)
    private List<SubCategory> subCategories ;


}
