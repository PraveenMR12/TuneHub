package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Songs;

public interface SongService {

	void addSong(Songs song);

	List<Songs> fetchAllSong();

	boolean songExists(String name);
	
	public void updateSong(Songs song);

}
