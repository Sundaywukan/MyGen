package ${packageName}.service.${modelName};

import com.rongdu.azp.base.BaseService;
import ${packageName}.domain.${className};
import ${packageName}.vo.req.${modelName}.${className}CreateReq;

/**
 * @author ${author}
 * @version 1.0
 * @createDate：${createDate}
 */
public interface ${serviceName} extends BaseService<${className}> {
	/**
	 * @方法名:save
	 * @描述:保存
	 * @创建者:wuk
	 * @创建时间:${createDate}
	 * @参数:@param req
	 */
	 void save(${className}CreateReq req);
}
