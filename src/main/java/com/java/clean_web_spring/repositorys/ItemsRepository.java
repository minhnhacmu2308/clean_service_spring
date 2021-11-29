package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    List<Items> findItemsByCategoryItems(CategoryItems categoryItems);

    List<Items> findAll();

    Items save(Items items);

    @Modifying
    @Transactional
    @Query(value = "Update items SET name = ?, category_id = ? , price = ? WHERE id = ?",nativeQuery = true)
    int update(String name, int ct_id , int cost, int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM items WHERE id = ?",nativeQuery = true)
    int delete( int id);

    Items findItemsById(int id);
}
