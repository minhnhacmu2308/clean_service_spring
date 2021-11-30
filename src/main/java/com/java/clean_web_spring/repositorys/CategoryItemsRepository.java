package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.CategoryItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface CategoryItemsRepository extends PagingAndSortingRepository<CategoryItems, Integer> {

    Page<CategoryItems> findAll(Pageable pageable);

    List<CategoryItems> findAll();

    CategoryItems findCategoryItemsById(int id);

    CategoryItems save(CategoryItems categoryItems);

    @Modifying
    @Transactional
    @Query(value = "Update category_items SET name = ?, description = ? , price = ?,image = ? WHERE id = ?",nativeQuery = true)
    int update(String name, String desciption , int cost, String image, int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM category_items WHERE id = ?",nativeQuery = true)
    int delete( int id);
}
