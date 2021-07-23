package com.exam.dao;

import com.exam.entities.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Long> {
}
