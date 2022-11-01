
package projectofinalgrh;

import java.io.Serializable;


public class Concurso implements Serializable {
    int codigo,quantidade;
    String NomeDep;

    public Concurso() {
    }

    public Concurso(int codigo, String NomeDep, int quantidade) {
        this.codigo = codigo;
        this.NomeDep = NomeDep;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeDep() {
        return NomeDep;
    }

    public void setNomeDep(String codigoDep) {
        this.NomeDep = codigoDep;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
