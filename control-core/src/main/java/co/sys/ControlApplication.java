package co.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableWebFlux
@EnableTransactionManagement
@SpringBootApplication
public class ControlApplication extends SpringBootServletInitializer {

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(ControlApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(ControlApplication.class, args);
	}

//	@Configuration
//	static class WebMvcConfig implements WebMvcConfigurer {
//
//		@Override
//		public void addResourceHandlers(ResourceHandlerRegistry registry) {
//			registry
//					.addResourceHandler("/resources/templates/src/**")
//					.addResourceLocations("/resources/templates/src/","classpath:/resources/templates/")
//					.setCachePeriod(2400)
//					.resourceChain(true)
//					.addResolver(new PathResourceResolver());
//
//			registry
//					.addResourceHandler("/resources/gzip/**")
//					.addResourceLocations("file:/resources/gzip/","file:/opt/xc/gzip/")
//					.setCachePeriod(7200)
//					.resourceChain(true)
//					.addResolver(new GzipResourceResolver());
//
//		}
//
//	}
//
//	@Configuration
//	static class WebMvcConfigAdapt extends WebMvcConfigurerAdapter {
//
//		@Override
//		public void addViewControllers(ViewControllerRegistry registry) {
//			registry.addViewController("/resources/src/").setViewName("index");
//		}
//
//	}

}
