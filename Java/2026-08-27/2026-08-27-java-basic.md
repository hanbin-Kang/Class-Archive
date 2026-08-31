# 2026-08-27 Java 수업 내용

## 1. Java 개발 환경 구성

### JDK (Java Development Kit)

Java 프로그램을 개발하기 위해 필요한 개발 도구 모음.

* JDK 1.5
* JDK 1.8
* JDK 17 ⭐
* JDK 21 ⭐ **LTS(Long Term Support)**


### IDE (통합 개발 환경)

Java 소스 코드를 작성하고 실행하기 위한 편집 도구.

* NetBeans
* Eclipse
* IntelliJ IDEA ⭐

---

## 2. Java의 기본적인 특징

### Java 소스 코드의 특징

#### ① 파일 확장자

Java 소스 코드는 `.java` 확장자로 끝난다.

```java
HelloJava.java
```

#### ② 파일명과 클래스명

`public class`로 선언된 클래스의 이름과 Java 파일의 이름은 동일해야 한다.

```java
public class HelloJava {
}
```

→ 파일명: `HelloJava.java`

#### ③ Class가 기본 단위

Java 소스 코드는 **class를 먼저 만들고 그 내부에 코드를 작성**한다.

따라서 class가 없는 일반적인 Java 소스 코드는 존재할 수 없다.

```java
public class HelloJava {
    
}
```

#### ④ 컴파일

Java 소스 코드(`.java`)를 컴파일하면 `.class` 파일이 생성된다.

```text
HelloJava.java
      ↓ 컴파일
HelloJava.class
```

`.class` 파일은 **JVM이 실행할 수 있는 바이트코드 파일**이다.

---

## 3. JVM (Java Virtual Machine)

JVM은 Java의 `.class` 파일을 실행하는 가상 머신이다.

```text
Java 소스 코드
HelloJava.java
       ↓
     컴파일
       ↓
HelloJava.class
       ↓
      JVM
   ↙    ↓    ↘
Windows Linux  macOS
```

### JVM의 특징

`.class` 파일 자체는 특정 운영체제에서 직접 실행되는 파일이 아니라 **JVM에서 실행할 수 있는 파일**이다.

따라서 동일한 `.class` 파일을 운영체제별 JVM을 통해 실행할 수 있다.

* Windows → Windows용 JVM
* Linux → Linux용 JVM
* macOS → macOS용 JVM

즉, **"Write Once, Run Anywhere"**라는 Java의 특징을 가질 수 있다.

### JRE

JRE(Java Runtime Environment)는 Java 프로그램을 실행하기 위한 환경이다.

JRE에는 **JVM이 포함**되어 있다.

> 참고: 현재의 Java 배포판에서는 JDK에 실행 환경이 포함되어 있으므로 별도로 JRE를 설치하지 않는 경우가 많다.

### JVM의 한계

Java가 모든 운영체제의 기능을 동일하게 사용할 수 있다는 의미는 아니다.

Java의 플랫폼 독립성은 **JVM이 제공하는 범위 내에서** 이루어진다.

예를 들어 특정 운영체제에서만 제공되는 기능을 사용하면 플랫폼에 종속될 수 있다.

---

# 4. Java 기본 자료형

## 변수

변수는 **값을 저장하는 메모리 공간**이다.

Java에서는 변수를 선언할 때 **자료형을 지정**하여 저장할 값의 종류와 필요한 메모리 공간을 결정한다.

```java
int x = 10;
```

* `int` → 변수의 자료형
* `x` → 변수명
* `10` → 저장할 값

Python처럼

```python
x = 10
```

이라고만 작성하면 Java에서는 `x`가 어떤 종류의 값을 저장하는지 알 수 없기 때문에 자료형을 명시한다.

---

## 기본 자료형 (Primitive Type)

Java의 기본 자료형은 다음과 같다.

### ① 정수형

```text
byte → short → int → long
```

| 자료형   |     크기 |
| ----- | -----: |
| byte  | 1 byte |
| short | 2 byte |
| int   | 4 byte |
| long  | 8 byte |

정수형에서 **기본적으로 사용하는 타입은 `int`**이다.

```java
int x = 10;
```

---

### ② 실수형

```text
float
double
```

실수 리터럴의 기본 타입은 **`double`**이다.

```java
double x = 10.5;
```

`float`을 사용할 경우에는 `f`를 붙여야 한다.

```java
float x = 10.5f;
```

---

### ③ 문자형

`char`는 하나의 문자를 저장한다.

```java
char c = 'A';
```

문자는 작은따옴표(`' '`)를 사용한다.

`char`에는 문자뿐만 아니라 해당 문자의 **유니코드 값**도 저장할 수 있다.


```java
char c = 65;
```

→ `65`에 해당하는 문자 `'A'`

---

### ④ boolean형

`true` 또는 `false`만 저장한다.

```java
boolean result = true;
```

---

# 5. 변수에 값 대입하기

```java
int x = 10;
int y = x;

x = 100;
```

여기서

```java
x = 100;
```

은 새로운 변수를 선언하는 것이 아니라 **기존 변수 `x`에 새로운 값을 대입하는 것**이다.

따라서 `int`를 다시 작성하지 않는다.

```java
int x = 10;  // 변수 선언 + 초기화
x = 100;     // 기존 변수에 값 대입
```

결과:

```text
x → 100
y → 10
```

`y = x`를 실행하는 순간에는 `x`의 값인 `10`이 복사되기 때문에 이후 `x`의 값이 변경되어도 `y`에는 영향을 주지 않는다.

---

# 6. 같은 변수명 사용 가능 여부

```java
int x = 10;
char x = 'A';
```

위 코드는 **같은 범위(scope)에서 사용할 수 없다.**

변수의 이름은 자료형이 다르더라도 별개의 이름으로 취급되는 것이 아니라 **같은 이름의 변수**이기 때문이다.

```java
int x = 10;
char y = 'A';
```

처럼 변수명을 다르게 사용해야 한다.

> 단, 서로 다른 Scope에서는 같은 이름을 사용할 수 있다.

---

# 7. 배열과 참조변수

배열은 여러 개의 값을 하나의 자료구조로 관리할 수 있다.

```java
int[] x = {10, 20, 30};
```

`x`는 배열 자체를 직접 저장하는 것이 아니라 **배열 객체를 참조하는 참조변수**이다.

```java
int[] y = x;
```

이 경우 `x`가 가리키는 **같은 배열을 `y`도 참조**하게 된다.

```text
        ┌───────────────┐
x ─────→│ 10 │ 20 │ 30 │
        └───────────────┘
y ─────→       ↑
       같은 배열을 참조
```

따라서

```java
x[0] = 100;
```

을 실행하면

```text
x → [100, 20, 30]
y → [100, 20, 30]
```

이 된다.

즉,

```java
y[0]
```

의 결과는 **`100`**이다.

### 핵심 차이

일반 변수:

```java
int x = 10;
int y = x;

x = 100;
```

→ 값이 복사됨

```text
x → 100
y → 10
```

배열:

```java
int[] x = {10, 20, 30};
int[] y = x;

x[0] = 100;
```

→ 같은 배열을 참조함

```text
x ──┐
    ↓
 [100, 20, 30]
    ↑
y ──┘
```

따라서 배열과 같은 **참조형 변수에서는 같은 객체를 가리키는지 여부**가 중요하다.

```
기본형 → 값 자체를 복사  
참조형 → 객체를 가리키는 참조값을 복사
```