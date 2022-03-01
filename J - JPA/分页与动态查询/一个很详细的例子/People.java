package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people") //对应mysql的表名
public class People {
    @Id // 主键
    @GenericGenerator(name = "idGenerator", strategy = "uuid") // id采用uuid生成
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="my_email")
    private String myEmail;

    @Column(name="address")
    private String address;
}
