package com.rongdu.azp.service.zzzz;

import com.rongdu.azp.base.BaseService;
import com.rongdu.azp.domain.Zzzz;
import com.rongdu.azp.vo.req.zzzz.ZzzzCreateReq;

/**
 * @author wuk
 * @version 1.0
 * @createDate：2017.09.14 04:17
 */
public interface ZzzzService extends BaseService<Zzzz> {
	/**
	 * @方法名:save
	 * @描述:保存
	 * @创建者:wuk
	 * @创建时间:2017.09.14 04:17
	 * @参数:@param req
	 */
	 void save(ZzzzCreateReq req);
}
