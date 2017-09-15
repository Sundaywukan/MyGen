package com.rongdu.azp.service.impl.zzzz;

import com.rongdu.azp.domain.Zzzz;
import com.rongdu.azp.mapper.ZzzzMapper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongdu.azp.base.BaseMapper;
import com.rongdu.azp.base.BaseServiceImpl;
import com.rongdu.azp.service.zzzz.ZzzzService;
import com.rongdu.azp.vo.req.zzzz.ZzzzCreateReq;
import com.rongdu.azp.exception.BusinessException;
import com.rongdu.azp.constant.ResultMsg;
import com.rongdu.azp.util.BeanUtil;


/**
 * @author wuk
 * @version 1.0
 * @createDate：2017.09.14 04:17
 */
 @Service
public class ZzzzServiceImpl extends BaseServiceImpl<Zzzz> implements ZzzzService {
	
	@Resource
	private ZzzzMapper zzzzMapper;
	
	@Override
	public BaseMapper<Zzzz> getMapper() {
		return zzzzMapper;
	}
	
	@Override
	public void save(ZzzzCreateReq req) {
		Zzzz zzzz=new Zzzz();
		BeanUtil.copyProperties(zzzz, req);
		if(zzzzMapper.save(zzzz)!=1){
			throw new BusinessException(ResultMsg.SAVE_ERROR);
		}	
	}
}
