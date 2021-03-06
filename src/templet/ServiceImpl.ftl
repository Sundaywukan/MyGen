package ${packageName}.service.impl.${modelName};

import ${packageName}.domain.${className};
import ${packageName}.mapper.${mapperName};

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${packageName}.base.BaseMapper;
import ${packageName}.base.BaseServiceImpl;
import ${packageName}.service.${serviceName};
import ${packageName}.vo.req.${modelName}.${className}CreateReq;
import ${packageName}.exception.BusinessException;
import ${packageName}.constant.ResultMsg;
import ${packageName}.util.BeanUitl;


/**
 * @author ${author}
 * @version 1.0
 * @createDate：${createDate}
 */
 @Service
public class ${serviceImplName} extends BaseServiceImpl<${className}> implements ${serviceName} {
	
	@Resource
	private ${mapperName} ${mapperVar};
	
	@Override
	public BaseMapper<${className}> getMapper() {
		return ${mapperVar};
	}
	
	@Override
	public void save(${className}CreateReq req) {
		${className} ${classVar}=new ${className}();
		BeanUitl.copyProperties(${classVar}, req);
		if(${mapperVar}.save(${classVar})!=1){
			throw new BusinessException(ResultMsg.SAVE_ERROR);
		}	
	}
}
