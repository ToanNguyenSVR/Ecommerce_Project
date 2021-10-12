package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;

    @ManyToOne
    @JoinColumn(name = "statusCategory_id")
    private StatusCategory statusSubCategory ;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;

    @OneToMany(mappedBy = "subCategory" , cascade = CascadeType.ALL)
    private List<Product> products ;


}
