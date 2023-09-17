package com.bookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{
	
	@Query("SELECT b FROM BookEntity b WHERE (b.name LIKE %:keyword%) OR (b.author LIKE %:keyword%)")
	List<BookEntity> findAllByName(@Param("keyword") String keyword);
}
