package com.CoCoDa;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CoCoDa.Enum.Day;
import com.CoCoDa.entity.BoardEntity;
import com.CoCoDa.entity.UserEntity;
import com.CoCoDa.mapper.UserMapper;
import com.CoCoDa.repository.BoardRepository;
import com.CoCoDa.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CoCoDaApplicationTests {

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserMapper userMapper;

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

    @Test
    void userSaveAndFindTest() {
		
        // given
        UserEntity user = UserEntity.builder()
                .userid("test1")
                .userpw("testpw")
                .username("testuser")
                .useremail("test@test.net")
                .build();

        // when
        UserEntity saved = userRepository.save(user);
        UserEntity found = userRepository.findById(saved.getUserid()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getUserid()).isEqualTo("test1");
        assertThat(found.getUserpw()).isEqualTo("testpw");

    }

    @Test
    void findUserUsingQuery() {

        // given
        UserEntity user = UserEntity.builder()
                .userid("test1")
                .userpw("testpw")
                .username("testuser")
                .useremail("test@test.net")
                .build();

        UserEntity saved = userRepository.save(user);

        //when
        UserEntity found = userRepository.findByUserIdAndUserPw(user.getUserid(), user.getUserpw());
        String userId = userMapper.searchUserid(user.getUserid());

        //then
        assertThat(found).isNotNull();
        assertThat(found.getUserid()).isEqualTo(saved.getUserid());
        
        System.out.println("HERE found " + found.toString());
        System.out.println("HERE saved " + saved.toString());
        System.out.println("HERE mapper " + userId);

        userRepository.delete(found);

        UserEntity foundafdel = userRepository.findById(user.getUserid()).orElseThrow(() -> new RuntimeException("User Not Found"));;

        System.out.println("Must Not To Reach Here " + foundafdel.getUserid());

    }

    @Test
    void callEnumTest() {

        System.out.println(Day.MONDAY);
        System.out.println(Day.MONDAY == Day.MONDAY);
        System.out.println(Day.MONDAY == Day.FRIDAY);
        System.out.println(Day.MONDAY.getDay());
        System.out.println(Day.MONDAY.getweekendYn().equals(Day.FRIDAY.getweekendYn()));
        System.out.println(Day.MONDAY.getweekendYn().equals(Day.SUNDAY.getweekendYn()));

    }

}
