package com.entor.springmvcdemo.controller;

import com.entor.springmvcdemo.domain.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    private String corr_name = "admin";
    private String corr_pass = "admin";

    @GetMapping("/index")
    public String index() {
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("idCard") String idCard,
                        @RequestParam("password") String password,
                        Model model,
                        HttpServletRequest request) {

        if (corr_name.equals(idCard) && corr_pass.equals(password)) {
            // 登录成功
            UserInfo user = new UserInfo();
            user.setUid(1);
            user.setName("姑姑");
            user.setIdCard(idCard);
            // model.addAttribute("user",user);// user -> user
            request.setAttribute("user", user);
            return "home";
        }
        return "login";
    }

    @PostMapping("/login2")
    public String login2(@ModelAttribute UserInfo user,
                         Model model,
                         HttpServletRequest request, HttpSession session) {

        if (corr_name.equals(user.getIdCard()) && corr_pass.equals(user.getPassword())) {
            // 登录成功
            user.setUid(1);
            user.setName("姑姑");
            // model.addAttribute("user",user);// user -> user
            request.setAttribute("user", user);
            session.setAttribute("user", user);
            return "home";
        }
        return "login";
    }

    @PostMapping("/login3")
    public String login3(@ModelAttribute UserInfo user, Model model, HttpSession session) {

        System.err.println(user.getCreateDate());
        if (corr_name.equals(user.getIdCard()) && corr_pass.equals(user.getPassword())) {
            // 登录成功
            user.setUid(1);
            user.setName("姑姑");
            session.setAttribute("user", user);
            model.addAttribute("user", user);// user -> user
            return "home";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(@SessionAttribute("user") UserInfo user, HttpSession session, RedirectAttributes redirectAttributes) {

        System.out.println(user);

        session.removeAttribute("user");

        redirectAttributes.addFlashAttribute("msg", "请登录...");

        return "redirect:index";
    }

    @PostMapping("/file")
    public String fileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile mf) throws Exception {
        System.out.println("file以外的表单数据name=" + name);
        if (!mf.isEmpty()) {
            byte[] buff = new byte[1024];
            InputStream is = mf.getInputStream();
            OutputStream os = new FileOutputStream("D:\\JSD1801\\upload\\" + mf.getOriginalFilename());
            int length;
            while ((length = is.read(buff)) != -1) {
                os.write(buff, 0, length);
            }
            os.flush();
            return "upload_success";
        }
        return "upload_failure";
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Integer id) {
        User user = new User();
        user.setUid(id);
        user.setName("老张");
        user.setIdCard("123321");
        user.setPassword("321");
        user.setCreateDate(new Date());
        return user;
    }

    @PostMapping("/put")
    @ResponseBody
    public User put(@RequestBody User user) {
        System.out.println(user.getCreateDate());
        user.setCreateDate(new Date());
        return user;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);// 设置解析非严格模式
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }
}
