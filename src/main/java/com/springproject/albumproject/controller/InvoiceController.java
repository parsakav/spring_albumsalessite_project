package com.springproject.albumproject.controller;

import com.springproject.albumproject.model.Album;
import com.springproject.albumproject.model.Invoice;
import com.springproject.albumproject.model.User;
import com.springproject.albumproject.service.AlbumService;
import com.springproject.albumproject.service.InvoiceService;
import com.springproject.albumproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@PreAuthorize("hasRole('USER')")
public class InvoiceController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private InvoiceService invoicedService;
    @Autowired
    private UserService userService;
   private Set<Album> galbom = new HashSet<>();
    @RequestMapping("/test")
    public String buyAlbumPage( RedirectAttributes redirectAttributes,Model model, HttpServletRequest servletRequest) {


        List<Album> albums=albumService.getAllAlbum();

        Set<Album> albumList = new HashSet<>();
        for(Album al :albums) {
            if(servletRequest.getParameter(al.getId()+"")!=null) {
                albumList.add(al);
                galbom.add(al);
            }
        }
        if(albumList.size()!=0) {
            model.addAttribute("albums", albumList);
            redirectAttributes.addFlashAttribute("albumlist",albumList);
        } else {
            return "index";
        }
      /*  List<Invoice> list= invoicedService.getAllInvoice();
        System.out.println(list.get(1).getUser().getUsername());

            System.out.println(list.get(1).getAlbumSet().size());
*/
        return "buyalbum";
    }
    @RequestMapping("/buyalbum")
    public String getBuyAlbumPage() {
        return "buyalbum";
    }
  /*  @RequestMapping("/addinvoicetodb")
    public String addInvoice( @ModelAttribute("user") String username) {

    }*/
    @RequestMapping("/getinvoice")
    public String getInvoiced(@RequestParam String username,Model model, HttpServletRequest servletRequest) {
        System.out.println("s:"+galbom.size());
int number=0;
for(Album al: galbom) {
            Object param =servletRequest.getParameter(al.getId()+"");
            if(param!=null) {
                int num=Integer.parseInt((String) param);
                number+=num;
            al.setCounter(al.getCounter()+num);
            al.setNumber(num);
albumService.saveAlbum(al);
            }
        }
        Invoice invoice = new Invoice();
        User user= userService.findUserByUsername(username);
        invoice.setUser(user);
        if(number <=0) {
            model.addAttribute("error","number is :"+number);
            return "error";
        }
            invoice.setNumber(number);
            invoice.setAlbumSet(galbom);
            invoicedService.saveInvoice(invoice);
        galbom.clear();

        return "redirect:/";
    }

}
