public class Student {
    private int id;
    private String name;
    private String grade;
    private String phoneNumber;

    public Student(int id, String name, String grade, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student { " +
                "id='" + id + '\'' +
                ", name=" + name +
                ", grade=" + grade +
                ", phoneNumber=" + phoneNumber +
                " }";
    }

    /*
        내부 클래스로도 빌더 구현이 가능하다!
    */
    public static class InnerBuilder {
        private int id;
        private String name;
        private String grade;
        private String phoneNumber = "010-이것도-디폴트";

        public InnerBuilder id(int id) {
            this.id = id;
            return this;
        }

        public InnerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public InnerBuilder grade(String grade) {
            this.grade = grade;
            return this;
        }

        public InnerBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Student build() {
            return new Student(id, name, grade, phoneNumber);
        }

    }
    private Student(InnerBuilder innerBuilder){
        this.id = innerBuilder.id;
        this.name = innerBuilder.name;
        this.grade = innerBuilder.grade;
        this.phoneNumber = innerBuilder.phoneNumber;
    } //내부 이너클래스를 위한 생성자
}
