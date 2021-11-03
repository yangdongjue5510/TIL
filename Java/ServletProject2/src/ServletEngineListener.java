import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ServletEngineListener implements ServletContextListener{
    public ServletEngineListener(){
        System.out.println("Listener 생성");
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("리스너 init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("리스너 destroy");
    }
}
