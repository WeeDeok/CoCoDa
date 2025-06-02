package com.CoCoDa.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "USER") // 실제 테이블 명이 다르면 변경
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserEntity {

    @Id
    @Column(name = "USERID")
    private String userid;

    @Column(name = "USERPW")
    private String userpw;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "USEREMAIL")
    private String useremail;

}
