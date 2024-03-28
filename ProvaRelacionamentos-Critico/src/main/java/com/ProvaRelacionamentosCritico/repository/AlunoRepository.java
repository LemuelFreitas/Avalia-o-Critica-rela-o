package com.ProvaRelacionamentosCritico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProvaRelacionamentosCritico.Entities.AlunoEntities;

public interface AlunoRepository extends JpaRepository<AlunoEntities,Long> {

}
