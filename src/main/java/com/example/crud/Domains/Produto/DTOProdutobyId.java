package com.example.crud.Domains.Produto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOProdutobyId {
    private UUID id;
    private String nome;
    private float preco;
}
