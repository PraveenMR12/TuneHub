package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.service.SongService;


@Controller
public class SongController {
	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Songs song) {
		boolean songStatus = service.songExists(song.getName());
		if(songStatus==false) {
			service.addSong(song);
			System.out.println("Song Added");
			return "admin_home";
		}else {
			System.out.println("Song with same name exists");
			return "new_song";
		}
		
	}
	
	@GetMapping("/viewSongs")
	public String viewSong(Model model) {
		
			List<Songs> songList = service.fetchAllSong();
			model.addAttribute("songs", songList);
			return "display_song";
		
		
	}
	
	
	

}
