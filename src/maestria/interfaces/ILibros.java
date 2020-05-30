package maestria.interfaces;

import java.util.Collection;

import maestria.DTO.LibrosDTO;

public interface ILibros {
	public boolean guardarLibro( String name,String año ,String autor ,String editorial );
	public boolean eliminarLibro(int id);
	public boolean editarLibro(int id, String name,String año ,String autor ,String editorial  );
	public Collection<LibrosDTO> buscarTodosLosLibros();
}
