package shop.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.core.discount.DiscountPolicy;
import shop.core.discount.RateDiscountPolicy;
import shop.core.member.MemberRepository;
import shop.core.member.MemberService;
import shop.core.member.MemberServiceImpl;
import shop.core.member.MemoryMemberRepository;
import shop.core.order.OrderService;
import shop.core.order.OrderServiceImpl;

// 애플리케이션 내 실제 동작에 필요한 구현 객체 생성
// 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입(Injection)
// -> DI 컨테이너
// Configuration : 설정 정보라는 의미

// memberService 호출 시 -> MemoryMemberRepository() 생성
// orderService 호출 시 -> MemoryMemberRepository() 생성
// 싱글톤 유지 가능?

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 할인 정책 역할 담당하는 구현을 Fix -> Rate로 변경
//            return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
