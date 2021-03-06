package com.iurylemos.cursomc.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iurylemos.cursomc.dominio.Categoria;
import com.iurylemos.cursomc.repositorios.CategoriaRepositorio;
import com.iurylemos.cursomc.servicos.exceptions.ObjetoNotFountException;

@Service
public class CategoriaServico {
	//Operação capaz de buscar uma categoria por código.
	
	//Depedencia de quem puxa as informações do banco.
	//@Autowired essa dependência vai ser automaticamente instanciada pelo Spring
	//Pelo mecanismo de injeção de depedência ou inversão de controle.
	@Autowired
	private CategoriaRepositorio repo;
	
	public Categoria buscar(Integer id) {
		//Implementar um servico que busca uma categoria.
		//Busco o ID e retorno ele.
		//findOne, se o Id existe, ele retorna, se não é nulo.
		
		Categoria obj = repo.findOne(id);
		if(obj == null ) {
			//Lançando uma excessão caso esse ID não exista.
			throw new ObjetoNotFountException("O objeto não encontrado! Id:" +id
				+ ", Tipo: " +Categoria.class.getName());
		}
		return obj;
	}
	

}
