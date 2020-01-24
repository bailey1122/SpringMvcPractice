package com.sprmvc.web.ch5.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprmvc.web.ch5.Profile;
import com.sprmvc.web.ch5.Spitter;
import com.sprmvc.web.ch5.Spittle;
import com.sprmvc.web.ch5.data.SpittleRepository;
import com.sprmvc.web.ch5.exc.SpitterExceptionRest;
import com.sprmvc.web.ch5.exc.SpittleNotFoundExceptionRest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.sprmvc.web.ch5.exc.Error;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
//@RestController
@RequestMapping("/spittles")
public class SpittleControllerApi {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleControllerApi(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml"})
    public @ResponseBody Spittle spittles(
            @RequestParam(value = "max",
                    defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findOne(22);
    }


//    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
//    public String spittle(
////            @PathVariable("spittleId") long spittleId,
//            @PathVariable long spittleId,
//            Model model) {
//        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
////        Spittle spittle = spittleRepository.findOne(spittleId);
////        if (spittle == null) {
////            throw new SpittleNotFoundException();
////        }
//        return "spittle";
//    }

//    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public @ResponseBody Spittle saveSpittle(@RequestBody Spittle spittle) {
//        return spittleRepository.save(spittle);
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Spittle> saveSpittle(@RequestBody Spittle spittle) {
        Spittle spittleR = spittleRepository.save(spittle);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = URI.create(
                "http://localhost:8080/SpringMvcPractice/spittles/" + spittle.getId());
//        ucb.path("/spittles/")
//                .path(String.valueOf(spittle.getId()))
//                .build()
//                .toUri();
//        headers.setLocation(locationUri);
        headers.setLocation(locationUri);

        ResponseEntity<Spittle> responseEntity =
                new ResponseEntity<Spittle>(
                        spittle, headers, HttpStatus.CREATED);
        return responseEntity;
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml"})
//    public @ResponseBody Spittle spittleById(@PathVariable long id) {
//        return spittleRepository.findOne(id);
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml"})
//    public ResponseEntity<Spittle> spittleById(@PathVariable long id) {
//        Spittle spittle = spittleRepository.findOne(id);
//        HttpStatus status = spittle != null ?
//                HttpStatus.OK : HttpStatus.NOT_FOUND;
//        return new ResponseEntity<>(spittle, status);
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml"})
//    public ResponseEntity<?> spittleById(@PathVariable long id) {
//        Spittle spittle = spittleRepository.findOne(id);
//        if (spittle == null) {
//            Error error = new Error(4, "Spittle [" + id + "] not found");
//            return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml"})
//    public ResponseEntity<Spittle> spittleById(@PathVariable long id) {
//        Spittle spittle = spittleRepository.findOne(id);
//        if (spittle == null) {
//            throw new SpittleNotFoundExceptionRest(id);
//        }
//        return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml"})
    public @ResponseBody Spittle spittleById(@PathVariable long id) {
        Spittle spittle = spittleRepository.findOne(id);
        if (spittle == null) {
            throw new SpittleNotFoundExceptionRest(id);
        }
        return spittle;
    }

    @ExceptionHandler (SpittleNotFoundExceptionRest.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error spittleNotFound(SpittleNotFoundExceptionRest e) {
        long spittleId = e.getSpittleId();
        return new Error(4, "Spittle [" + spittleId + "] not found");
    }

//    @ExceptionHandler (SpittleNotFoundExceptionRest.class)
//    public ResponseEntity<Error> spittleNotFound(SpittleNotFoundExceptionRest e) {
//        long spittleId = e.getSpittleId();
//        Error error = new Error(4, "Spittle [" + spittleId + "] not found");
//        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
//    }

//    public Profile fetchFacebookProfile(String id) {
//        try {
//            CloseableHttpClient client = HttpClients.createDefault();
//
//            HttpGet request = new HttpGet("http://graph.facebook.com/" + id);
//            request.setHeader("Accept", "application/json");
//
//            HttpResponse response = client.execute(request);
//
//            HttpEntity entity = response.getEntity();
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.readValue(entity.getContent(), Profile.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public Profile fetchFacebookProfile(String id) {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://graph.facebook.com/{spitter}",
                Profile.class, id);
    }

//    public Profile fetchFacebookProfile(String id) {
//        Map<String, String> urlVariables = new HashMap<String, String>();
//        urlVariables.put("id", id);
//        RestTemplate rest = new RestTemplate();
//        return rest.getForObject("http://graph.facebook.com/{spitter}",
//                Profile.class, id);
//    }

//    public Spittle fetchSpittle(long id) {
//        RestTemplate rest = new RestTemplate();
//        ResponseEntity<Spittle> response = rest.getForEntity(
//                "http://localhost:8080/SpringMvcPractice/spittles/{id}",
//                Spittle.class, id);
//        if (response.getStatusCode() == HttpStatus.NOT_MODIFIED) {
//            try {
//                throw new Exception();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return response.getBody();
//    }

    public void updateSpittle(Spittle spittle) throws SpitterExceptionRest {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/SpringMvcPractice/spittles/"
                + spittle.getId();
        rest.put(URI.create(url), spittle);
    }

//    public void updateSpittle(Spittle spittle) throws SpitterExceptionRest {
//        RestTemplate rest = new RestTemplate();
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("id", String.valueOf(spittle.getId()));
//        rest.put("http://localhost:8080/SpringMvcPractice/spittles/{id}",
//                spittle, params);
//    }

    public void deleteSpittle(long id) {
        RestTemplate rest = new RestTemplate();
        rest.delete("http://localhost:8080/SpringMvcPractice/spittles/{id}", id);
    }

    public Spitter postSpitterForObject(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        return rest.postForObject("http://localhost:8080/SpringMvcPractice/spittles/spitters",
                spitter, Spitter.class);
    }

//    public ResponseEntity<Spitter> postSpitterForObject(Spitter spitter) {
//        RestTemplate rest = new RestTemplate();
//        ResponseEntity<Spitter> response = rest.postForEntity(
//                "http://localhost:8080/SpringMvcPractice/spittles/spitters",
//                spitter, Spitter.class);
//        Spitter spitterR = response.getBody();
//        URI url = response.getHeaders().getLocation();
//        return response;
//    }

    public String postSpitter(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        return rest.postForLocation(
                "http://localhost:8080/SpringMvcPractice/spittles/spitters",
                spitter).toString();
    }


    public ResponseEntity<Spitter> useExchange(long spitterId) {
        RestTemplate rest = new RestTemplate();
//        ResponseEntity<Spitter> response = rest.exchange(
//                "http://localhost:8080/SpringMvcPractice/spittles/spitters/{spitter}",
//                HttpMethod.GET, null, Spitter.class, spitterId);
//        Spitter spitter = response.getBody();

        MultiValueMap<String, String> headers =
                new LinkedMultiValueMap<String, String>();
        headers.add("Accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        ResponseEntity<Spitter> response = rest.exchange(
                "http://localhost:8080/SpringMvcPractice/spittles/spitters/{spitter}",
                HttpMethod.GET, requestEntity, Spitter.class, spitterId);
        Spitter spitter = response.getBody();

        return response;
    }

}




















