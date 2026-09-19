# 1. String class - 자바에서 문자열 처리

`String class` : 자바에서 문자열을 저장하고 관리하기 위해 제공하는 클래스

---

## (1) 문자열 객체 생성

### ① 원칙적인 방법

```java
String str = new String("ABC");
```

`new`를 사용하여 새로운 `String` 객체를 생성한다.

```java
String str1 = new String("ABC");
String str2 = new String("ABC");
```

`new`를 사용하면 각각 새로운 객체가 생성되므로 `str1`과 `str2`는 서로 다른 객체를 참조한다.

```text
str1 ──→ [ "ABC" ]  ← 객체 1
str2 ──→ [ "ABC" ]  ← 객체 2
```

따라서:

```java
str1 == str2        // false
str1.equals(str2)   // true
```

---

### ② 간단한 방법 - 문자열 리터럴

```java
String str = "ABC";
```

`new`를 사용하지 않고 문자열 리터럴을 이용하여 `String` 객체를 생성할 수 있다.

문자열 리터럴은 **String Pool**에서 관리된다.

```java
String str1 = "ABC";
String str2 = "ABC";
```

`str2`를 생성할 때 String Pool에 `"ABC"`가 이미 존재하면 새로운 객체를 만들지 않고 기존 `"ABC"` 객체를 참조한다.

```text
str1 ──┐
       ├──→ [ "ABC" ]  ← 하나의 객체
str2 ──┘
```

따라서 이 경우:

```java
str1 == str2        // true
str1.equals(str2)   // true
```

---

### ※ 주의: String 변수에는 문자열 자체가 저장되는 것이 아님

```java
String str = "ABC";
```

`String`은 기본 자료형이 아니라 **참조형**이므로 `str`에는 문자열 객체 자체가 아니라 **그 객체를 참조하는 값(참조값)**이 저장된다.

```text
str ──→ [ String 객체 "ABC" ]
```

따라서 `==`와 `equals()`의 용도가 다르다.

```java
str1 == str2
```

→ 두 변수가 **같은 객체를 참조하는지** 비교

```java
str1.equals(str2)
```

→ 두 String 객체의 **문자열 내용이 같은지** 비교

### 문자열 내용 비교

```java
if (str1.equals(str2)) {
    System.out.println("문자열 값이 같다.");
}
```

String의 문자열 내용을 비교할 때는 `equals()`를 사용한다.

---

# (2) String의 불변성(Immutable)

`String` 객체는 **한번 생성된 후 그 값을 변경할 수 없다.**

예를 들어:

```java
String str = "ABC";
```

```text
str ──→ [ "ABC" ]
```

이후:

```java
str = str + "D";
```

기존 `"ABC"` 객체의 내용을 `"ABCD"`로 수정하는 것이 아니다.

`String`은 불변 객체이기 때문에 `"ABCD"`라는 **새로운 String 객체가 생성**되고 `str`이 새 객체를 참조하게 된다.

```text
기존
str ──→ [ "ABC" ]

변경 후

[ "ABC" ]       ← 기존 객체
     ↑
     └─ 그대로 존재

str ──→ [ "ABCD" ]  ← 새 객체
```

다시:

```java
str = str + "E";
```

이번에도 `"ABCD"`를 수정하는 것이 아니라 `"ABCDE"`라는 새로운 객체가 생성된다.

```text
[ "ABC" ]

[ "ABCD" ]

str ──→ [ "ABCDE" ]
```

즉, 문자열을 계속 변경하면 **기존 String 객체는 그대로 두고 새로운 String 객체가 계속 생성될 수 있다.**

---

# (3) String의 불변성이 중요한 이유

다음과 같이 문자열을 반복적으로 변경한다고 가정한다.

```java
String str = "ABC";

str = str + "D";
str = str + "E";
str = str + "F";
```

개념적으로는 다음과 같이 새로운 문자열 객체가 계속 만들어진다.

```text
"ABC"
  ↓
"ABCD"
  ↓
"ABCDE"
  ↓
"ABCDEF"
```

`str`이 마지막 객체를 참조하게 되면서 이전 객체 중 더 이상 참조되지 않는 객체는 **가비지 컬렉터(GC)의 대상**이 될 수 있다.

따라서 문자열을 **빈번하게 수정하거나 반복적으로 이어 붙이는 작업**이 많다면 비효율적일 수 있다.

> 단, 이것을 일반적으로 "메모리릭(memory leak)"이라고 하지는 않는다.
>
> 더 이상 참조되지 않는 객체는 가비지 컬렉터가 회수할 수 있기 때문이다.

---

# (4) StringBuffer / StringBuilder

문자열을 빈번하게 변경해야 하는 경우에는 `String` 대신 **StringBuilder** 또는 **StringBuffer**를 사용할 수 있다.

### String

