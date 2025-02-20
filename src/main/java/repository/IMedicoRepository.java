package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import model.TblMedico;

public interface IMedicoRepository extends CrudRepository<TblMedico, Integer> {
	
	// Método para buscar productos cuyo nombre contenga el texto ingresado
	List<TblMedico> findByNombreContainingIgnoreCase(String nombre);

}

