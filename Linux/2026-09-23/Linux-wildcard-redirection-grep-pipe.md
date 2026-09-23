# Linux 와일드카드, 리다이렉션, grep, 파이프

## 1. 디렉토리 복사와 `cp -r`

`cp`를 사용하여 파일이나 디렉토리를 복사할 수 있다.

```bash
cp -r test test1
```

예시:

```text
test
├── subtest
│   └── w2.txt
└── w1.txt

2 directories, 2 files
```

```bash
cp -r test test1
```

복사 후:

```text
test
├── subtest
│   └── w2.txt
└── w1.txt

test1
├── subtest
│   └── w2.txt
└── w1.txt
```

### `-r`

`-r`은 **recursive(재귀적)**의 의미이다.

디렉토리 안에 다른 디렉토리나 파일이 포함되어 있을 때, 내부까지 재귀적으로 복사하기 위해 사용한다.

```bash
cp -r test test1
```

→ `test` 디렉토리와 내부의 모든 파일 및 디렉토리를 `test1`로 복사한다.

---

# 2. 와일드카드(Wildcard)

와일드카드는 **파일 이름의 패턴을 이용하여 여러 파일을 선택하는 기능**이다.

대표적으로 `*`, `?`를 사용한다.

## `*`

`*`는 **어떤 문자든 0개 이상**을 의미한다.

예를 들어:

```text
a.txt
b.txt
abc.txt
test.txt
```

다음 명령어를 실행하면:

```bash
ls *.txt
```

`.txt`로 끝나는 모든 파일을 선택한다.

```text
a.txt
b.txt
abc.txt
test.txt
```

### `cp`에서 사용

```bash
cp *.txt backup/
```

→ 현재 디렉토리의 모든 `.txt` 파일을 `backup` 디렉토리로 복사한다.

### `mv`에서 사용

```bash
mv *.txt backup/
```

→ 모든 `.txt` 파일을 `backup` 디렉토리로 이동한다.

### `rm`에서 사용

```bash
rm *.txt
```

→ 현재 디렉토리의 모든 `.txt` 파일을 삭제한다.

> `rm`에서 와일드카드를 사용할 때는 선택되는 파일을 먼저 확인하는 것이 좋다.

---

## `?`

`?`는 **정확히 한 글자**를 의미한다.

예를 들어 다음 파일이 있다고 하자.

```text
w1.txt
w2.txt
w3.txt
word.txt
```

```bash
ls w?.txt
```

결과:

```text
w1.txt
w2.txt
w3.txt
```

`w?.txt`에서 `?`가 한 글자를 의미하기 때문이다.

```text
w1.txt → ?
w2.txt → ?
w3.txt → ?
```

하지만:

```text
word.txt
```

는 `?` 부분에 들어가는 글자가 여러 개이므로 선택되지 않는다.

### `cp` 예시

```bash
cp w?.txt backup/
```

→ `w1.txt`, `w2.txt`, `w3.txt`처럼 `w` 다음에 한 글자가 오는 파일을 복사한다.

---

## `*`와 `?` 비교

| 와일드카드 | 의미       | 예시       |
| ----- | -------- | -------- |
| `*`   | 문자 0개 이상 | `*.txt`  |
| `?`   | 정확히 한 글자 | `w?.txt` |

와일드카드는 `cp`, `mv`, `rm` 등 여러 명령어에서 사용할 수 있다.

---

# 3. 표준 입출력(Standard I/O)

프로그램은 기본적으로 다음과 같은 입출력 구조를 가진다.

```text
Keyboard
   ↓
stdin
   ↓
Program
   ↓
stdout
   ↓
Screen
```

* `stdin` : 표준 입력
* `stdout` : 표준 출력

예를 들어:

```bash
echo "GSC"
```

키보드에서 명령어를 입력하면 `echo`가 실행되고 결과가 화면에 출력된다.

```text
Keyboard → echo → Screen
```

---

# 4. 리다이렉션(Redirection)

리다이렉션은 **프로그램의 입력이나 출력 방향을 다른 대상으로 변경하는 것**이다.

기본적인 리다이렉션:

```text
출력 → >, >>
입력 → <
```

---

## `>`

`>`는 기존 내용을 **덮어쓰고**, 파일이 존재하지 않으면 새로 만든다.

```bash
echo "GSC" > a.txt
```

실행 후 `a.txt`:

```text
GSC
```

다시:

```bash
echo "Hello" > a.txt
```

실행하면 기존 `GSC`가 사라지고:

```text
Hello
```

만 남는다.

### Python에서도 사용 가능

```bash
python3 -c "print('hello gsc')" > a.txt
```

→ Python 프로그램의 정상적인 출력 결과를 `a.txt`에 저장한다.

---

## `>>`

`>>`는 기존 내용을 유지하면서 **뒤에 내용을 추가**한다.

```bash
echo "GSC" > a.txt
echo "Python" >> a.txt
echo "Java" >> a.txt
```

결과:

```text
GSC
Python
Java
```

파일이 존재하지 않는 경우에도 새 파일을 만든다.

---

## `<`

