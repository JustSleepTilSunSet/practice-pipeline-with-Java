package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TestTable;

@Repository
@EnableJpaRepositories
public interface TestTableRepository extends JpaRepository<TestTable, Long> {
    List<TestTable> findAll();
    <S extends TestTable> S save(S entity);
    @Query(value = "SELECT max(id) FROM test_table",nativeQuery = true)
    public Long getMaxId();
}
