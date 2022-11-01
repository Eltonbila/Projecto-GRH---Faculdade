
package projectofinalgrh;

import java.io.Serializable;


public class User implements Serializable {
    private int codigo;
    private String password,nome;

    public User() {
    }

    public User(int codigo, String password, String nome) {
        this.codigo = codigo;
        this.password = password;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
