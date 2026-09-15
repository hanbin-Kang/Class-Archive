# Linux 실습 문제 풀이

## 문제 1 — 디렉터리 만들기

### 문제

`Linux-practice` 디렉터리 안에 다음과 같은 구조를 만들어라.

```text
Linux-practice/
├── study/
└── backup/
```

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro ~ % mkdir Linux-practice
kanghanbin@ganghanbin-ui-MacBookPro ~ % cd Linux-practice
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % touch study
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % touch backup
```

`touch`로 만들었더니 파일이 만들어져서 삭제했다.

```bash
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % rm study
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % rm backup
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % mkdir study
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % mkdir backup
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % ls
backup    study
```

---

## 문제 2 — 디렉터리 안에 파일 만들기

### 문제

다음 구조를 만들어라.

```text
Linux-practice/
├── study/
│   ├── python.txt
│   └── java.txt
└── backup/
    └── backup.txt
```

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % cd study
kanghanbin@ganghanbin-ui-MacBookPro study % touch python.txt
kanghanbin@ganghanbin-ui-MacBookPro study % touch java.txt
kanghanbin@ganghanbin-ui-MacBookPro study % cd ..
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % cd backup
kanghanbin@ganghanbin-ui-MacBookPro backup % touch backup.txt
kanghanbin@ganghanbin-ui-MacBookPro backup % ls
backup.txt
```

다시 `study`로 이동해서 확인했다.

```bash
kanghanbin@ganghanbin-ui-MacBookPro backup % cd ..
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % cd study
kanghanbin@ganghanbin-ui-MacBookPro study % ls
java.txt    python.txt
```

---

## 문제 3 — `..`을 이용해서 이동하기

### 문제

현재 위치가 `study`일 때, `..`을 이용해서 `backup` 디렉터리로 이동해라.

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro study % cd ../backup
kanghanbin@ganghanbin-ui-MacBookPro backup %
```

---

## 문제 4 — 절대 경로로 이동하기

### 문제

현재 위치와 관계없이 **절대 경로**를 사용해서 `study` 디렉터리로 이동해라.

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro backup % cd /Users/kanghanbin/Linux-practice/study
kanghanbin@ganghanbin-ui-MacBookPro study %
```

---

## 문제 5 — 파일 이동하기

### 문제

`study/python.txt`를 `backup` 디렉터리로 이동해라.

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro study % cd ..
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % mv study/python.txt backup
```

`backup`으로 이동해서 확인했다.

```bash
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % cd backup
kanghanbin@ganghanbin-ui-MacBookPro backup % ls
backup.txt    python.txt
```

---

## 문제 6 — 파일 이름 변경하기

### 문제

`python.txt`의 이름을 `python_backup.txt`로 변경해라.

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro backup % mv python.txt python_backup.txt
kanghanbin@ganghanbin-ui-MacBookPro backup % ls
backup.txt    python_backup.txt
```

---

## 문제 7 — `less`로 파일 확인하기

### 문제

`backup.txt`를 `less`를 사용해서 확인해라.

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro backup % less backup.txt
```

파일 내용이 짧아서 화면에:

```text
~
~
~
(END)
```

처럼 표시됐다.

`q`를 눌러서 나왔다.

---

## 문제 8 — `cp` 파일 복사

### 문제

현재 위치는 `backup`이라고 가정한다.

`backup.txt`를 `study` 디렉터리로 **복사**해라.

조건:

* `cp` 사용
* 상대경로 사용
* 원본 `backup.txt`는 `backup`에 그대로 남아 있어야 함

최종 구조:

```text
Linux-practice/
├── backup/
│   ├── backup.txt
│   └── python_backup.txt
└── study/
    ├── java.txt
    └── backup.txt
```

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro backup % cd ..
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % ls
backup    study

kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % cp backup/backup.txt study

kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % ls
backup    study
```

`backup`에 원본이 그대로 있는지 확인했다.

```bash
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % cd b
cd: no such file or directory: b
```

`cd b`라고 잘못 입력해서 오류가 났다. 다시 제대로 입력했다.

```bash
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % cd backup
kanghanbin@ganghanbin-ui-MacBookPro backup % ls
backup.txt    python_backup.txt
```

원본이 그대로 있는 것을 확인했다.

다시 `study`로 이동해서 복사된 파일을 확인했다.

```bash
kanghanbin@ganghanbin-ui-MacBookPro backup % cd ..
kanghanbin@ganghanbin-ui-MacBookPro Linux-practice % cd study
kanghanbin@ganghanbin-ui-MacBookPro study % ls
backup.txt    java.txt
```

`backup.txt`가 `study`에도 생긴 것을 확인했다.

---

## 문제 9 — 파일 삭제하기

### 문제

`study`에 있는 `backup.txt`를 삭제해라.

### 풀이

```bash
kanghanbin@ganghanbin-ui-MacBookPro study % rm backup.txt
kanghanbin@ganghanbin-ui-MacBookPro study % ls
java.txt
```

---

## 문제 10 — `..`을 이용해서 파일 이동하기

### 문제

현재 위치가 `study`라고 가정한다.

`java.txt`를 `backup`으로 이동해라.

조건:

* 현재 위치는 `study`
* `..`을 사용
* 한 줄로 해결

### 풀이

문제에서는 `study`에서 바로 이동하는 것을 요구했지만, 나는 먼저 상위 디렉터리로 이동해서 해결했다.

```bash
cd ..
mv study/java.txt backup
```

결과적으로 파일은 제대로 이동했다.

---

## 종합 문제 — 디렉터리 구조 만들기

### 문제

다음 구조를 만들어라.

```text
linux-test/
├── python/
│   ├── basic.txt
│   └── function.txt
├── java/
│   └── class.txt
└── backup/
```

그 후:

1. `function.txt`를 `backup`으로 이동
2. `class.txt`를 `backup`으로 이동
3. `function.txt`를 `function_backup.txt`로 이름 변경

최종 구조:

```text
linux-test/
├── python/
│   └── basic.txt
├── java/
└── backup/
    ├── class.txt
    └── function_backup.txt
```

### 풀이

```bash
mkdir linux-test
cd linux-test
mkdir python
mkdir java
mkdir backup

cd python
touch basic.txt
touch function.txt

cd ../java
touch class.txt

cd ..
mv python/function.txt backup
mv java/class.txt backup

cd backup
ls
```

결과:

```text
class.txt    function.txt
```

이후 `function.txt`의 이름을 변경했다.

```bash
mv function.txt function_backup.txt
ls
```

최종 결과:

```text
class.txt    function_backup.txt
```
