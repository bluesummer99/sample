package blade.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.blade.kit.json.JSONObject;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.multipart.FileItem;

import blade.sample.model.Person;

public class NormalController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NormalController.class);
	
	public void hello(Response response, Request request){
		LOGGER.info("进入hello~");
		request.attribute("name", "rose baby");
		response.text("hi");
	}
	
	public void saveUser(Request request, Response response){
		System.out.println("进入saveUser~");
		
		// test request.model()
		Person person = request.model("person", Person.class);
		System.out.println(person);
		
		// save操作
		JSONObject res = new JSONObject();
		res.put("status", 200);
		response.json(res);
	}
	
	public void deleteUser(Request request, Response response){
		System.out.println("进入deleteUser~");
		// delete操作
		JSONObject res = new JSONObject();
		res.put("status", 200);
		response.json(res);
	}
	
	public void saveImg(Request request, Response response){
		LOGGER.info("进入saveImg~");
		FileItem[] fileItems = request.files();
		if(null != fileItems && fileItems.length > 0){
			FileItem fileItem = fileItems[0];
			System.out.println(fileItem.fileName());
			System.out.println(fileItem.file());
		}
		
	}
}