package com.example.crud.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.crud.Domains.Produto.DTOProduto;
import com.example.crud.Domains.Produto.DTOProdutobyId;
import com.example.crud.Domains.Produto.Produto;
import com.example.crud.Domains.Produto.RepositoryProduto;

import lombok.var;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/produto")
public class ControllerProduto {
    @Autowired
    private RepositoryProduto repositoryProduto;

    @GetMapping
    public ResponseEntity getProduto() {
        var allprodutos = repositoryProduto.findAll();
        return ResponseEntity.ok(allprodutos);

    }

    @PostMapping
    public ResponseEntity postProduto(@RequestBody @Validated DTOProduto DTOProduto) {
        Produto newProduto = new Produto(DTOProduto);
        repositoryProduto.save(newProduto);
        return ResponseEntity.ok(newProduto);
    }

    @PutMapping("update")
    public ResponseEntity putProduto(@RequestBody @Validated DTOProdutobyId dtoProduto) {
        Produto newProduto = repositoryProduto.getReferenceById(dtoProduto.getId().toString());
        newProduto.setNome(dtoProduto.getNome());
        newProduto.setPreco(dtoProduto.getPreco());
        repositoryProduto.save(newProduto);
        return ResponseEntity.ok(newProduto);
    }

}