`<`는 파일의 내용을 프로그램의 **표준 입력(stdin)**으로 전달한다.

예:

```bash
wc -l < file.txt
```

→ `file.txt`의 내용을 `wc`의 입력으로 전달한다.

```text
file.txt
   │
   │ stdin
   ▼
wc -l
```

---

# 5. Here Document `<<`

`<<`는 여러 줄의 입력을 프로그램에 전달할 때 사용할 수 있다.

이를 **Here Document**라고 한다.

예:

```bash
cat > test.txt << EOF
Hello
Python
Java
EOF
```

실행하면 `test.txt`가 생성되고:

```text
Hello
Python
Java
```

가 저장된다.

여기서 `EOF`는 입력의 끝을 표시하기 위한 구분자이다.

---

# 6. `stdout`과 `stderr`

프로그램의 출력은 크게 두 종류로 나눌 수 있다.

```text
1 → stdout → 정상적인 출력
2 → stderr → 오류/에러 출력
```

따라서 리다이렉션할 때:

```bash
1> result.txt
```

→ 정상적인 출력만 파일로 보낸다.

```bash
2> error.txt
```

→ 오류 출력만 파일로 보낸다.

`1`은 stdout을 의미하므로 생략할 수 있다.

```bash
python3 test.py > result.txt
```

와

```bash
python3 test.py 1> result.txt
```

는 동일하다.

---

# 7. stdout과 stderr 실습

`test.txt`를 다음과 같이 만든다.

```bash
cat > test.txt << EOF
import sys

print('1')
print('E2', file=sys.stderr)
print('3')
print('E4', file=sys.stderr)
print('5')
EOF
```

실행하면 프로그램에는 다음과 같은 출력이 존재한다.

```text
stdout:
1
3
5

stderr:
E2
E4
```

## stdout을 파일로 보내기

```bash
python3 test.txt 1> result.txt
```

정상 출력은 `result.txt`로 이동한다.

화면:

```text
E2
E4
```

`result.txt`:

```text
1
3
5
```

---

## stderr을 파일로 보내기

```bash
python3 test.txt 2> result_E.txt
```

에러 출력은 `result_E.txt`로 이동한다.

화면:

```text
1
3
5
```

`result_E.txt`:

```text
E2
E4
```

즉:

```text
1> → stdout → 정상 출력
2> → stderr → 오류 출력
```

---

# 8. `grep`

`grep`은 **파일이나 입력 내용에서 특정 문자열 또는 패턴을 검색하는 명령어**이다.

예를 들어 `file.txt`가 다음과 같다고 하자.

```text
Python
Java
gsc hi
SQL
gsc python
Linux
Java gsc
```

## 기본 사용법

```bash
grep "gsc" file.txt
```

결과:

```text
gsc hi
gsc python
Java gsc
```

`gsc`가 포함된 줄을 모두 출력한다.

기본적으로 **대소문자를 구분**한다.

따라서:

```text
gsc
Gsc
GSC
```

는 서로 다르게 취급한다.

---

## `grep -n`

`-n`을 사용하면 **줄 번호를 함께 출력**한다.

```bash
grep -n "gsc" file.txt
```

결과:

```text
3:gsc hi
5:gsc python
7:Java gsc
```

---

## `grep -i`

`-i`를 사용하면 **대소문자를 구분하지 않는다.**

```bash
grep -i "gsc" file.txt
```

다음과 같은 내용도 검색된다.

```text
gsc hi
gsc python
Java gsc
ddd Gsc
```

---

# 9. Pipe `|`

Pipe는 **한 프로그램의 stdout을 다른 프로그램의 stdin으로 연결하는 기능**이다.
("앞 명령어의 결과를 뒤 명령어에 넘긴다"는 느낌)

기본 구조:

```text
프로그램 1
    │
    │ stdout
    ▼
프로그램 2
    │
    │ stdin
    ▼
```

즉,

```bash
program1 | program2
```

는

> **프로그램 1의 출력 결과를 프로그램 2의 입력으로 전달한다.**

---

## 예시

```bash
cat file.txt | grep "gsc"
```

동작 과정:

```text
cat file.txt
      │
      │ stdout
      ▼
grep "gsc"
      │
      ▼
gsc가 포함된 줄 출력
```

즉 `cat`이 파일 전체 내용을 출력하고, 그 출력 결과가 `grep`의 입력으로 들어간다.

---

## 리다이렉션과 Pipe 비교

```bash
cat file.txt > result.txt
```

→ `cat`의 stdout을 **파일**로 보낸다.

```bash
cat file.txt | grep "gsc"
```

→ `cat`의 stdout을 **다른 프로그램인 grep의 stdin**으로 보낸다.

### 핵심 정리

```text
리다이렉션

프로그램 ──stdout──→ 파일


Pipe

프로그램 1 ──stdout──→ 프로그램 2 ──→ 출력
                         ↑
                        stdin
```

따라서 `>`와 `|`의 가장 중요한 차이는 **출력의 목적지**이다.

```text
>  → 파일로 전달
|  → 다른 프로그램으로 전달
```
