package com.ProvaRelacionamentosCritico.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProvaRelacionamentosCritico.Entities.AlunoEntities;
import com.ProvaRelacionamentosCritico.repository.AlunoRepository;

@Service
public class AlunoService {

	private final AlunoRepository alunoRepository;
	@Autowired

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	public  List<AlunoEntities> buscaTodosAluno(){
		return alunoRepository.findAll();
	}
	public AlunoEntities buscaAlunosId(Long id) {
		Optional <AlunoEntities> Alunos = alunoRepository.findById(id);
		return Alunos.orElse(null);
	}
	public AlunoEntities salvaAluno(AlunoEntities Aluno){
		return alunoRepository.save(Aluno);
	}
	public AlunoEntities alterarAluno(Long id, AlunoEntities alterarAlunos) {
		Optional <AlunoEntities> existeAlunos = alunoRepository.findById(id);
		if (existeAlunos.isPresent()) {
			alterarAlunos.setId(id);
			return alunoRepository.save(alterarAlunos);
		}
		return null;
	}
	public boolean apagarAlunos (Long id) {
		Optional <AlunoEntities> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
