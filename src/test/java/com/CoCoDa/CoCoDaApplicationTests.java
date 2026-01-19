package com.CoCoDa;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import com.CoCoDa.Enum.Day;
import com.CoCoDa.entity.BoardEntity;
import com.CoCoDa.entity.UserEntity;
import com.CoCoDa.mapper.UserMapper;
import com.CoCoDa.repository.BoardRepository;
import com.CoCoDa.repository.UserRepository;
import com.CoCoDa.service.BoardService;
import com.CoCoDa.service.UserService;
import com.CoCoDa.service.IndexService;
import com.CoCoDa.service.TotalService;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CoCoDaApplicationTests {

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private TotalService totalService;

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

    @Test
    void setHashMapEnumTest() {
        
        HashMap<String, Object> test = new HashMap<>();

        test.put("test", Day.MONDAY);

        test.put("test2", Day.MONDAY.getDay());
        test.put("test3", Day.MONDAY.toString());

        test.forEach((key, value) -> {

            System.out.println("key : " + key + " value : " + value);
            System.out.println(value.getClass().getSimpleName());

        });

    }

    @Test
    void comprehensiveFunctionalityTest() {
        System.out.println("=== CoCoDa 프로젝트 통합 기능 테스트 시작 ===");

        // 1. 사용자 기능 테스트
        testUserFunctionality();

        // 2. 게시판 기능 테스트
        testBoardFunctionality();

        // 3. 인덱스 서비스 기능 테스트
        testIndexServiceFunctionality();

        // 4. 전체 서비스 기능 테스트
        testTotalServiceFunctionality();

        System.out.println("=== CoCoDa 프로젝트 통합 기능 테스트 완료 ===");
    }

    private void testUserFunctionality() {
        System.out.println("\n[1] 사용자 기능 테스트");

        // 테스트 사용자 생성
        UserEntity testUser = UserEntity.builder()
                .userid("integrationTest")
                .userpw("testPassword123")
                .username("테스트사용자")
                .useremail("test@example.com")
                .build();

        // 사용자 저장
        System.out.println("  - 사용자 저장 테스트...");
        UserEntity savedUser = userService.userjoin(testUser);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUserid()).isEqualTo("integrationTest");
        System.out.println("    ✓ 사용자 저장 성공");

        // 사용자 조회
        System.out.println("  - 사용자 조회 테스트...");
        UserEntity foundUser = userRepository.findById("integrationTest").orElse(null);
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("테스트사용자");
        System.out.println("    ✓ 사용자 조회 성공");

        // 사용자 로그인
        System.out.println("  - 사용자 로그인 테스트...");
        UserEntity loginUser = userService.userlogin(testUser);
        assertThat(loginUser).isNotNull();
        assertThat(loginUser.getUserid()).isEqualTo("integrationTest");
        System.out.println("    ✓ 사용자 로그인 성공");

        // 정리: 테스트 사용자 삭제
        userRepository.deleteById("integrationTest");
        System.out.println("  - 테스트 사용자 삭제 완료");
    }

    private void testBoardFunctionality() {
        System.out.println("\n[2] 게시판 기능 테스트");

        // 테스트 게시글 생성
        BoardEntity testBoard = BoardEntity.builder()
                .id("integrationTest")
                .title("통합 테스트 게시글")
                .content("이것은 통합 기능 테스트를 위한 게시글입니다.")
                .inputDate(LocalDateTime.now())
                .hits(0)
                .build();

        // 게시글 생성
        System.out.println("  - 게시글 생성 테스트...");
        BoardEntity savedBoard = boardService.createBoard(testBoard);
        assertThat(savedBoard).isNotNull();
        assertThat(savedBoard.getBoardNum()).isGreaterThan(0);
        System.out.println("    ✓ 게시글 생성 성공 (ID: " + savedBoard.getBoardNum() + ")");

        // 게시글 조회
        System.out.println("  - 게시글 조회 테스트...");
        BoardEntity foundBoard = boardService.getBoardById(savedBoard.getBoardNum());
        assertThat(foundBoard).isNotNull();
        assertThat(foundBoard.getTitle()).isEqualTo("통합 테스트 게시글");
        System.out.println("    ✓ 게시글 조회 성공");

        // 게시글 수정
        System.out.println("  - 게시글 수정 테스트...");
        BoardEntity updateData = BoardEntity.builder()
                .title("수정된 게시글 제목")
                .content("수정된 게시글 내용입니다.")
                .build();
        BoardEntity updatedBoard = boardService.updateBoard(savedBoard.getBoardNum(), updateData);
        assertThat(updatedBoard.getTitle()).isEqualTo("수정된 게시글 제목");
        System.out.println("    ✓ 게시글 수정 성공");

        // 게시글 삭제
        System.out.println("  - 게시글 삭제 테스트...");
        boardService.deleteBoard(savedBoard.getBoardNum());
        BoardEntity deletedBoard = boardRepository.findById(savedBoard.getBoardNum()).orElse(null);
        assertThat(deletedBoard).isNull();
        System.out.println("    ✓ 게시글 삭제 성공");
    }

    private void testIndexServiceFunctionality() {
        System.out.println("\n[3] 인덱스 서비스 기능 테스트");

        try {
            // 인덱스 서비스 초기화 확인
            System.out.println("  - 인덱스 서비스 초기화 상태 확인...");
            assertThat(indexService).isNotNull();
            System.out.println("    ✓ 인덱스 서비스 정상 로드");
        } catch (Exception e) {
            System.out.println("    ⚠ 인덱스 서비스 관련 오류: " + e.getMessage());
        }
    }

    private void testTotalServiceFunctionality() {
        System.out.println("\n[4] 전체 서비스 기능 테스트");

        try {
            // 전체 서비스 초기화 확인
            System.out.println("  - 전체 서비스 초기화 상태 확인...");
            assertThat(totalService).isNotNull();
            System.out.println("    ✓ 전체 서비스 정상 로드");
        } catch (Exception e) {
            System.out.println("    ⚠ 전체 서비스 관련 오류: " + e.getMessage());
        }
    }

}
