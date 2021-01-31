package com.sorteioapp.sorteioapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Sorteio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String numeroSorteado = geraNumero();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public String geraNumero() {

        List<Integer> numeros = new ArrayList<>();
        String sorteio = "";

        for (int i = 1; i <= 60; i++) numeros.add(i);
        Collections.shuffle(numeros);

        for (int j = 0; j < 6; j++) {

            if (j < 5) {
                sorteio += (numeros.get(j).toString()) + "-";
            } else {
                sorteio += (numeros.get(j).toString());
            }

        }
        return sorteio;
    }

    public String getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(String numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public Sorteio(long id, String numeroSorteado, User user) {
        this.id = id;
        this.numeroSorteado = numeroSorteado;
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sorteio() {
    }

    public Sorteio(String numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public Sorteio(User user) {
        this.user = user;
    }
}
