/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Autorizacao;
import java.util.List;

/**
 *
 * @author VicNic
 */
public interface AutorizacaoDao {

    Autorizacao getAutorizacao(long id);

    List<Autorizacao> list();

    void remove(Autorizacao autorizacao);

    void save(Autorizacao autorizacao);

    void update(Autorizacao autorizacao);
    
}
