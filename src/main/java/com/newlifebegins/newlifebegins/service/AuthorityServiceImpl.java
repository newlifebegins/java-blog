
package com.newlifebegins.newlifebegins.service;


import com.newlifebegins.newlifebegins.domain.Authority;
import com.newlifebegins.newlifebegins.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Authority 服务.
 * @auth wangwei
 * @time 2019/12/7
 */
@Service
public class AuthorityServiceImpl  implements AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(Long id) {
		Optional<Authority> optional = authorityRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

}
