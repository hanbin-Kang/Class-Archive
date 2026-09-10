# Java 복습

## 1. 기본 자료형

Java의 기본 자료형(Primitive Type)은 첫 글자가 소문자로 시작한다.

```java
int x = 10;
```

`x`에는 `10`이라는 **값 자체가 저장**된다.

반면 배열 같은 참조형은:

```java
int[] x = {10, 20, 30};
```

`x`에 배열의 값이 그대로 들어가는 것이 아니라, **배열 객체를 가리키는 참조값**이 들어간다.

```text
x
│
│ 참조
▼
┌─────────────┐
│ 10  20  30  │
└─────────────┘
   배열 객체
```

그래서 기본 자료형과 참조형은 변수에 저장되는 방식이 다르다.

> 정확하게는 "주솟값"이라고 단순하게 외우기보다 **참조값(reference value)**이라고 이해하는 것이 좋다.

---

# 2. 제어문

프로그램의 흐름을 제어하기 위해 사용한다.

## if문

조건에 따라 실행할 코드를 결정한다.

```java
if (조건식) {

    // 조건식이 참일 경우

} else {

    // 조건식이 거짓일 경우

}
```

예:

```java
int age = 20;

if (age >= 20) {
    System.out.println("성인");
} else {
    System.out.println("미성년자");
}
```

---

# 3. 반복문

같은 코드가 반복해서 실행될 때 사용한다.

똑같은 코드를 여러 번 작성하지 않아도 되기 때문에 **중복되는 코드를 줄일 수 있다.**

```java
for (int i = 0; i < 10; i++) {

    // 반복할 코드

}
```

예:

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

`0`부터 `9`까지 출력된다.

### for문의 흐름

```text
초기식
  ↓
조건식 확인
  ↓
코드 실행
  ↓
증감식
  ↓
조건식 확인
  ↓
반복
```

---

# 4. Method(메서드)

Java에서는 Python의 `function`과 비슷한 개념을 **Method(메서드)**라고 부른다.

메서드는 특정 기능을 하나의 코드 덩어리로 만들어 놓고 필요할 때 호출해서 사용하는 것이다.

예를 들어:

```java
int add(int a, int b) {
    return a + b;
}
```

만들어 놓으면:

```java
add(10, 20);
add(30, 40);
```

처럼 여러 번 사용할 수 있다.

메서드를 사용하는 이유는 단순히 반복되는 코드를 없애는 것뿐만 아니라,

* 기능별로 코드를 나눌 수 있고
* 같은 기능을 여러 곳에서 사용할 수 있고
* 코드가 복잡해지는 것을 줄일 수 있기 때문이다.

> 반복되는 코드가 연속적으로 반복된다면 `for`, `while` 같은 반복문을 생각할 수 있고, 특정 기능을 묶어서 재사용하고 싶다면 메서드를 생각하면 된다.

---

# 5. 메서드 정의

메서드의 기본적인 형태는 다음과 같다.

```java
접근제한자 리턴형 메서드이름(파라미터) {
    // 실행할 코드
}
```

예:

```java
public int add(int a, int b) {
    return a + b;
}
```

각 부분을 보면:

```text
public
→ 접근제한자

int
→ 리턴형

add
→ 메서드 이름

(int a, int b)
→ 파라미터

{ ... }
→ 메서드가 실행할 코드
```

---

# 6. 접근 제한자

접근 제한자는 **해당 메서드나 변수에 어디에서 접근할 수 있는지**를 결정한다.

대표적으로 다음 4가지가 있다.

```text
public
protected
default
private
```

## public

다른 클래스에서도 접근할 수 있다.

```java
public void hello() {
    System.out.println("Hello");
}
```

## private

**해당 메서드가 선언된 클래스 내부에서만 접근할 수 있다.**

```java
private void secret() {
    System.out.println("비밀");
}
```

처음에는