```java
String str = "ABC";
str = str + "D";
str = str + "E";
```

→ 문자열 변경마다 새로운 String 객체가 만들어질 수 있음

### StringBuilder

```java
StringBuilder sb = new StringBuilder("ABC");

sb.append("D");
sb.append("E");
```

`StringBuilder`는 내부의 문자열을 수정하는 방식으로 동작하기 때문에 **반복적인 문자열 변경 작업에 적합하다.**

### StringBuffer

```java
StringBuffer sb = new StringBuffer("ABC");

sb.append("D");
sb.append("E");
```

`StringBuffer` 역시 문자열을 변경할 수 있으며, `StringBuilder`와 달리 **동기화(synchronized)를 지원**한다.

일반적인 단일 스레드 문자열 조작에서는 `StringBuilder`가 주로 사용된다.

---

# 핵심 정리

| 구분                  | 특징                          |
| ------------------- | --------------------------- |
| `String`            | 문자열을 저장하는 클래스               |
| `String` 변수         | String 객체를 참조하는 참조값을 저장     |
| `"ABC"`             | 문자열 리터럴                     |
| `String Pool`       | 문자열 리터럴을 관리하는 영역            |
| `new String("ABC")` | 새로운 String 객체 생성            |
| `==`                | 두 참조가 같은 객체를 가리키는지 비교       |
| `equals()`          | 문자열 내용이 같은지 비교              |
| `String`            | 불변(Immutable)               |
| `StringBuilder`     | 변경 가능한 문자열, 반복적인 문자열 조작에 적합 |
| `StringBuffer`      | 변경 가능한 문자열 + 동기화 지원         |

### 한 줄 핵심

**`String`은 참조형이며 불변 객체이므로, 문자열 내용을 비교할 때는 `equals()`, 문자열을 빈번하게 변경할 때는 `StringBuilder`/`StringBuffer`를 사용한다.**

# 2. 생성자 내 중복되는 코드 제거

### 생성자

자바에서 생략 가능한 것 3가지

* 메소드
* 멤버변수
* 생성자

### 생성자의 특징

* 메소드와 유사한 형태를 가짐
* 리턴형이 없음
* 생성자의 이름은 클래스 이름과 같아야 함
* 객체가 생성될 때 자동으로 호출됨

```java
new Test();
```

→ `Test` 객체가 생성되면서 생성자가 호출됨

생성자는 메소드처럼 직접 호출해서 재활용하는 목적이 아니라, **객체가 생성될 때 초기화 작업을 수행하기 위해 사용**한다.

### 생성자의 가장 큰 목적

생성자의 가장 큰 목적은 **멤버변수 초기화**이다.

* 멤버변수 : 클래스의 구성 요소 중 하나
* 클래스 전체에서 사용할 수 있는 변수

### 생성자 오버로딩

생성자는 오버로딩이 가능하다.

하나의 클래스 안에서 **동일한 이름의 생성자를 여러 개 정의**할 수 있다.

생성자의 이름은 모두 클래스 이름과 같기 때문에, 생성자를 구분하기 위해 **파라미터의 개수나 타입이 달라야 한다.**

```java
public Person() {
}

public Person(String name) {
}

public Person(String name, int age) {
}
```

### 생성자 오버로딩의 문제

멤버변수를 초기화하기 위해 생성자를 여러 개 만들다 보면 **생성자 내부에 동일한 초기화 코드가 반복**될 수 있다.

이러한 중복 코드를 제거하기 위해 자바에서는 `this()`를 제공한다.

---

# 3. `this()`와 `this`

### `this`

현재 객체를 가리킨다.

처음에는 클래스 내부에서 `this`가 보이면 **현재 클래스를 가리킨다**고 이해해도 된다.

```java
this.name
```

→ 현재 객체의 `name` 멤버변수를 의미한다.

### `this()`

현재 클래스의 **다른 생성자를 호출**한다.

생성자 내부에서 중복되는 초기화 코드를 제거하기 위해 사용한다.

```java
public Person() {
    this("김길동", 20);
}

public Person(String name, int age) {
    this.name = name;
    this.age = age;
}
```

`Person()` 생성자가 호출되면

→ `this("김길동", 20)` 실행
→ 같은 클래스의 `Person(String, int)` 생성자 호출
→ 실제 초기화 코드는 한 곳에서만 작성

즉, `this()`는 **생성자 간의 중복 코드를 줄이기 위한 용도**로 사용한다.

### 핵심

* `this` → 현재 객체를 가리킴
* `this()` → 현재 클래스의 다른 생성자를 호출
* 생성자 오버로딩으로 중복 코드가 생길 경우 `this()`로 하나의 생성자에 초기화 로직을 모을 수 있음
* `this()`는 반드시 **생성자의 첫 번째 문장**으로 작성해야 함
