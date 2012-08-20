/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuario;
import java.util.List;

/**
 *
 * @author VicNic
 */
public interface UsuarioDao {

    Usuario getUsuario(long id);

    List<Usuario> list();

    void remove(Usuario usuario);

    void save(Usuario usuario);

    void update(Usuario usuario);
    
}
