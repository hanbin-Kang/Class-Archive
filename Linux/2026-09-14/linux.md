# Linux 기본 명령어

## 01. 디렉터리 및 파일 관리

### `mkdir`

폴더(디렉터리)를 생성한다.

```bash
mkdir [폴더명]
```

예시:

```bash
mkdir backup
```

---

### `touch`

파일을 생성한다.

정확하게는 파일의 **시간 정보를 갱신**하는 명령어이며, 해당 파일이 존재하지 않는 경우 새 파일을 생성한다.

```bash
touch [파일명]
```

예시:

```bash
touch hello.txt
```

---

### `cd`

현재 작업 위치를 변경한다.

```bash
cd [이동하고 싶은 곳]
```

예시:

```bash
cd work
```

---

### `mv`

파일이나 폴더의 **위치를 이동**하거나 **이름을 변경**한다.

#### 파일/폴더 이동

```bash
mv [이동할 파일] [이동할 곳]
```

예시:

```bash
mv hello.txt backup
```

→ `hello.txt`를 `backup` 폴더로 이동

#### 이름 변경

```bash
mv [원본 파일 이름] [바꿀 파일 이름]
```

예시:

```bash
mv hello.txt hello2.txt
```

→ `hello.txt`의 이름을 `hello2.txt`로 변경

---

### `rm`

파일을 삭제한다.

```bash
rm [삭제할 파일명]
```

예시:

```bash
rm hello.txt
```

---

### `rm -r`

폴더와 그 안의 내용을 재귀적으로 삭제한다.

```bash
rm -r [삭제할 폴더명]
```

예시:

```bash
rm -r backup
```

→ `backup` 폴더와 내부 파일을 삭제

---

### `cp`

파일이나 폴더를 복사한다.

```bash
cp [복사할 파일의 위치]/[복사할 파일] [복사할 곳]
```

예시:

```bash
cp work/hello.txt backup
```

→ `work` 폴더의 `hello.txt`를 `backup` 폴더로 복사

---

## 02. 파일 내용 확인 및 입력

### `echo`

문자열을 출력한다.

파이썬의 `print()`와 비슷한 역할을 한다.

```bash
echo "[출력할 문자열]"
```

예시:

```bash
echo "Hello Linux"
```

→ `Hello Linux`를 화면에 출력

`>`와 함께 사용하면 문자열을 파일에 저장할 수 있다.

```bash
echo "Hello Linux" > hello.txt
```

→ `hello.txt`에 `Hello Linux`를 저장

---

### `cat`

파일의 내용을 화면에 출력한다.

```bash
cat [파일명]
```

예시:

```bash
cat hello.txt
```

→ `hello.txt`의 내용을 확인

`cat`에서 출력되는 화면은 **standard output(표준 출력)**이며 일반적으로 모니터(터미널)로 출력된다.

---

## 03. 리다이렉션

### `>`

기존 파일의 내용을 **덮어쓴다.**

```bash
echo "Hello" > hello.txt
```

기존 `hello.txt`의 내용이 있다면 삭제되고 `Hello`로 교체된다.

---

### `>>`

기존 파일의 내용 뒤에 **추가한다.**

```bash
echo "World" >> hello.txt
```

기존 내용은 유지되고 `World`가 뒤에 추가된다.

---

## 04. 핵심 정리

| 명령어     | 역할               |
| ------- | ---------------- |
| `mkdir` | 폴더 생성            |
| `touch` | 파일 생성 / 시간 정보 갱신 |
| `cd`    | 현재 위치 이동         |
| `mv`    | 파일·폴더 이동 / 이름 변경 |
| `rm`    | 파일 삭제            |
| `rm -r` | 폴더 및 내부 내용 삭제    |
| `cp`    | 파일·폴더 복사         |
| `echo`  | 문자열 출력           |
| `cat`   | 파일 내용 확인         |
| `>`     | 기존 내용 덮어쓰기       |
| `>>`    | 기존 내용 뒤에 추가      |

### 명령어 사용 흐름 예시

```bash
mkdir work
cd work
touch hello.txt
echo "Hello Linux" > hello.txt
cat hello.txt
mkdir backup
cp hello.txt backup
cd ..
mv work backup2
rm -r backup2
```
