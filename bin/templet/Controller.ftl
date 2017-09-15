package ${packageName}.controller.${modelName};

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import ${packageName}.controller.BaseController;
import ${packageName}.domain.${className};
import ${packageName}.service.${modelName}.${serviceName};
import ${packageName}.util.BeanUtil;
import ${packageName}.util.JsonUtil;
import ${packageName}.vo.req.${modelName}.${className}CreateReq;
//import ${packageName}.vo.req.${modelName}.${className}DeleteReq;
import ${packageName}.vo.req.${modelName}.${className}UpdateReq;

/**
 * @author ${author}
 * @version 1.0
 * @createDate：${createDate}
 */
 
@Controller
public class ${controllerName} extends BaseController{

	@Resource
	private ${serviceName} ${serviceVar};
	
	@RequestMapping(value="/${modelName}/${className}/create",method=RequestMethod.POST)
	@ResponseBody
	public JSON createLock(@RequestBody @Valid ${className}CreateReq req){
	    ${serviceVar}.save(req);
		return JsonUtil.newJson().toJson();
	}
	
	/*@RequestMapping(value="/${modelName}/${className}/delete",method=RequestMethod.POST)
	@ResponseBody
	public JSON deleteLock(@RequestBody @Valid ${className}DeleteReq req){
		return JsonUtil.newJson().addData("data", ${serviceVar}.delete(req.getId())).toJson();
	}
	
	@RequestMapping(value="/${modelName}/${className}/update",method=RequestMethod.POST)
	@ResponseBody
	public JSON updateLock(@RequestBody @Valid ${className}UpdateReq req){
		HashMap<String, Object> map=BeanUtil.transBean2Map(req);
		${serviceVar}.updateAccount(map);
		return JsonUtil.newJson().toJson();
	}*/
	
}
