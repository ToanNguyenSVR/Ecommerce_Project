package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class  Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;
    private String imageUrl ;

    @ManyToOne
    @JoinColumn(name = "statusCategory_id")
    private StatusCategory statusCategory ;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<SubCategory> subCategories ;


}
