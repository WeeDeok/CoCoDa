package com.CoCoDa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "REPLY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL AUTO_INCREMENT
    @Column(name = "REPLYNUM")
    private int replynum;

    @Column(name = "BOARDNUM")
    private int boardnum;

    @Column(name = "ID")
    private String id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "INPUTDATE")
    private String inputdate;

}
