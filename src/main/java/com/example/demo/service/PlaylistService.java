package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Playlist;

public interface PlaylistService {

	void addPlaylist(Playlist playlist);

	List<Playlist> fetchAllPlaylists();

}
