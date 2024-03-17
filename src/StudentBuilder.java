public class StudentBuilder {
    /*
        패턴화 하려는 클래스의 구성과 동일하게 필드 작성
    */
    private int id;
    private String name;
    private String grade;
    private String phoneNumber = "010-디폴트-폰번호"; //값을 넣어놓고 생성시 메서드를 호출하지 않으면 디폴트값 기능!

    public StudentBuilder(int id) { // 필수 멤버는 빌더의 생성자에 넣어서 강제로 필수 생성되도록 유도!
        this.id = id;
    }
    /*
        각 멤버에 대한 수정 메서드 생성. 이 때, 자기 자신을 반환해준다.
        반환되는 것은 StudentBuilder 객체다. 객체 자신을 반환함으로써 호출 뒤에 연속적으로 다른 메서드를 체이닝 할 수 있다.
    */
    public StudentBuilder name(String name) {
        this.name = name;
        return this;
    }
    public StudentBuilder grade(String grade) {
        this.grade = grade;
        return this;
    }
    /*
        매개변수에 대한 검증을 각 멤버별로 분리해 작성할 수 있다.
    */
    public StudentBuilder phoneNumber(String phoneNumber) {
        if (!phoneNumber.equals("010-디폴트-폰번호")) throw new IllegalArgumentException(phoneNumber);
        this.phoneNumber = phoneNumber;
        return this;
    }

    /*
        최종적으로 Student 객체를 만들어줄 build 메서드를 구현해준다.
        Student 생성자를 호출하는 방식이다.
    */
    public Student build() {
        return new Student(id, name, grade, phoneNumber);
    }
}
