package com.team.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
@Controller
public class HomeController {
    @GetMapping("/")
    public String get() throws IOException {
        System.out.println("Home ...");
      /*  model.addAttribute("files", fileStorageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(IzzyController.class, "serveFile",
                        path.getFileName().toString()).build().toString()).collect(Collectors.toList()
        ));*/
        return "uploadForm";
    }
}
