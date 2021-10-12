package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//@Component  // 빈에 등록
//@RequestMapping //핸들러 매핑

@Controller //그냥 이거 하나로 퉁침 내부에 @Component있음
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        System.out.println("springmvc memberform controller process");
        return new ModelAndView("new-form");
    }
}
