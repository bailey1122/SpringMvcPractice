package com.sprmvc.web.ch5.webmvc;

import com.sprmvc.web.ch5.Spitter;
import com.sprmvc.web.ch5.Spittle;
import com.sprmvc.web.ch5.data.SpitterRepository;
import com.sprmvc.web.ch5.services.SpitterService;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository repository;

    @Autowired
    private SpitterService spitterService;

    @Autowired
    public SpitterController(SpitterRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/aa", method = RequestMethod.GET)
    public String showString(Model model) {
        model.addAttribute("a", spitterService.deleteSpittle(11));
        return "profile";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
//        model.addAttribute(new Spitter());
        model.addAttribute(new Spitter("john", "pass", "no", "no", "sd"));
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
//            @RequestPart("profilePicture") byte[] profilePicture,
            @RequestPart("profilePicture") MultipartFile profilePicture,
//            @RequestPart("profilePicture") Part profilePicture,
            @Valid Spitter spitter,
//            Model model,
            RedirectAttributes model,
            Errors errors) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        try {
            profilePicture.transferTo(
                    new File("/data/spittr/" + profilePicture.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repository.save(spitter);
//        return "redirect:/spitter/" + spitter.getUsername();
        model.addAttribute("username", spitter.getUsername());
//        model.addAttribute("spitterId", spitter.getId());
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable("username") String username,
            Model model) {
        if (!model.containsAttribute("spitter")) {
            model.addAttribute(
                    repository.findByUsername(username));
        }
        return "profile";
    }
}

























