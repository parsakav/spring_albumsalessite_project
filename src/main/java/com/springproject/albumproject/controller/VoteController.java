package com.springproject.albumproject.controller;

import com.springproject.albumproject.model.Album;
import com.springproject.albumproject.model.User;
import com.springproject.albumproject.model.Vote;
import com.springproject.albumproject.service.AlbumService;
import com.springproject.albumproject.service.UserService;
import com.springproject.albumproject.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@Controller
@PreAuthorize("hasRole('USER')")
public class VoteController {
    @Autowired
   private AlbumService albumService;
    @Autowired
   private UserService userService;
    @Autowired
   private VoteService voteService;

    @RequestMapping("/vote")
    public String getVotePage(Model model) {
        model.addAttribute("albums",albumService.getAllAlbum());

        return "votealbum";
    }
@RequestMapping("/votesavetodb")
    public String addVoteToDb(Model model, @RequestParam String username, @RequestParam Long albumid) {
   User user= userService.findUserByUsername(username);
        Date uservdate= user.getLastvotedate();
    Date date = new Date(System.currentTimeMillis());

   if(uservdate==null || minusOldDateWithNow(date)>30) {
       System.out.println("Date is null");

       //SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");

user.setLastvotedate(date);
Album album=albumService.getAlbumById(albumid);
Vote vote = new Vote();

vote.setUser(user);
vote.setVoteDate(date);
vote.setAlbum(album);
userService.saveUser(user);
       System.out.println(user.getId());
  Vote t = voteService.saveVote(vote);
       System.out.println(t.getAlbum().getId());
   } else {
       model.addAttribute("error","Only monthly");
       return "error";
   }
        return "redirect:/";
    }
    public long minusOldDateWithNow(Date old) {
        Date now = new Date(System.currentTimeMillis());
        long diff = old.getTime() - now.getTime();

        long diffDays = diff / (24 * 60 * 60 * 1000);
return diffDays;
    }
}
