package main.java.com.sprmvc.web.acontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners/{ownerId}")
public class OwnerController {

//    @GetMapping("/pets/{petId}")
//    public Pet findPet(@PathVariable Long ownerId, @PathVariable Long petId) {
//        // ...
//    }

    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+")
    public void handle(@PathVariable String version, @PathVariable String ext) {
        // ...
    }

//    @PostMapping(path = "/pets", consumes = "application/json")
//    public void addPet(@RequestBody Pet pet) {
//        // ...
//    }

    @GetMapping(path = "/pets/{petId}", params = "myParam=myValue")
    public void findPet2(@PathVariable String petId) {
        // ...
    }

    @GetMapping(path = "/pets", headers = "myHeader=myValue")
    public void findPet3(@PathVariable String petId) {
        // ...
    }
}
