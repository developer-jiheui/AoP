package com.gdu.prj06.controller;

import com.gdu.prj06.dao.ContactDao;
import com.gdu.prj06.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/contact")
@RequiredArgsConstructor
@Controller
public class ContactController {

    private final ContactService contactService;

    //ContactController가 동작할 때 로그를 찍는 log
    //private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    @GetMapping(value = "/list.do")
    public String list(Model model) {
        model.addAttribute("contactList", contactService.getContactList());
        return "contact/list";
    }

    @GetMapping(value = "/detail.do")
    public String detail(@RequestParam(value = "contact-no", required = false, defaultValue = "0") int contactNo,
                         Model model) {
        model.addAttribute("contact", contactService.getContactByNo(contactNo));
        return "contact/detail";
    }

    @GetMapping(value = "/write.do")
    public String write() {
        return "contact/write";
    }

    @PostMapping(value = "/register.do")
    public void register(HttpServletRequest request, HttpServletResponse response) {
        contactService.registerContact(request, response);
    }

    @GetMapping(value = "/remove.do")
    public void removeGet(HttpServletRequest request, HttpServletResponse response) {
        contactService.removeContact(request, response);
    }

    @PostMapping(value = "/remove.do")
    public void removePost(HttpServletRequest request, HttpServletResponse response) {
        contactService.removeContact(request, response);
    }


    @PostMapping(value = "/modify.do")
    public void modify(HttpServletRequest request, HttpServletResponse response) {
        contactService.modifyContact(request, response);
    }


}
