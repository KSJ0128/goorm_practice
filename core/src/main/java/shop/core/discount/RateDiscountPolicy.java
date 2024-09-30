package shop.core.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import shop.core.annotation.MainDiscountPolicy;
import shop.core.member.Grade;
import shop.core.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10; // 10% 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return price * discountPercent / 100;
        else
            return 0;
    }
}
