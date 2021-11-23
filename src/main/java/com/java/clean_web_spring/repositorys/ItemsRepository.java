package com.java.clean_web_spring.repositorys;

import com.java.clean_web_spring.domain.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
