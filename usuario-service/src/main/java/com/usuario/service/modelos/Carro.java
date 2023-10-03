package com.usuario.service.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Carro {
    @Getter @Setter
    private String marca;
    @Getter @Setter
    private String modelo;
    @Getter @Setter
    private int usuarioId;
}
