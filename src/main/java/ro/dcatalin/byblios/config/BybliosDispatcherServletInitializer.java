package ro.dcatalin.byblios.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BybliosDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		int i = 0;
		i=i++;
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { BybliosAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
