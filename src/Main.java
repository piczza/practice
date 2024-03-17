import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //빌터 패턴 사용해보기!====================================================================
        Student student = new StudentBuilder(2323)
                .name("김예지")
                .grade("공부하는단계")
                .build();

        System.out.println("빌더패턴 사용: " + student);

        //이너 클래스로 만든 빌터 패턴 사용해보기!=====================================================
        Student student1 = new Student.InnerBuilder()
                .id(23)
                .name("김예지23")
                .grade("공부하는단계234")
                .build();

        System.out.println("이너빌더패턴 사용: " + student1);

        //빌더패턴으로 객체 생성 단계 지연해보기!========================================================
        List<StudentBuilder> builders = new ArrayList<>();
        builders.add(
                new StudentBuilder(1)
                        .name("김예지1")
                        .grade("우와이게빌더패턴?하는단계")
        );

        builders.add(
                new StudentBuilder(2)
                        .name("김예지2")
                        .grade("빌더패턴 공부하는 단계")
        );

        builders.add(
                new StudentBuilder(3)
                        .name("김예지3")
                        .grade("빌더패턴으로 단계지연 해보는 단계")
        );

        for(StudentBuilder b : builders) {
            Student student2 = b.build();
            System.out.println("빌더패턴 단계지연 사용: " + student2);
        }
    }
}