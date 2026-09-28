# Linux 표준 입출력, 리다이렉션, 파이프라인, find

Linux에서 명령어가 데이터를 입력받고 출력하는 방식을 이해한다.

---

## 1. 표준 입출력

Linux에서는 프로그램이 기본적으로 **표준 입력(Standard Input)**을 통해 데이터를 입력받고, **표준 출력(Standard Output)**을 통해 결과를 출력한다.

### 표준 입력 (stdin)

```text
Standard Input
      ↓
   프로그램
```

기본적으로 키보드 입력이 표준 입력으로 사용된다.

### 표준 출력 (stdout)

```text
   프로그램
      ↓
Standard Output
      ↓
    화면
```

기본적으로 프로그램의 결과가 화면으로 출력된다.

```text
키보드 → stdin → 명령어 → stdout → 화면
```

---

## 2. Linux에서는 모든 것을 파일처럼 다룬다

Linux에서는 일반적인 파일뿐만 아니라 장치나 표준 입출력도 **파일과 유사한 방식으로 다룬다.**

따라서 표준 입력과 표준 출력도 파일처럼 다른 곳으로 연결하거나 방향을 변경할 수 있다.

---

## 3. 리다이렉션 (Redirection)

리다이렉션은 **입출력의 방향을 변경하는 것**이다.

주요 연산자는 다음과 같다.

```text
<     표준 입력 방향 변경
<<    여러 줄의 입력을 전달
>     표준 출력 → 파일로 저장
>>    표준 출력 → 파일에 추가
```

### 3-1. `>` 표준 출력 방향 변경

```bash
echo "hello" > test.txt
```

원래 화면으로 출력될 내용을 `test.txt`에 저장한다.

```text
echo
 ↓
stdout
 ↓
test.txt
```

기존 파일의 내용은 덮어쓴다.

---

### 3-2. `>>` 표준 출력 추가

```bash
echo "world" >> test.txt
```

기존 `test.txt`의 내용 뒤에 새로운 내용을 추가한다.

```text
기존 내용
   +
새로운 내용
```

---

## 4. 파이프라인 (Pipeline)

파이프라인은 `|`를 사용하여 **앞 명령어의 표준 출력을 뒤 명령어의 표준 입력으로 연결하는 것**이다.

```bash
A | B
```

의미:

```text
명령어 A
   │
   │ stdout
   ↓
   │ stdin
명령어 B
```

즉,

> **A의 결과가 B의 입력값이 된다.**

명령어는 왼쪽에서 오른쪽 순서로 연결되어 실행된다.

---

## 5. `cat`과 `grep`을 이용한 파이프라인

예를 들어 `test.txt`가 다음과 같다고 하자.

```text
java
gsc
python
gsc
database
```

다음 명령어를 실행할 수 있다.

```bash
cat test.txt | grep "gsc"
```

동작 과정:

```text
test.txt
   ↓
 cat
   ↓
stdout
   ↓
  |
   ↓
grep "gsc"
   ↓
stdout
```

`cat`의 표준 출력이 `grep`의 표준 입력으로 전달된다.

결과:

```text
gsc
gsc
```

---

## 6. 파이프라인 여러 개 연결하기

파이프라인은 여러 개를 연속해서 사용할 수 있다.

```bash
cat test.txt | grep "gsc" | tail -2 > result.txt
```

전체 흐름:

```text
test.txt
   ↓
 cat
   ↓
stdout
   ↓
grep "gsc"
   ↓
stdout
   ↓
tail -2
   ↓
stdout
   ↓
result.txt
```

각 명령어의 결과가 다음 명령어의 입력으로 전달된다.

```text
cat → grep → tail → result.txt
```

### 핵심

```bash
cat test.txt | grep "gsc" | tail -2 > result.txt
```

* `cat test.txt` → 파일 내용 출력
* `|` → `cat`의 stdout을 `grep`의 stdin으로 전달
* `grep "gsc"` → `gsc`가 포함된 줄만 출력
* `|` → `grep`의 stdout을 `tail`의 stdin으로 전달
* `tail -2` → 마지막 2줄 출력
* `>` → 최종 stdout을 `result.txt`에 저장

---

