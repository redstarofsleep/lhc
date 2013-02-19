
package lhc.webim.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * Class name:DateConverter
 * Description: please write your description
 * @author LuHaosheng
 */
public class DateConverter implements WebBindingInitializer {

	/**
	 * @see org.springframework.web.bind.support.WebBindingInitializer#initBinder(org.springframework.web.bind.WebDataBinder, org.springframework.web.context.request.WebRequest)
	 * Description: please write your description
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

}
