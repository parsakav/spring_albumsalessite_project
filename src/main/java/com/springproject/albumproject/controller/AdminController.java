package com.springproject.albumproject.controller;

import com.springproject.albumproject.model.Album;
import com.springproject.albumproject.model.Category;
import com.springproject.albumproject.model.Invoice;
import com.springproject.albumproject.model.Singer;
import com.springproject.albumproject.service.AlbumService;
import com.springproject.albumproject.service.CategoryService;
import com.springproject.albumproject.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
//@Secured(value = "ADMIN")
public class AdminController {
    private static String UPLOADED_FOLDER = "";
    @Autowired
   private SingerService singerService;
    @Autowired
   private AlbumService albumService;
    @Autowired
   private  CategoryService categoryService;
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage(Model model) {
        setSingerListForModel(model);
        return "admin";
    }


    @PreAuthorize("hasRole('ADMIN')")

    @RequestMapping(value = "/admin/addsingertodb", method = RequestMethod.POST)
    public String AdminAddSinger(@RequestParam String fname, @RequestParam String lname, @RequestParam String nickname, Model model) {
        try {
            Singer singer = new Singer();
            singer.setFname(fname);
            singer.setLname(lname);
            singer.setNickname(nickname);
            singerService.saveSinger(singer);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "/admin/addsinger";
        }
        return "redirect:/admin";
    }

    public void setSingerListForModel(Model model) {
        List<Singer> singerList = singerService.getAllSinger();
        if (singerList.size() != 0) {
            model.addAttribute("singers", singerList);
        }
    }

    public void setAlbumListForModel(Model model, int id) {
        Singer singer = singerService.getSingerById(Long.valueOf(id));
        Set<Album> albumList = singer.getAlbums();
        if (albumList.size() != 0) {
            model.addAttribute("albums", albumList);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/visitalbum")
    public String getAddSingerPage(@RequestParam Integer id, Model model) {

        model.addAttribute("singer_id", id);

        setAlbumListForModel(model, id);

        return "visitalbum";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/visitcategory")
    public String getCategoryPage(Model model) {

        model.addAttribute("categories", categoryService.getAllCategories());


        return "addcategory";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/addcategory")
    public String AdminAddCategory(Model model,@RequestParam String categoryname) {

Category category = new Category();
category.setName(categoryname);
categoryService.saveCategory(category);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "addcategory";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/topcategory")
    public String getTopCategoryPage(Model model) {

        model.addAttribute("categories", categoryService.getAllCategories());

        return "topcategory";
    }
  @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/topvote")
    public String getTopVotePage(Model model) {

        model.addAttribute("categories", categoryService.getAllCategories());

        return "topvote";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/addalbum")
    public String addAlbum(@RequestParam Long id, Model model) {

        model.addAttribute("categories",  categoryService.getAllCategories());
        model.addAttribute("singer_id",  id);

        int categorysize= categoryService.getAllCategories().size();
if(categorysize==0) {
    return "addcategory";
}
        return "addalbum";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/bestalbums")
    public String bestAlbums( Model model,@RequestParam String category) {
List<Album> la=albumService.getAllAlbum();
List<Album> sendList=new ArrayList<>();
for(Album al: la) {
    if(al.getCategory().getName().equalsIgnoreCase(category)) {
        sendList
                .add(al);
    }

}
        Comparator<Album> compareByInvoiceSize = new Comparator<Album>() {
            @Override
            public int compare(Album o1, Album o2) {
                return  o2.getCounter()-o1.getCounter();
            }
        };

        Collections.sort(sendList,compareByInvoiceSize);
        for(Album al: sendList) {
            int i = 0;
           for(Invoice in: al.getInvoices()){
             i+=in.getNumber();
           }
            al.setNumber(i);

        }

    model.addAttribute("albums",sendList);
        return "bestsellingalbum";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/bestvote")
    public String bestVote( Model model,@RequestParam String category) {
        List<Album> la=albumService.getAllAlbum();
        List<Album> sendList=new ArrayList<>();
        for(Album al: la) {
            if(al.getCategory().getName().equalsIgnoreCase(category)) {
                sendList
                        .add(al);
            }

        }
        Comparator<Album> compareByInvoiceSize = new Comparator<Album>() {
            @Override
            public int compare(Album o1, Album o2) {
                return  o2.getVote().size()-o1.getVote().size();
            }
        };

        Collections.sort(sendList,compareByInvoiceSize);
        for(Album al: sendList) {
            int i = 0;
            for(Invoice in: al.getInvoices()){
                i+=in.getNumber();
            }
            al.setNumber(i);

        }

        model.addAttribute("albums",sendList);
        return "bestvotingalbum";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/addalbumtodb")
    public String AdminAddAlbum(@RequestParam("file") MultipartFile file,
                                @RequestParam String category, @RequestParam Long id, Model model, @RequestParam String albumname, @RequestParam Long price, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")  Date albumdate) {
        //  model.addAttribute("singer_id", id);
        if(price <=0) {
            model.addAttribute("error","Price is :"+price);
            return "error";
        }
            Album al = new Album();
            al.setAlbumname(albumname);
            al.setAlbbumreleasedate(albumdate);

            al.setAlbumprice(price);
            al.setSinger(singerService.getSingerById(id));
            Category category1 = new Category();
            category1.setId(categoryService.getCategoryByName(category).getId());
            category1.setName(category);
            al.setCategory(category1);

            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Path p = Files.write(path, bytes);
                System.out.println(p.toUri().getPath());
                //     redirectAttributes.addFlashAttribute("message",
                //           "You successfully uploaded '" + file.getOriginalFilename() + "'");
                al.setAlbom_sam(p.toUri().getPath());
                albumService.saveAlbum(al);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:/admin";

    }
 @PreAuthorize("permitAll()")
    @RequestMapping(path = "/downloadalbumsampl", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(@RequestParam Long albumid) throws IOException {
        Album album = albumService.getAlbumById(albumid);

            File file = new File(album.getAlbom_sam());
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            return ResponseEntity.ok()
                    .headers(httpHeaders -> System.out.println(httpHeaders))
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resource);

    }
}
