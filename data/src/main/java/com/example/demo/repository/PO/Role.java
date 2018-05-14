package com.example.demo.repository.PO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/11 19:19
 **/
@Entity
@Data
public class Role implements Serializable{

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_id")
    private Integer userId;
}
