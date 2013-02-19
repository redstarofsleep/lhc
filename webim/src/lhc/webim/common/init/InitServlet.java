package lhc.webim.common.init;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 9132548548300836605L;
	
	private static String contextPath = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String prefix = config.getServletContext().getRealPath("/");
		// Log4J
		String log4jFile = config.getInitParameter("log4j");
		String log4jConfigPath = prefix + log4jFile;
		PropertyConfigurator.configure(log4jConfigPath);
		
		contextPath = config.getServletContext().getRealPath("/");
	}
	
	public static String getContextPath() {
		return contextPath;
	}
}
