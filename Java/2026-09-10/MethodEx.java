class MyMethod {
    // (1) : 메소드 정의를 위한 기본 문법
    // 접근제한자 리턴형 메소드이름 ( 파라미터 ){ 코드 } 
    public int add( int x, int y ) {
       int result = x + y;
       // 메소드에 리턴값이 지정되어 있을 경우 "return" 문법을 사용하여 결과값을 넘겨줌
       return result;
    }

    // 뺄셈 기능을 하는 메소드 정의 + 호출 
    // 뺄셈 기능을 하는 메소드 정의
    public int minus( int x, int y ) {
        int result = x - y;
        return result;
    }

    // 실수의 덧셈을 위한 메소드 정의 + 호출
    // 실수의 덧셈 기능을 하는 메소드 정의
    public double add( double x, double y ) {
        double result = x + y;
        return result;
    }
}

public class MethodEx {
    public static void main (String[] args) {
        // (2) : 메소드 사용
        // 위에 만든 메소드를 사용 : 자바에서 메소드를 사용하려면 객체화 작업이 필요함
        // add() 메소드 메모리에 올려놓고 CPU에게 실행해줘 해야함
        // 메소드만 따로 메모리에 올릴수 없으니 클래스 전체를 올림
        // 그래서 add() 메소드가 포함되어있는 클래스를 MyMethod class를 통채로 메모리에 올림

        MyMethod m = new MyMethod(); // MyMethod 클래스를 메모리에 올리겠다, m이라는 변수에는 MyMethod 클래스의 주솟값이 들어감
        // new MyMethod() : MyMethod를 기반으로 객체를 생성한다
        // MyMethod m : MyMethod 객체를 참조하는 참조변수 m

        System.out.println("add : " + m.add( 10, 20 ));

        // 뺼셈 기능을 하는 메소드 호출
        System.out.println("minus : " + m.minus(20, 10)); // 이미 MyMethod라는 객체가 올라가서 다시 안올려도 됨

        // 실수의 덧셈을 하는 메소드 호출
        System.out.println("double : " + m.add(0.1, 0.2)); 
        // 0.3이 나와야하는데 0.30000000000000004 -> 실수는 완전히 이진수로 변경 안되는 경우가 있어서
    }
}