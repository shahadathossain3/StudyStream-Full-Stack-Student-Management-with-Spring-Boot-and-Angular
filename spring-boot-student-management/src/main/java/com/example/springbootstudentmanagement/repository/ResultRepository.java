package com.example.springbootstudentmanagement.repository;

import com.example.springbootstudentmanagement.model.Result;
import com.example.springbootstudentmanagement.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {
    List<Result> findByStudentsId(Long id);

//    List<Students>
//    @Query("SELECT a " +
//        "FROM EntityA a " +
//        "JOIN EntityB b ON a.id = b.id " +
//        "JOIN EntityC c ON b.entityC.id = c.id " +
//        "WHERE c.entityD.id = :entityDId")
//    EntityA findByEntityDId(@Param("entityDId") Long entityDId);
}
