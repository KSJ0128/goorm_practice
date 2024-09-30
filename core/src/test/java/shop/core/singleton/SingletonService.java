package shop.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    // 객체 조회
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 해 외부에서의 객체 생성을 막는다
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
