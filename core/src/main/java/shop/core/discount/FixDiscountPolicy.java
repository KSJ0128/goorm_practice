package shop.core.discount;

import org.springframework.stereotype.Component;
import shop.core.member.Grade;
import shop.core.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return discountFixAmount;
        else
            return 0;
    }
}
