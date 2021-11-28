package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.CategoryItems;
import com.java.clean_web_spring.domain.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    List<Items> findItemsByCategoryItems(CategoryItems categoryItems);
}
