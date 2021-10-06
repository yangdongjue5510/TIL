package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    //서블릿이랑 비슷한 모양의 인터페이스를 만들어주자!
    void process(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException;
}
