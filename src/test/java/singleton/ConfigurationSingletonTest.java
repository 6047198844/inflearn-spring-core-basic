package singleton;

import com.example.inflearnspringcorebasic.AppConfig;
import com.example.inflearnspringcorebasic.member.MemberRepository;
import com.example.inflearnspringcorebasic.member.MemberServiceImpl;
import com.example.inflearnspringcorebasic.member.MemoryMemberRepository;
import com.example.inflearnspringcorebasic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        final MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        final OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        final MemoryMemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        final MemberRepository memberRepository1 = memberService.getMemberRepository();
        final MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("memberService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        final AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}