```text
public  → 어디서든 접근 가능
private → 해당 클래스 내부에서만 접근 가능
```

정도로 이해하고 넘어가면 된다.

---

# 7. public class와 public method

`public`은 클래스에도 사용할 수 있고 메서드에도 사용할 수 있다.

```java
public class Student {

    public void study() {
        System.out.println("공부");
    }

    public void sleep() {
        System.out.println("잠");
    }
}
```

여기서

```text
public class Student
→ public 클래스

public void study()
→ public 메서드

public void sleep()
→ public 메서드
```

이다.

### public 클래스의 규칙

하나의 `.java` 파일에는 **public 최상위 클래스가 최대 하나**만 있을 수 있다.

그리고 public 클래스의 이름과 파일 이름이 같아야 한다.

```text
Student.java
     ↓
public class Student
```

반면 `public` 메서드는 여러 개 만들 수 있다.

```java
public void study() {
}

public void sleep() {
}

public void eat() {
}
```

따라서

> "Java에서 public은 하나만 사용할 수 있다."

가 아니라

> **"하나의 .java 파일에서 public 최상위 클래스는 최대 하나이고, 클래스 이름과 파일 이름이 같아야 한다."**

라고 이해한다.

---

# 8. 메서드는 클래스 밖에 만들 수 없다

Java에서는 메서드를 클래스 밖에 독립적으로 만들 수 없다.

```java
class Student {

    void study() {
        System.out.println("공부");
    }

}
```

`study()`는 `Student` 클래스에 속해 있다.

Java에서는 클래스 안에 필드와 메서드를 정의한다.

```text
class
│
├── 필드
│
└── 메서드
```

Java가 객체지향 언어이기 때문에 프로그램을 클래스와 객체를 중심으로 구성한다.

---

# 9. 리턴형

메서드를 실행한 뒤 **호출한 곳으로 어떤 값을 반환할 것인지**를 나타낸다.

```java
int add(int a, int b) {
    return a + b;
}
```

`add()`를 실행하면 `int` 값이 반환된다.

```java
int result = add(10, 20);
```

```text
result
  ↓
 30
```

반환형에는 기본 자료형뿐만 아니라 객체 타입도 사용할 수 있다.

```java
int getAge() {
    return 20;
}
```

```java
String getName() {
    return "한빈";
}
```

---

# 10. void

메서드가 **호출한 곳으로 값을 반환하지 않을 때** 사용한다.

```java
void printHello() {
    System.out.println("Hello");
}
```

호출하면:

```java
printHello();
```

`Hello`를 출력하고 끝난다.

`void`라고 해서 메서드가 아무것도 하지 않는다는 뜻은 아니다.

```java
void study() {
    System.out.println("공부합니다.");
}
```

```java
void attack() {
    hp -= 10;
}
```

처럼 어떤 행동을 수행할 수 있다.

정리하면:

```text
int, double, String 등
→ 값을 반환

void
→ 호출한 곳으로 값을 반환하지 않음
```

---

# 11. 메서드 이름

메서드 이름은 관례적으로 **첫 글자를 소문자**로 작성한다.

```java
add()
printHello()
getName()
calculateScore()
```

클래스 이름은 보통 첫 글자를 대문자로 작성한다.

```java
Student
Calculator
MyMethod
```

그래서:

```text
클래스 → Student
메서드 → study()
```

처럼 구분할 수 있다.

---

# 12. 파라미터

파라미터는 **메서드가 호출될 때 전달받을 값을 저장하는 변수**다.

```java
int add(int a, int b) {
    return a + b;
}
```

여기서:

```text
a
b
```

가 파라미터다.

호출할 때:

```java
add(10, 20);
```

`10`, `20`이라는 값이 전달된다.

Python에서 함수의 매개변수와 비슷한 개념이다.

---

# 13. Java 프로그램과 .class 파일

Java 코드는 보통 `.java` 파일에 작성한다.

```text
MyMethod.java
```

