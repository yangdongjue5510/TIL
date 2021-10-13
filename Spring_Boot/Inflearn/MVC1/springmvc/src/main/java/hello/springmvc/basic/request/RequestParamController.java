package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    //서블릿을 활용한 방식
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
      String username = request.getParameter("username");
      int age = Integer.parseInt(request.getParameter("age"));
      log.info("{} {}", username, age);
      response.getWriter().write("ok");
    }

    //@RequestParam 사용하기
    @ResponseBody //반환값을 http 응답 메시지에 넣어서 반환!
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("{} {} ", memberName, memberAge);
        return "ok";
    }

    //@RequestParam 단축해서 사용하기
    @ResponseBody //반환값을 http 응답 메시지에 넣어서 반환!
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("{} {} ", memberName, memberAge);
        return "ok";
    }

    //아예 @RequestParam 빼버리기
    @ResponseBody //반환값을 http 응답 메시지에 넣어서 반환!
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String username,
            int age
    ){
        log.info("{} {} ", username, age);
        return "ok";
    }

    //파라미터 조건
    @ResponseBody //반환값을 http 응답 메시지에 넣어서 반환!
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,//이때 빈 문자열도 들어올 수 있 다 ..
            @RequestParam(required = false) Integer age//null이 들어올 수 있기 때문.
    ){
        log.info("{} {} ", username, age);
        return "ok";
    }

    //파라미터 기본값
    @ResponseBody //반환값을 http 응답 메시지에 넣어서 반환!
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, //빈 문자열이 오면 guest로 설정된다.
            @RequestParam(required = false, defaultValue = "-1") int age //null을 받을 일이 없어서 int로
    ){
        log.info("{} {} ", username, age);
        return "ok";
    }

    //파라미터를 맵으로 받기
    @ResponseBody //반환값을 http 응답 메시지에 넣어서 반환!
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap
    ){
        log.info("{} ", paramMap);
        return "ok";
    }

    //모델 어트리뷰트
    //그냥 모델 만들어서 파라미터 직접 넣기
    @ResponseBody
    @RequestMapping("/model-attribute")
    public String modelAttributeV1(@RequestParam String username, @RequestParam int age){
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);
        log.info("{} {}", username, age);
        return "ok";
    }

    //@ModelAttribute
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("{} {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    //@ModelAttribute 생략하기
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("{} {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
