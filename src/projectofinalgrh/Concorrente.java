/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofinalgrh;

import java.io.Serializable;


public class Concorrente extends Funcionario implements Serializable {
    double nota1,nota2;
    String Resultado;

    public Concorrente() {
        super();
    }

    public Concorrente(double nota1, double nota2, int codigo, double salari, String nome, String sexo, String morada, String habili, String departamento, String nuit, String profissao, String bi, String bancoNome, int bancoConta, String AnoContrato, String c, String categoria) {
        super(codigo, salari, nome, sexo, morada, habili, departamento, nuit, profissao, bi, bancoNome, bancoConta, AnoContrato, c, categoria);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
      public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
    
    
    
    
}
