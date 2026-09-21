# Linux 파일과 경로

## 1. 파일과 디렉토리

### 파일

파일은 데이터를 저장하는 단위이다.

* 일반 파일: 텍스트, 이미지, 프로그램 파일 등

### 디렉토리

디렉토리(Directory)는 파일과 다른 디렉토리를 저장하는 공간이다.

---

## 2. 경로 (Path)

**경로(Path)** : 파일이나 디렉토리가 저장된 위치를 나타내는 것

### ① 절대경로 (Absolute Path)

**루트 디렉토리(`/`)부터 원하는 위치까지 나타내는 경로**

```text
/Users/kanghanbin/Linux-lab/work/app.conf
```

운영체제나 사용자 환경이 다르면 디렉토리 구조가 달라질 수 있으므로 절대경로도 달라질 수 있다.

### ② 상대경로 (Relative Path)

**현재 디렉토리를 기준으로 원하는 위치까지 나타내는 경로**

```text
./work/app.conf
```

현재 디렉토리를 기준으로 하기 때문에 `/`로 시작하지 않는다.

> `.` : 현재 디렉토리
> `..` : 상위 디렉토리

---

## 3. 파일 이름에 띄어쓰기가 있는 경우

`touch`는 공백을 기준으로 여러 인자를 구분한다.

```bash
touch hello world
```

위 명령어는 다음 **2개의 파일**을 만든다.

```text
hello
world
```

파일 이름에 띄어쓰기를 포함하려면 따옴표로 묶는다.

```bash
touch "hello world"
```

이 경우 **하나의 파일**이 만들어진다.

```text
hello world
```

---

# 4. 파일과 디렉토리 관리 명령어

| 작업       | 파일      | 디렉토리             |
| -------- | ------- | ---------------- |
| 생성       | `touch` | `mkdir`          |
| 복사       | `cp`    | `cp`             |
| 이동/이름 변경 | `mv`    | `mv`             |
| 삭제       | `rm`    | `rm -r`, `rmdir` |

`cp`와 `mv`는 파일과 디렉토리 모두 사용할 수 있다.

단, **디렉토리를 복사할 때는 `-r` 옵션이 필요하다.**

```bash
cp -r source_dir destination_dir
```

---

## 5. 디렉토리 생성

### mkdir

디렉토리를 생성한다.

```bash
mkdir work
```

### mkdir -p

중간에 존재하지 않는 **하위 디렉토리까지 한 번에 생성**한다.

```bash
mkdir -p work/project/src
```

`work`가 없으면 `work`부터 생성하고 디렉토리 구조를 한 번에 만든다.

> `-p` : 필요한 부모 디렉토리까지 생성

---

# 6. 파일과 디렉토리 삭제

### rm

파일을 삭제한다.

```bash
rm memo.txt
```

### rm -r

디렉토리와 그 안의 내용을 **재귀적으로(Recursive)** 삭제한다.

```bash
rm -r work
```

> `-r` : Recursive(재귀적으로)

### rmdir

비어 있는 디렉토리를 삭제한다.

```bash
rmdir work
```

디렉토리 안에 파일이 있으면 삭제할 수 없다.

---

# 7. 복사와 이동

## cp

파일이나 디렉토리를 복사한다.

```bash
cp Source Destination
```

* `Source` : 원본
* `Destination` : 복사할 대상 위치

예시:

```bash
cp memo.txt backup/
```

`memo.txt`를 `backup` 디렉토리에 복사한다.

디렉토리를 복사할 때는 `-r`을 사용한다.

```bash
cp -r work backup/
```

---

## mv

파일이나 디렉토리를 이동하거나 이름을 변경한다.

```bash
mv Source Destination
```

예시:

```bash
mv memo.txt backup/
```

`memo.txt`를 `backup` 디렉토리로 이동한다.

### 이름 변경

```bash
mv memo.txt memo-final.txt
```

같은 디렉토리에서 대상 이름을 다르게 지정하면 **이름 변경**이 된다.

---

# 8. `-i` 옵션

`cp -i`, `mv -i`는 대상 파일이 이미 존재하여 **덮어쓸 가능성이 있을 때 확인을 요청**한다.

```bash
cp -i memo.txt backup/
```

```bash
mv -i memo.txt backup/
```

> `-i` : Interactive(대화형) 옵션

실수로 기존 파일을 덮어쓰는 것을 방지할 때 사용할 수 있다.

---

# 9. 예습 - 파일 내용 읽기

Linux에서는 파일의 내용을 확인할 때 여러 명령어를 사용할 수 있다.

| 명령어    | 기능         |
| ------ | ---------- |
| `cat`  | 파일 전체 출력   |
| `head` | 파일 앞부분 출력  |
| `tail` | 파일 뒷부분 출력  |
| `less` | 페이지 단위로 확인 |

### cat

파일의 전체 내용을 출력한다.

```bash
cat app.log
```

### head

파일의 **앞부분**을 출력한다.

```bash
head -n 2 app.log
```

앞에서부터 **2줄**을 출력한다.

### tail

파일의 **뒷부분**을 출력한다.

```bash
tail -n 2 app.log
```

뒤에서부터 **2줄**을 출력한다.

### less

파일 내용을 페이지 단위로 확인한다.

```bash
less app.log
```

> 자세한 사용법은 이후 학습 예정

---

# 10. 핵심 명령어 정리

```text
파일 생성       touch
디렉토리 생성   mkdir
복사            cp
이동/이름 변경  mv
파일 삭제       rm
디렉토리 삭제   rm -r / rmdir

부모 디렉토리까지 생성   mkdir -p
재귀적으로 처리          -r
덮어쓰기 확인            -i
```
