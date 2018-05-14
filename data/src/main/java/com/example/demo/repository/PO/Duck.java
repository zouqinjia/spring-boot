package com.example.demo.repository.PO;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/11 17:29
 **/
@Data
@Entity
public class Duck implements Serializable{

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "color")
    private String color;
    @Column(name ="type")
    private String type;


}
