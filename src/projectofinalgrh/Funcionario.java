package projectofinalgrh;

import java.io.Serializable;
import java.util.ArrayList;


public class Funcionario implements Serializable{
    
    private int codigo;
    private double salario;
    private String nome;
    private String sexo;
    private String morada;
    private String habili;
    private String Departamento;
    private String nuit;
    private String profissao;
    private String bi;
    private String bancoNome;
    private int bancoConta;
    private String AnoContrato;
    private String contacto;
    private String categoria;
    private ArrayList <Presencas> pre ;
    double salario1;
    
    public Funcionario(){
    }
     public Funcionario(int codigo,double salari, String nome, String sexo, String morada, String habili, String departamento, String nuit, String profissao, String bi, String bancoNome,int bancoConta,String AnoContrato, String c, String categoria){
       
        this.codigo=codigo;
        salario=salari;
        this.nome=nome;
        this.sexo=sexo;
        this.morada=morada;
        this.habili=habili;
        this.Departamento=departamento;
        this.nuit=nuit;
        this.profissao=profissao;
        this.bi=bi;
        this.bancoNome=bancoNome;
        this.bancoConta=bancoConta;
        this.AnoContrato=AnoContrato;
        contacto=c;
        this.categoria=categoria;
        salario1=salario;
        
    }
    public ArrayList<Presencas> getPresencas(){ return pre;} 
    public String getContacto(){return contacto;} 
    public int getCodigo(){return this.codigo;}
    public double getSalario(){return this.salario;}
    public String getNome(){return this.nome;}
    public String getSexo(){return this.sexo;}
    public String getMorada(){return this.morada;}
    public String getHabili(){return this.habili;}
    public String getDepartamento(){return this.Departamento;}
    public String getNuit(){return this.nuit;}
    public String getProfissao(){return this.profissao;}
    public String getBi(){return this.bi;}
    public String getBancoNome(){return this.bancoNome;}
    public int getBancoConta(){return this.bancoConta;}
    public String getAnoContrato(){return this.AnoContrato;}
    public String getCategoria() {return categoria;}
    
    public void setPresencas(ArrayList <Presencas> pp){this.pre = pp;}
    public void setCodigo(int c){this.codigo=c;}
    public void setSalario(double s){this.salario=s;}
    public void setNome(String n){this.nome=n;}
    public void setSexo(String ss){this.sexo=ss;}
    public void setMorada(String m){this.morada=m;}
    public void setHabili(String h){this.habili=h;}
    public void setDepartamento(String Dep){this.Departamento=Dep;}
    public void setNuit(String nuit){this.nuit=nuit;}
    public void setProfissao(String Profissao){this.profissao=Profissao;}
    public void setBi(String bi){this.bi=bi;}
    public void setBancoConta(int bC){this.bancoConta=bC;}
    public void setBancoNome(String bn){this.bancoNome=bn;}
    public void setAnoContrato(String Ano){this.AnoContrato=Ano;}
    public void setContacto(String c){contacto=c;}
    public void setCategoria(String categoria){this.categoria = categoria;}
}

