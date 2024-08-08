package com.javaguide.Spring_Boot_Backend.Repository;

import com.javaguide.Spring_Boot_Backend.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

    @Query("SELECT b FROM Books b ORDER BY b.createdAt DESC")
    List<Books> findAllByOrderByCreatedAtDesc();

}
