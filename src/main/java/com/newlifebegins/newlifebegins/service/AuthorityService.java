package com.newlifebegins.newlifebegins.service;


import com.newlifebegins.newlifebegins.domain.Authority;

/**
 * Authority 服务接口.
 * @auth wangwei
 * @time 2019/12/7
 */
public interface AuthorityService {
	 
	
	/**
	 * 根据id获取 Authority
	 * @param Authority
	 * @return
	 */
	Authority getAuthorityById(Long id);
}
