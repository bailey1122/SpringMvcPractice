//package com.spr;
//
//import com.sprmvc.web.ch5.Spitter;
//import com.sprmvc.web.ch5.data.SpitterRepository;
//
//import com.sprmvc.web.ch5.webmvc.SpitterController;
//import org.junit.Test;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//public class SpitterTest {
//
//    @Test
//    public void testShowRegisterForm() throws Exception {
//        SpitterRepository mockRepository = mock(SpitterRepository.class);
//        SpitterController controller = new SpitterController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//
//        mockMvc.perform(get("/spitter/register"))
//                .andExpect(view().name("registerForm"));
//    }
//
//    @Test
//    public void shouldProcessRegistration() throws Exception {
//        SpitterRepository mockRepository = mock(SpitterRepository.class);
//        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "johnqwe@g.com");
//        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer", "johnqwe@g.com");
//        when(mockRepository.save(unsaved)).thenReturn(saved);
//        SpitterController controller = new SpitterController(mockRepository);
//
//        MockMvc mockMvc = standaloneSetup(controller).build();
//
//        mockMvc.perform(post("/spitter/register")
//            .param("firstName", "Jack")
//            .param("lastName", "Bauer")
//            .param("username", "jbauer")
//            .param("password", "24hours"))
//            .andExpect(redirectedUrl("/spitter/jbauer"));
//
////        verify(mockRepository, atLeastOnce()).save(unsaved);
//
//    }
//
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
