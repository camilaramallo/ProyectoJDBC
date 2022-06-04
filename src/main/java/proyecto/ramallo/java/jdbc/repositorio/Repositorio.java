package proyecto.ramallo.java.jdbc.repositorio;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();


    T porID(Long id);

    void guardar(T t);

    void modificar(T t);

    void eliminar(Long id);
}
