package com.rongdu.azp.controller.zzzz;

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
import com.rongdu.azp.controller.BaseController;
import com.rongdu.azp.domain.Zzzz;
import com.rongdu.azp.service.zzzz.ZzzzService;
import com.rongdu.azp.util.BeanUtil;
import com.rongdu.azp.util.JsonUtil;
import com.rongdu.azp.vo.req.zzzz.ZzzzCreateReq;
//import com.rongdu.azp.vo.req.zzzz.ZzzzDeleteReq;
import com.rongdu.azp.vo.req.zzzz.ZzzzUpdateReq;

/**
 * @author wuk
 * @version 1.0
 * @createDate：2017.09.14 04:17
 */
 
@Controller
public class ZzzzController extends BaseController{

	@Resource
	private ZzzzService zzzzService;
	
	@RequestMapping(value="/zzzz/Zzzz/create",method=RequestMethod.POST)
	@ResponseBody
	public JSON createLock(@RequestBody @Valid ZzzzCreateReq req){
	    zzzzService.save(req);
		return JsonUtil.newJson().toJson();
	}
	
	/*@RequestMapping(value="/zzzz/Zzzz/delete",method=RequestMethod.POST)
	@ResponseBody
	public JSON deleteLock(@RequestBody @Valid ZzzzDeleteReq req){
		return JsonUtil.newJson().addData("data", zzzzService.delete(req.getId())).toJson();
	}
	
	@RequestMapping(value="/zzzz/Zzzz/update",method=RequestMethod.POST)
	@ResponseBody
	public JSON updateLock(@RequestBody @Valid ZzzzUpdateReq req){
		HashMap<String, Object> map=BeanUtil.transBean2Map(req);
		zzzzService.updateAccount(map);
		return JsonUtil.newJson().toJson();
	}*/
	
}
