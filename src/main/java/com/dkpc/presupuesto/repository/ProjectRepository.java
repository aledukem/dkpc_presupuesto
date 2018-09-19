package com.dkpc.presupuesto.repository;

import com.dkpc.presupuesto.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findById(Long projectId);

    List<Project> findByIdIn(List<Long> projectIds);

    long countByCreatedby(Long userId);
}
