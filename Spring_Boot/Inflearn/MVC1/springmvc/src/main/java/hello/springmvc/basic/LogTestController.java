package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //로그 선언을 해줌
@RestController
public class LogTestController {

    //slf4j 패키지의 Logger에 지금 클래스를 등록.(어노테이션이 대신해줌)
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        log.trace("trace={}", name);
        //log.trace("trace="+ name); 는 안됨!
        //연산이 들어가게 되면, 불필요한 리소스를 활용하게됨, 반면 파라미터로 전달해주면 불필요한 연산 없음.
        log.debug("debug={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("err log={}", name);
        return "ok";
    }
}
