/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jose.macedo
 */
@Entity
public class Usuario implements Serializable {

    @Id
    private String username;
    private String password;
    @Column(name = "enable", columnDefinition = "BOOLEAN")
    private boolean enable;
    @OneToMany
    private List<Autorizacao> autorizacoes;

    public Usuario() {
    }

    public Usuario(String username, String password, boolean enable, List<Autorizacao> autorizacoes) {
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.autorizacoes = autorizacoes;
    }

    public List<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(List<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
