package com.CoCoDa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 방식
    @Column(name = "boardNum")
    private Integer boardNum;

    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "inputDate")
    private LocalDateTime inputDate;

    @Column(name = "hits")
    private int hits;

    // 기본 생성자
    protected BoardEntity() {
    }

    // 모든 필드를 받는 생성자
    public BoardEntity(String id, String title, String content, LocalDateTime inputDate, int hits) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.inputDate = inputDate;
        this.hits = hits;
    }

    // Getter 및 Setter
    public Integer getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(Integer boardNum) {
        this.boardNum = boardNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDateTime inputDate) {
        this.inputDate = inputDate;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardNum=" + boardNum +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", inputDate=" + inputDate +
                ", hits=" + hits +
                '}';
    }
    
}