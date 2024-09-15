package application.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.controller;
import org.springframework.ui.Model;
import org. springframework.web. bind. annotation.Requestmapping;
import org. springframework.web.bind. annotation.RequestMethod;
import org.springframework.web. bind. annotation.RequestParam;

import application.model.Genero;
import application.model.GeneroRepository;

@controller
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/list")
    public String list(Model model) {
    model.addAttribute("generos", generoRepo.findAll());
    return "/genero/list";
    }

    @RequestMapping("/insert")
    public String insert() {
    return "/genero/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.PosT)
    public String insert (@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);

        generoRepo.save(genero);

        return "redirect:/genero/list";

}
}