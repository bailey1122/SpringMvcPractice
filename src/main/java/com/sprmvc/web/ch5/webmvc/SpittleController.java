package com.sprmvc.web.ch5.webmvc;

import com.sprmvc.web.ch5.Spittle;
import com.sprmvc.web.ch5.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles2(Model model) {
//        model.addAttribute(spittleRepository.findSpittles(
//                Long.MAX_VALUE, 20));
//        return "spittles";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles1(Model model) {
//        model.addAttribute("spittleList",
//                spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value="max",
                    defaultValue=MAX_LONG_AS_STRING) long max,
            @RequestParam(value="count", defaultValue="20") int count) {
        return spittleRepository.findSpittles(max, count);

    }

//    @RequestMapping(value = "/show", method = RequestMethod.GET)
//    public String showSpittle(
//            @RequestParam(value = "spittle_id") long spittleid,
//            Model model) {
//        model.addAttribute(spittleRepository.findOne(spittleid));
//        return "spittle";
//    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
//            @PathVariable("spittleId") long spittleId,
            @PathVariable long spittleId,
            Model model) {
        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
        return "spittle";
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles(
//            @RequestParam("max") long max,
//            @RequestParam("count") int count) {
//        return spittleRepository.findSpittles(max, count);
//    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles3(Map map) {
//        map.put("spittleList",
//                spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles4() {
//        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//    }
}




















