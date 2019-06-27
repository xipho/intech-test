package ru.xipho.riskhakov.intechtest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xipho.riskhakov.intechtest.dao.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
