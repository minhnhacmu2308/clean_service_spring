package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.CategoryItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface CategoryItemsRepository extends PagingAndSortingRepository<CategoryItems, Integer> {

    Page<CategoryItems> findAll(Pageable pageable);

    List<CategoryItems> findAll();

    CategoryItems findCategoryItemsById(int id);
}