이 소스 코드를 컴파일하면:

```text
MyMethod.java
      ↓ 컴파일
MyMethod.class
```

`.class` 파일이 만들어진다.

`.class` 파일에는 **JVM이 실행할 수 있는 바이트코드**가 들어 있다.

프로그램을 실행하면 JVM이 `.class` 파일을 읽고 필요한 클래스 정보를 메모리에 로드한다.

```text
.java
  ↓
컴파일
  ↓
.class
  ↓
JVM이 읽음
  ↓
메모리에 클래스 정보 로드
  ↓
프로그램 실행
```

여기서 중요한 것은:

> **JVM이 `.class` 파일을 읽어서 실행한다.**

이지, `.class` 파일을 읽는 것을 "인코딩"이라고 하는 것은 아니다.

---

# 14. 클래스와 객체

클래스와 객체는 구분해야 한다.

```java
class Student {

    int age;

    void study() {
        System.out.println("공부");
    }
}
```

`Student`는 클래스다.

```java
Student s = new Student();
```

여기서:

```text
Student
→ 클래스

new Student()
→ 객체 생성

s
→ 객체를 참조하는 참조변수
```

개념적으로 보면:

```text
Student 클래스
      │
      │ new
      ↓
Student 객체
      ▲
      │
      s
```

즉,

> 클래스 = 객체를 만들기 위한 정의

> 객체 = 클래스를 바탕으로 실제 만들어진 것

이라고 이해한다.

그리고 **메모리에 로드된 클래스 자체가 객체인 것은 아니다.**

---

# 15. Method Overloading

메서드 오버로딩은 **하나의 클래스에서 같은 이름의 메서드를 여러 개 정의하는 것**이다.

단, 매개변수의 **개수나 타입이 달라야 한다.**

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

이 세 메서드는 이름은 모두 `add`이지만 매개변수가 다르다.

```text
add(int, int)
add(double, double)
add(int, int, int)
```

Java는 메서드를 호출할 때 전달되는 인자의 타입과 개수 등을 보고 어떤 `add()`를 사용할지 결정한다.

---

## 오버로딩을 사용하는 이유

같은 종류의 일을 하는 메서드라면 **매개변수가 달라도 같은 이름을 사용하는 것이 더 이해하기 쉽기 때문**이다.

오버로딩이 없다면:

```text
addInt()
addDouble()
addThreeNumbers()
```

처럼 이름을 각각 다르게 만들어야 할 수 있다.

오버로딩을 사용하면:

```text
add(int, int)
add(double, double)
add(int, int, int)
```

처럼 모두 `add()`라는 이름을 사용할 수 있다.

대표적인 예가 `println()`이다.

```java
System.out.println(10);
System.out.println(3.14);
System.out.println("Hello");
System.out.println(true);
```

`println()`도 다양한 타입의 값을 처리할 수 있도록 여러 형태가 제공된다.

### 주의

반환형만 다른 것은 오버로딩이 아니다.

```java
int add(int a, int b) {
    return a + b;
}

double add(int a, int b) {
    return a + b;
}
```

이렇게 **매개변수는 똑같고 반환형만 다른 경우는 오버로딩할 수 없다.**

---

# 정리

```text
기본 자료형
→ 값 자체를 저장

참조형
→ 객체를 가리키는 참조값을 저장


if
→ 조건에 따라 실행


for
→ 반복되는 작업을 반복


메서드
→ 특정 기능을 묶어 재사용


void
→ 값을 반환하지 않는 메서드


public
→ 접근 제한자


public class
→ 하나의 .java 파일에 최상위 클래스 최대 하나
→ 파일 이름과 클래스 이름이 같아야 함


.class
→ 컴파일된 바이트코드
→ JVM이 읽어서 실행


class
→ 객체의 구조와 동작을 정의


new
→ 객체 생성


참조변수
→ 객체를 참조


오버로딩
→ 같은 이름 + 다른 매개변수
```
