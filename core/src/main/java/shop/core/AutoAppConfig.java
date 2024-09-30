package shop.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
//        basePackages = "shop.core.member", // 컴포넌트 스캔 시작 패키지 설정, 해당 패키지의 하위 패키지만 탐색
//        basePackageClasses = AutoAppConfig.class, // 해당 클래스의 패키지를 시작 패키지로 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
@Configuration
public class AutoAppConfig {

}