## 7. 잘못된 파이프라인 사용

다음과 같이 작성하면 원하는 동작이 되지 않는다.

```bash
cat test.txt > l.txt | grep "gsc"
```

`>`는 `cat`의 표준 출력을 `l.txt`로 **방향 전환**한다.

따라서 `cat`의 stdout이 `grep`으로 전달되는 것이 아니다.

```text
cat test.txt
      ↓
    stdout
      ↓
   l.txt
```

`grep`이 받을 `cat`의 stdout이 파이프로 연결되지 않았기 때문에 의도한 파이프라인이 아니다.

원하는 것이 `test.txt`에서 `gsc`를 찾는 것이라면:

```bash
cat test.txt | grep "gsc"
```

처럼 작성해야 한다.

---

# 8. `find`

`find`는 **파일이나 디렉토리를 조건에 따라 찾아주는 명령어**이다.

```bash
find [찾을 위치] [조건]
```

`ls`처럼 단순히 목록을 보여주는 것이 아니라 **조건을 지정하여 원하는 파일이나 디렉토리를 찾아낸다.**

---

## 9. 이름으로 파일 찾기

```bash
find . -name "test.txt"
```

현재 디렉토리(`.`)부터 `test.txt`라는 이름의 파일을 찾는다.

```text
.
├── test.txt      ← 찾음
├── memo.txt
└── folder
    └── test.txt  ← 찾음
```

---

## 10. 특정 확장자 찾기

```bash
find . -name "*.txt"
```

현재 디렉토리부터 `.txt`로 끝나는 모든 파일을 찾는다.

```text
./test.txt
./memo.txt
./folder/data.txt
```

여기서 `*`는 **어떤 문자열이든 올 수 있음**을 의미한다.

```text
*.txt
 ↑
어떤 문자열이든 가능
```

---

## 11. 파일만 찾기

```bash
find . -type f
```

현재 위치부터 **파일만** 찾는다.

```text
-type f
       ↑
      file
```

---

## 12. 디렉토리만 찾기

```bash
find . -type d
```

현재 위치부터 **디렉토리만** 찾는다.

```text
-type d
       ↑
   directory
```

---

# 13. 명령어의 관계

지금까지 배운 내용을 연결하면 다음과 같다.

```text
표준 입력
   ↓
명령어
   ↓
표준 출력
   ↓
 ┌─┴───────────────┐
 │                 │
화면              파이프
                    ↓
                 다음 명령어
```

리다이렉션을 사용하면:

```text
명령어
  ↓
stdout
  ↓
파일
```

파이프라인을 사용하면:

```text
명령어 A
  ↓
stdout
  ↓
   |
  ↓
stdin
  ↓
명령어 B
```

---

# 14. 주요 명령어

| 명령어    | 역할                  |
| ------ | ------------------- |
| `ls`   | 파일 및 디렉토리 목록 확인     |
| `cp`   | 파일 및 디렉토리 복사        |
| `rm`   | 파일 및 디렉토리 삭제        |
| `cat`  | 파일 내용 출력            |
| `grep` | 특정 문자열 검색           |
| `tail` | 파일 또는 입력의 마지막 부분 출력 |
| `find` | 조건에 맞는 파일 및 디렉토리 검색 |

이러한 명령어들은 Linux에서 실행되는 **프로그램**이며, 쉘에서 명령어를 입력하면 해당 프로그램이 실행된다.

---

# 15. 핵심 정리

### 표준 입출력

```text
stdin  → 기본적으로 키보드
stdout → 기본적으로 화면
```

### 리다이렉션

```text
<   입력 방향 변경
<<  여러 줄 입력
>   출력 → 파일 (덮어쓰기)
>>  출력 → 파일 (추가)
```

### 파이프라인

```bash
A | B
```

```text
A의 stdout → B의 stdin
```

### find

```bash
find [위치] [조건]
```

```bash
find . -name "*.txt"
find . -type f
find . -type d
```

**핵심은 `리다이렉션`은 입출력의 방향을 파일 등으로 바꾸는 것이고, `파이프라인`은 한 명령어의 stdout을 다음 명령어의 stdin으로 연결하는 것이라는 차이이다.**
