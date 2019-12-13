package com.newlifebegins.newlifebegins.repository.es;

import com.newlifebegins.newlifebegins.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * EsBlogRepositoryTest  接口测试
 * @auth wangwei
 * @time 2019/12/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
    @Autowired
    private EsBlogRepository esBlogRepository;
    @Before
    public void initRepositoryData() {
        // 清楚所有数据
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("登鹳雀楼","王之涣的登鹳雀楼","白日依山尽，黄河入海流。欲穷千里目，更上一层楼。"));
        esBlogRepository.save(new EsBlog("相思","王维的相思","红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));
        esBlogRepository.save(new EsBlog("静夜思","李白的静夜思","床前明月光，疑似地上霜。举头望明月，低头思故乡。"));
    }
    @Test
    public void testFindDistinctByTitleContainingOrSummaryContainingOrContentContaining() {

        Pageable pageable = PageRequest.of(0,20);
        String title = "思";
        String summary = "相思";
        String content = "相思";
        Page<EsBlog> page = esBlogRepository.findDistinctByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        System.out.println(page.getContent());
        for(EsBlog blog:page.getContent()) {
            System.out.println(blog.toString());
        }

    }

}
