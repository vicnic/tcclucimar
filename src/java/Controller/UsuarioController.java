package Controller;

import Dao.UsuarioDao;
import Dao.UsuarioDaoImp;
import Model.Usuario;
import Model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

    private Usuario usuario;    
    private DataModel listaUsuarios;

    public UsuarioController() {
        usuario = new Usuario();
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
                usuario.setUsername(((User)authentication.getPrincipal()).getUsername());
            }
        }
    }
 public DataModel getListarUsuarios() {
        List<Usuario> lista = new UsuarioDaoImp().list();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void prepararAdicionarUsuario(ActionEvent actionEvent){
        usuario = new Usuario();
    }

    public void prepararAlterarUsuario(ActionEvent actionEvent){
        usuario = (Usuario)(listaUsuarios.getRowData());
    }

    public String excluirUsuario(){

        Usuario usuarioTemp = (Usuario)(listaUsuarios.getRowData());
        UsuarioDao dao = new UsuarioDaoImp();
        dao.remove(usuarioTemp);
        return "index";

    }

    public void adicionarUsuario(ActionEvent actionEvent){

        UsuarioDao dao = new UsuarioDaoImp();
        dao.save(usuario);
        
    }

    public void alterarUsuario(ActionEvent actionEvent){

        UsuarioDao dao = new UsuarioDaoImp();
        dao.update(usuario);

    }
    
  

}
