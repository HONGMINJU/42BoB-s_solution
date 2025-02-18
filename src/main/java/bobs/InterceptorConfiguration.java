package bobs;

import bobs.Interceptor.SessionInterceptor;
import bobs.PropInjector.PropInjectorImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionInterceptor())
				.addPathPatterns("/*")
				.excludePathPatterns("/login") //로그인 쪽은 예외처리를 한다.
				.excludePathPatterns("/42OAuth");

	}
}
