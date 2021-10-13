package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    /*
    1. ModelAndView 반환 ->객체를 만들어서 속성 넣어줘야 함
    2. 문자열 리턴 -> Model을 받아서 하기 *
    -> 뷰의 논리적 이름, @Controller 일 때 작동, 뷰 리졸버
    3. void 인 경우 -> 컨트롤러의 매핑이 뷰의 경로와 같을 경우, (비추)
     */
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello!");
    }
}
