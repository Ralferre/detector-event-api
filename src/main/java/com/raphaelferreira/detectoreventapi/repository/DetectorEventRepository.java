package com.raphaelferreira.detectoreventapi.repository;

import com.raphaelferreira.detectoreventapi.controller.dto.DetectorEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DetectorEventRepository extends JpaRepository<DetectorEvent, String> {
    @Query("SELECT d FROM DetectorEvent d WHERE d.id = :id")
    DetectorEvent findByCustomId(@Param("id") String id);
    @Query("SELECT s FROM DetectorEvent s WHERE " +
            "s.id >= :idStart and s.id <= :idEnd " +
            "or s.name = :name " +
            "or s.regMax >= :regMaxStart and s.regMax <= :regMaxEnd " +
            "or s.createdOn >= :createdOnStart and s.createdOn <= :createdOnEnd")
    List<DetectorEvent> findByIdAndNameAndRegMaxAndCreationDate(
            String idStart,
            String idEnd,
            String name,
            Double regMaxStart,
            Double regMaxEnd,
            String createdOnStart,
            String createdOnEnd
    );
}
