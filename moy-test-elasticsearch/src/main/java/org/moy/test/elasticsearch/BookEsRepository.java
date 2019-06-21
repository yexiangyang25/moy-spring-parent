package org.moy.test.elasticsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description: [Book]</p>
 * Created on 2019/6/21
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Repository
public interface BookEsRepository extends ElasticsearchRepository<Book, String> {

    /**
     * 查询
     * @param name
     * @return
     */
    List<Book> findBooksByName(String name);


    /**
     * 分页查询
     * @param desc
     * @param pageable
     * @return
     */
    Page<List<Book>> findBooksByDescLike(String desc, Pageable pageable);
}
