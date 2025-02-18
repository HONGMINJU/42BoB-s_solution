package bobs.Interceptor;

import bobs.Dto.SessionDto;
import bobs.PropInjector.PropInjector;
import bobs.PropInjector.PropInjectorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

	private final PropInjector propInject;

	@Autowired
	public SessionInterceptor() {
		this.propInject = new PropInjectorImpl();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession httpSession = request.getSession();
		SessionDto sessionDto = (SessionDto)httpSession.getAttribute("session");

		System.out.println("------------session check start-------------");
		if (sessionDto == null)
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다')");
			out.println("</script>");
			response.sendRedirect(propInject.getBaseUrl() + "login");
		}
		System.out.println("------------session check end---------------");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
