/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofinalgrh;

import java.io.Serializable;

public class Presencas implements Serializable {
    
    private String data;
    private String horaEntrada, horaSaida;
    private Funcionario func;

    public Presencas() {
    }
    public Presencas(String data, String horaEntrada,Funcionario fu) {
        this.data = data;
        this.horaEntrada = horaEntrada;
        func=fu;
    }
    public Presencas(String data, String horaEntrada,String horaSaida, Funcionario fu) {
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        func=fu;
    }

    public Funcionario getFunc() {return func;}
    public String getData() {return data;}
    public String getHoraEntrada() {return horaEntrada;}
    public String getHoraSaida() {return horaSaida;}

    public void setData(String data) {this.data = data;}
    public void setHoraEntrada(String horaEntrada) {this.horaEntrada = horaEntrada;}
    public void setHoraSaida(String horaSaida) {this.horaSaida = horaSaida;}
    public void setFunc(Funcionario func){this.func = func;}

}
