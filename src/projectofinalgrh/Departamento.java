/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofinalgrh;

import java.io.Serializable;



public class Departamento implements Serializable {
     private int codigo;
    private String nome;

    public Departamento() {
    }
    public Departamento(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() { return codigo;}
    public String getNome() {return nome;}
    public void setCodigo(int codigo) { this.codigo = codigo;}
    public void setNome(String nome) {this.nome = nome;}
    
}
