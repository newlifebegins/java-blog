package com.newlifebegins.newlifebegins.repository.es;

import com.newlifebegins.newlifebegins.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlogRepository 接口
 * @auth wangwei
 * @time 2019/12/5
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
    /**
     * 分页查询博客（去重）
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctByTitleContainingOrSummaryContainingOrContentContaining(String title,String summary,String content,Pageable pageable);
}
