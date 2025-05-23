package com.CoCoDa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CoCoDa.entity.ReplyEntity;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

        Page<ReplyEntity> findByTitleContaining(String keyword, Pageable pageable);

        List<ReplyEntity> findByBoardnumOrderByReplynumAsc(int boardnum);

}
