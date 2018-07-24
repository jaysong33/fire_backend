package com.fire.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by syj on 2018/7/24.
 *
 * 用户实体
 */
@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * 名字
     */
    private String name;
}
