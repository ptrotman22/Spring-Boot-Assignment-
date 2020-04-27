package com.example.Video_Game_Label.dao;

import java.util.List;

public interface VideoGameLabelDAO {
    //DAO Methods
    List<com.example.Video_Game_Label.entity.VideoGameLabel> findAll();
    com.example.Video_Game_Label.entity.VideoGameLabel findById(int theId);
    void save(com.example.Video_Game_Label.entity.VideoGameLabel theVideoGameLabel);
    void deleteById(int theId);
}
