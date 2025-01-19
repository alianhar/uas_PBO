package com.uas.pbo.repository;

// import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uas.pbo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
