package com.uped.proyecto.modelo;

import java.time.LocalDate;

public class Suscripcion {
    // 1. Declaramos los atributos como inmutables (final)
    private final String usuario;
    private final String plan;
    private final LocalDate inicio;
    private final int meses;

    // 2. Constructor privado que recibe el Builder
    private Suscripcion(Builder b) {
        this.usuario = b.usuario;
        this.plan = b.plan;
        this.inicio = b.inicio;
        this.meses = b.meses;
    }

    // 3. Clase estática Builder
    public static class Builder {
        // Atributo base
        private String usuario;

        // Valores por defecto asignados desde el inicio
        private String plan = "GRATIS";
        private LocalDate inicio = LocalDate.now();
        private int meses = 1;

        // Métodos de configuración encadenables
        public Builder usuario(String u) {
            this.usuario = u;
            return this;
        }

        public Builder plan(String p) {
            this.plan = p;
            return this;
        }

        public Builder inicio(LocalDate i) {
            this.inicio = i;
            return this;
        }

        public Builder meses(int m) {
            this.meses = m;
            return this;
        }

        // Metodo final que valida y construye el objeto
        public Suscripcion build() {
            if (meses <= 0) {
                throw new IllegalArgumentException(
                        "La cantidad de meses debe ser mayor a cero.");
            }
            if (usuario == null || usuario.isBlank()) {
                throw new IllegalArgumentException(
                        "El usuario es obligatorio.");
            }
            return new Suscripcion(this);
        }
    }

    @Override
    public String toString() {
        return "Suscripcion{usuario='" + usuario + "', plan='" + plan
                + "', inicio=" + inicio + ", meses=" + meses + "}";
    }
}