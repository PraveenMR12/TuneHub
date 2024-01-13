package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Songs;
import com.example.demo.service.PlaylistService;
import com.example.demo.service.SongService;


@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Songs> songList = songService.fetchAllSong();
		model.addAttribute("songs", songList);
		return "create_playlist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		//updating playlist
		playlistService.addPlaylist(playlist);
		
		System.out.println(playlist);
		
		//updating songs
		List<Songs> songList = playlist.getSongs();
		for(Songs s : songList) {
			s.getPlaylist().add(playlist);
			songService.updateSong(s);
		}
		return "admin_home";
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlaylist(Model model) {
		
		List<Playlist> playlistList = playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists", playlistList);
		return "display_playlist";
	}

}
