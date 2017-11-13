package ${packageName}.service;

import ${packageName}.base.BaseService;
import ${packageName}.domain.${className};
import ${packageName}.vo.${className}CreateReq;

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
