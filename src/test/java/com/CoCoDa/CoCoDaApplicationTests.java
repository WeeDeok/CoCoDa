package com.CoCoDa;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CoCoDa.entity.BoardEntity;
import com.CoCoDa.repository.BoardRepository;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CoCoDaApplicationTests {

	@Autowired
    private BoardRepository boardRepository;

    @Test
    void boardSaveAndFindTest() {
		
        // given
        BoardEntity board = BoardEntity.builder()
                .id("user1")
                .title("테스트 제목")
                .content("테스트 내용입니다.")
                .inputDate(LocalDateTime.now())
                .hits(0)
                .build();

        // when
        BoardEntity saved = boardRepository.save(board);
        BoardEntity found = boardRepository.findById(saved.getBoardNum()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getTitle()).isEqualTo("테스트 제목");
        assertThat(found.getContent()).isEqualTo("테스트 내용입니다.");

    }

}
