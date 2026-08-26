# 가상환경이란

Python 프로젝트마다 독립적인 개발 환경을 만들어주는 기능이다.

## 가상환경을 사용하는 이유

프로젝트마다 필요한 Python 패키지와 버전을 독립적으로 관리하기 위해 사용한다.

예를 들어 A 프로젝트에서는 특정 패키지의 1.0 버전이 필요하고,
B 프로젝트에서는 같은 패키지의 2.0 버전이 필요한 경우가 있다.

이때 가상환경을 사용하면 각 프로젝트의 패키지 환경을 서로 분리할 수 있다.

또한 프로젝트별로 필요한 패키지만 설치할 수 있기 때문에
프로젝트 간의 패키지 충돌을 방지할 수 있다.

> 참고: `venv`는 Python 버전 자체를 자동으로 분리하는 도구는 아니다.
> Python 버전을 다르게 사용하려면 원하는 Python 버전으로 각각 가상환경을 생성해야 한다.

## 가상환경 사용법 (Mac)

### 1. 가상환경 생성
```bash
python3 -m venv .venv
```

### 2. 가상환경 활성화
```bash
source .venv/bin/activate
```

### 3. 패키지 설치 방법
```bash
python3 -m pip install 패키지명
```

### 4. 패키지 확인 방법
```bash
pip list
```

### 5. 패키지 삭제 방법
```bash
python3 -m pip uninstall 패키지명
```
을 입력하면 이게 뜨고 Proceed (Y/n)? Y를 입력

### 6. 가상환경 종료
```bash
deactivate
```

### 7. 활성화 방법
```bash
source .venv/bin/activate
```

#### 가상환경을 github에는 보통 올리지 않는다
프로젝트에서 사용한 가상환경(.venv)은 운영체제와 Python 환경에 종속되고 파일도 많기 때문에 GitHub에 올리지 않는 것이 일반적이다.
따라서 프로젝트 루트에 .gitignore 파일을 만들고 .venv/를 추가하면, git add .을 실행해도 .venv/는 Git에 추가되지 않는다.
```
pip freeze > requirements.txt 
```
을 통해 가상환경에서 사용한 패키지명과 버전들이 txt형식으로 저장된다