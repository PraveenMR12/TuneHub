package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository repo;
	
	@Override
	public void addSong(Songs song) {
		
		repo.save(song);
	}

	@Override
	public List<Songs> fetchAllSong() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean songExists(String name) {
		if(repo.findByName(name)==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void updateSong(Songs song) {

		repo.save(song);
	}

}
