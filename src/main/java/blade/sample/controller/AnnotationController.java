package blade.sample.controller;

import blade.sample.service.UserService;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.Controller;
import com.blade.mvc.annotation.PathParam;
import com.blade.mvc.annotation.QueryParam;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.http.Request;
import com.blade.mvc.view.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * web开发推荐的方式
 */
@Controller
public class AnnotationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationController.class);
	
	@Inject
	UserService userService;
	
	@Route(value = "post", method = HttpMethod.POST)
	public void post() {
		LOGGER.info("request POST");
	}
	
	@Route("users/:name")
	public String users(Request request, @PathParam String name) {
		LOGGER.info("request users");
		LOGGER.info("param name = {}", name);
		request.attribute("name", name);
		return "users";
	}
	
	@Route({"/", "index"})
	public ModelAndView index(ModelAndView mav, @QueryParam(required = false) String age) {
		LOGGER.info("request query age = {}", age);
		userService.sayHello();
		mav.add("name", "jack");
		mav.setView("index");
		return mav;
	}
	
}