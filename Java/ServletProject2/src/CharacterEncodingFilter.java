import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncoding", urlPatterns = "*.do", initParams = @WebInitParam(name="encoding",value = "euc-kr"))
public class CharacterEncodingFilter implements Filter {
    private String boardEncoding;

    //서블릿 엔진을 만들면 생성되고 init.
    public CharacterEncodingFilter() {
        System.out.println("characterENcoding filter 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        boardEncoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding(boardEncoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
