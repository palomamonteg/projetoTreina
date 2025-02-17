package com.agenda.app.repository;

import com.agenda.app.model.RedeSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeSocialRepository extends JpaRepository<RedeSocial, Long> {
    
}