package br.com.fiap.checkpoint1.dto;

import jakarta.validation.constraints.NotBlank;

public class PacienteCriacaoDTO {

    @NotBlank
    private String nome;
    
    @NotBlank
    private String endereco;
    
    @NotBlank
    private String bairro;
    
    private String email;
    private String telefoneCompleto;

    
    public PacienteCriacaoDTO() {
    }

    public PacienteCriacaoDTO(String nome, String endereco, String bairro, String email, String telefoneCompleto) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.email = email;
        this.telefoneCompleto = telefoneCompleto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneCompleto() {
        return telefoneCompleto;
    }

    public void setTelefoneCompleto(String telefoneCompleto) {
        this.telefoneCompleto = telefoneCompleto;
    }
}
