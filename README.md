
# CoCoDa

이 프로젝트는 기존 Maven + JSP 기반의 레거시 스프링 프로젝트를 다음과 같이 리팩토링하는 프로젝트입니다

- ✅ Spring Boot 2.7 (Java 11)
- ✅ Gradle 기반 빌드
- ✅ JSP 제거 → HTML + JavaScript(fetch)
- ✅ REST API 기반 컨트롤러
- ✅ DTO + 유효성 검사 + 예외 처리

---

## 📦 실행 방법

```bash
# 1. JDK 11 이상 설치 확인
java -version

# 2. 프로젝트 루트에서 실행
./gradlew bootRun
```

## 🌐 API 예시 (JavaScript fetch)

```js
fetch("/api/course", {
  method: "POST",
  headers: {
    "Content-Type": "application/json"
  },
  body: JSON.stringify({ cx: "value1", cy: "value2" })
}).then(res => res.json()).then(data => {
  console.log(data);
});
```

---

## ⚙ DB 설정

`application.yml` 내부 설정 확인:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/cocoda
    username: your_user
    password: your_pass
  jpa:
    hibernate:
      ddl-auto: update
```

> ⚠ 로컬 DB 설정에 맞게 `application.yml`을 수정하세요.

---

## ✅ 주요 변경점 요약

- JSP → 정적 HTML + JS(fetch) 전환
- `@RestController` 기반 API 컨트롤러
- DTO, `@RequestBody`, `@Valid` 유효성 검사
- `@ControllerAdvice`로 전역 예외 처리 적용
- Gradle 설정으로 빌드 간소화

---

