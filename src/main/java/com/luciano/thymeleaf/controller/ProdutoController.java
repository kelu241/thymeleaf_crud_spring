package com.luciano.thymeleaf.controller;

import com.luciano.thymeleaf.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProdutoController {

  private List<Produto> produtos = new ArrayList<Produto>();

  public ProdutoController() {

    Produto p1 = new Produto("ps5", Double.valueOf(24.24), Integer.valueOf(2026), LocalDate.of(2026, 2, 3));
    Produto p2 = new Produto("xbo one", Double.valueOf(54.24), Integer.valueOf(2026), LocalDate.of(2026, 2, 4));

    Produto p3 = new Produto("xbo one", Double.valueOf(54.24), Integer.valueOf(2026), LocalDate.of(2026, 2, 4));
    this.produtos.add(p1);
    this.produtos.add(p2);
    this.produtos.add(p3);
  }

  @GetMapping("/produtos")
  public ModelAndView listagem() {
    ModelAndView model = new ModelAndView("produtos/listagem");
    model.addObject("produtos", this.produtos);
    return model;
  }

  @DeleteMapping("/produtos/listagem/{id}")
  public String deletaProduto(@PathVariable String id) {
    Produto produtoRemover = this.produtos.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst()
        .orElse(null);

    if (produtoRemover != null) {
      this.produtos.remove(produtoRemover);
    }

    return "redirect:/produtos";
  }

  @GetMapping("/novo")
  public ModelAndView novo() {
    ModelAndView model = new ModelAndView("/produtos/form_produtos");
    Produto produto = new Produto();
    model.addObject(produto);
    return model;
  }

  @PostMapping("/adicionar")
  public String adicionarProduto(@ModelAttribute Produto produto) {

    if (produto != null)
      this.produtos.add(produto);
    return "redirect:/produtos";

  }

}
