import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(filterName = "TimeCheck", urlPatterns = "*.do")
public class TimeCheckFilter implements Filter {
    //pre loading : 클라 요청없이 실행되는 영역, 생성자와 init
    //서블릿은 요청이 와야 생성인데 필터는 서버 키면 생성.(서블릿은 lazy loading)
    public TimeCheckFilter(){
        System.out.println("timecheck filter 생성");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 호출");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter 호출");
        HttpServletRequest request = (HttpServletRequest) servletRequest; //인자로 부모형이 오긴하지만 객체는 자식을 가져온다.(Http의 부모 Servlet)
        String uri = request.getRequestURI();
        System.out.println(uri);
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println(path);
        long startTime = System.currentTimeMillis();

        //doFilter가 서블릿을 실행하도록 함, 이거 전에는 사전처리를 필터에서 함.
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println(path+"요청처리에 든 시간"+ (endTime-startTime)+"ms초");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }
}
