package com.laowuandhisfriends.springmvc.controller;

import com.laowuandhisfriends.springmvc.entity.Spittle;
import com.laowuandhisfriends.springmvc.service.SpitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.laowuandhisfriends.springmvc.controller.HomeController.DEFAULT_SPITTLES_PER_PAGE;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration({"classpath:Spring-servlet.xml"})
@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
public class HomeControllerTest {

    @Resource
    private ApplicationContext context;

    @Test
    public void showHomePage() {
        List<Spittle> spittles = Arrays.asList(new Spittle(), new Spittle(), new Spittle());

        SpitterService spitterService = mock(SpitterService.class);
        when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).thenReturn(spittles);

        HomeController controller = new HomeController(spitterService);

        HashMap<String, Object> model = new HashMap<>();
        String viewName = controller.showHomePage(model);

        assertEquals("home", viewName);

        assertSame(spittles, model.get("spittles"));
        verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
    }
}