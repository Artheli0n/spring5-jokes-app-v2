package spring.training.personal.jokesapp.controllers;

import spring.training.personal.jokesapp.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    public JokeController(final JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        // add a "joke" attribute to our Spring Model View Controller
        model.addAttribute("joke", jokeService.getJoke());

        // this tells spring to look to the templates folder for a file named "index.html"
        return "index";
    }
}
