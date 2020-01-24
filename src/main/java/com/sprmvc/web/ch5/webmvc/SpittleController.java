//package com.sprmvc.web.ch5.webmvc;
//
//import com.sprmvc.web.ch5.Spitter;
//import com.sprmvc.web.ch5.Spittle;
//import com.sprmvc.web.ch5.data.SpittleRepository;
//import com.sprmvc.web.ch5.exc.DuplicateSpittleException;
//import com.sprmvc.web.ch5.exc.SpittleNotFoundException;
//import com.sprmvc.web.ch5.services.SpitterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//
//@Controller
//@RequestMapping("/spittles")
//public class SpittleController {
//
//    private SpittleRepository spittleRepository;
//
//    @Autowired
//    public SpittleController(SpittleRepository spittleRepository) {
//        this.spittleRepository = spittleRepository;
//    }
//
////    @RequestMapping(method = RequestMethod.GET)
////    public String spittles2(Model model) {
////        model.addAttribute(spittleRepository.findSpittles(
////                Long.MAX_VALUE, 20));
////        return "spittles";
////    }
//
////    @RequestMapping(method = RequestMethod.GET)
////    public String spittles1(Model model) {
////        model.addAttribute("spittleList",
////                spittleRepository.findSpittles(Long.MAX_VALUE, 20));
////        return "spittles";
////    }
//
//    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles(
//            @RequestParam(value="max",
//                    defaultValue=MAX_LONG_AS_STRING) long max,
//            @RequestParam(value="count", defaultValue="20") int count) {
//        return spittleRepository.findSpittles(max, count);
//    }
//
////    @RequestMapping(value = "/show", method = RequestMethod.GET)
////    public String showSpittle(
////            @RequestParam(value = "spittle_id") long spittleid,
////            Model model) {
////        model.addAttribute(spittleRepository.findOne(spittleid));
////        return "spittle";
////    }
//
//    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
//    public String spittle(
////            @PathVariable("spittleId") long spittleId,
//            @PathVariable long spittleId,
//            Model model) {
////        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
//        Spittle spittle = spittleRepository.findOne(spittleId);
//        if (spittle == null) {
//            throw new SpittleNotFoundException();
//        }
//        return "spittle";
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String saveSpittle(Spittle form, Model model) {
////        try {
//            spittleRepository.save(
//                new Spittle(form.getMessage(), new Date(),
//                        form.getLongitude(), form.getLatitude()));
//            return "redirect:/spittles";
////        } catch (DuplicateSpittleException e) {
////            return "error/duplicate";
////        }
//    }
//
//    @ExceptionHandler(DuplicateSpittleException.class)
//    public String handleDuplicateSpittle() {
//        return "error/duplicate";
//    }
//
//
////    @RequestMapping(method = RequestMethod.GET)
////    public List<Spittle> spittles(
////            @RequestParam("max") long max,
////            @RequestParam("count") int count) {
////        return spittleRepository.findSpittles(max, count);
////    }
//
//
////    @RequestMapping(method = RequestMethod.GET)
////    public String spittles3(Map map) {
////        map.put("spittleList",
////                spittleRepository.findSpittles(Long.MAX_VALUE, 20));
////        return "spittles";
////    }
//
////    @RequestMapping(method = RequestMethod.GET)
////    public List<Spittle> spittles4() {
////        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
////    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
