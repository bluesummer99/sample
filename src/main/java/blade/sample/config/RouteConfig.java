package blade.sample.config;

import blade.sample.controller.NormalController;
import com.blade.config.BaseConfig;
import com.blade.config.Configuration;
import com.blade.ioc.annotation.Component;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.view.ViewSettings;
import com.blade.mvc.view.template.VelocityTemplateEngine;

import static com.blade.Blade.$;

@Component
public class RouteConfig implements BaseConfig {

	@Override
	public void config(Configuration configuration) {
		// 配置模板引擎
		ViewSettings.$().templateEngine(new VelocityTemplateEngine());
		
		// 函数式路由
		$().route("/hello", NormalController.class, "hello");
		$().route("/save_user", NormalController.class, "post:saveUser");
		$().route("/delete_user", NormalController.class, "deleteUser", HttpMethod.DELETE);
		
		// 回调式路由
		$().get("/get", (request, response)-> {
			System.out.println("come get!!!");
			System.out.println("name = " + request.query("name"));
			request.attribute("base", request.contextPath());
			response.render("get.vm");
		});
	}

}
