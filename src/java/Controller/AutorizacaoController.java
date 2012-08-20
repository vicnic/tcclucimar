/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.AutorizacaoDao;
import Dao.AutorizacaoDaoImp;
import Model.Autorizacao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author VicNic
 */
@ManagedBean
@SessionScoped
public class AutorizacaoController {
    private Autorizacao autorizacao;
    private DataModel listaAutorizacaos;

    public DataModel getListarAutorizacaos() {
        List<Autorizacao> lista = new AutorizacaoDaoImp().list();
        listaAutorizacaos = new ListDataModel(lista);
        return listaAutorizacaos;
    }

    public Autorizacao getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(Autorizacao autorizacao) {
        this.autorizacao = autorizacao;
    }

    public void prepararAdicionarAutorizacao(ActionEvent actionEvent){
        autorizacao = new Autorizacao();
    }

    public void prepararAlterarAutorizacao(ActionEvent actionEvent){
        autorizacao = (Autorizacao)(listaAutorizacaos.getRowData());
    }

    public String excluirAutorizacao(){

        Autorizacao autorizacaoTemp = (Autorizacao)(listaAutorizacaos.getRowData());
        AutorizacaoDao dao = new AutorizacaoDaoImp();
        dao.remove(autorizacaoTemp);
        return "index";

    }

    public void adicionarAutorizacao(ActionEvent actionEvent){

        AutorizacaoDao dao = new AutorizacaoDaoImp();
        dao.save(autorizacao);
        
    }

    public void alterarAutorizacao(ActionEvent actionEvent){

        AutorizacaoDao dao = new AutorizacaoDaoImp();
        dao.update(autorizacao);

    }

}

    

