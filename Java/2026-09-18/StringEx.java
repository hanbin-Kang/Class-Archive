public class StringEx {

    public static void main(String[] args) {

        // ==================================================
        // (1) 문자열 객체 생성
        // ==================================================

        // ① new를 사용하는 방법
        // new를 사용하면 새로운 String 객체가 생성됨
        String str1 = new String("ABC");
        String str2 = new String("ABC");

        // str1과 str2는 서로 다른 String 객체를 참조함
        // 따라서 참조값도 서로 다름


        // ② 문자열 리터럴을 사용하는 방법
        // String Pool에서 같은 문자열이 존재하는지 확인
        // 존재하면 기존 객체를 재사용하고, 없으면 새로운 객체를 생성함
        String str3 = "ABC";
        String str4 = "ABC";

        // str3과 str4는 String Pool에 있는 같은 "ABC" 객체를 참조함


        // ==================================================
        // (2) 문자열 비교
        // ==================================================

        // == : 두 변수가 같은 객체를 참조하는지 비교
        // 문자열의 내용이 같은지를 비교하는 것이 아님
        if (str1 == str2) {
            System.out.println("str1과 str2는 같은 객체를 참조한다.");
        } else {
            System.out.println("str1과 str2는 다른 객체를 참조한다.");
        }
        // new를 사용하여 서로 다른 객체가 생성되었으므로 false


        // equals() : 두 String 객체의 문자열 내용이 같은지 비교
        if (str1.equals(str2)) {
            System.out.println("str1과 str2의 문자열 값이 같다.");
        } else {
            System.out.println("str1과 str2의 문자열 값이 다르다.");
        }
        // 두 객체의 문자열 내용이 모두 "ABC"이므로 true


        // 문자열 리터럴은 String Pool의 같은 객체를 참조할 수 있음
        System.out.println(str3 == str4);        // true
        System.out.println(str3.equals(str4));   // true


        // ==================================================
        // (3) String의 불변성(Immutable)
        // ==================================================

        String str5 = "ABC";

        // "ABC"라는 String 객체가 생성되고 str5가 해당 객체를 참조함
        // str5 ──→ "ABC"


        str5 = str5 + "D";

        // String 객체는 불변이므로 기존 "ABC"를 "ABCD"로 수정할 수 없음
        // 새로운 "ABCD" 객체를 생성하고 str5가 새로운 객체를 참조함
        //
        // "ABC"  ← 기존 객체
        // str5 ──→ "ABCD"


        str5 = str5 + "E";

        // 기존 "ABCD"를 수정하는 것이 아님
        // 새로운 "ABCDE" 객체를 생성하고 str5가 새로운 객체를 참조함
        //
        // "ABC"   ← 기존 객체
        // "ABCD"  ← 기존 객체
        // str5 ──→ "ABCDE"


        // String 객체는 한번 생성된 후 문자열 내용을 변경할 수 없음
        // 따라서 문자열을 빈번하게 변경하면 새로운 String 객체가 계속 생성될 수 있음
        //
        // 더 이상 참조되지 않는 객체는 Garbage Collector(GC)의 수거 대상이 됨
        // 이것을 메모리릭(memory leak)이라고 하지는 않음
        //
        // 문자열을 빈번하게 변경해야 하는 경우에는
        // StringBuilder 또는 StringBuffer를 사용하는 것이 적합함
    }
}