package com.example.Video_Game_Label.rest;

import com.example.Video_Game_Label.dao.VideoGameLabelDaoImpl;
import com.example.Video_Game_Label.entity.VideoGameLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is to allow calls from React... NOT IMPORTANT RIGHT NOW
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class VideoGameLabelController {


    private final VideoGameLabelDaoImpl videoGameLabelDaoimpl;

    //Constructor Injection: this is telling the spring framework to wire up your
    //dependencies for the employee DAO.
    @Autowired
    public VideoGameLabelController(VideoGameLabelDaoImpl videoGameLabelDaoimpl) {
        this.videoGameLabelDaoimpl = videoGameLabelDaoimpl;
    }

    //This is a GET request that will read a list of all the employees.
    //http://localhost:8080/retrieveAllVideoGameLabel
    @GetMapping("/retrieveAllVideoGameLabel")
    public List<VideoGameLabel> findAll() {
        return videoGameLabelDaoimpl.findAll();
    }

    //This is a POST request to add a new employee.
    //http://localhost:8080/addVideoGameLabel
    @PostMapping("/addVideoGameLabel")
    public VideoGameLabel addVideoGameLabel(@RequestBody VideoGameLabel theVideoGameLabel) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        theVideoGameLabel.setId(0);

        //This will call the employeeDqoImpl.save method to save a new employee
        videoGameLabelDaoimpl.save(theVideoGameLabel);
        return theVideoGameLabel;
    }

    //This is a PUT request to update an existing employee.
    //http://localhost:8080/updateVideoGameLabel
    @PutMapping("/updateVideoGameLabel")
    public VideoGameLabel updateVideoGameLabel(@RequestBody VideoGameLabel updateVideoGameLabel) {
        //No theEmployee.setId(0); this will execute an update instead of a create
        videoGameLabelDaoimpl.save(updateVideoGameLabel);
        return updateVideoGameLabel;
    }

    //This is a DELETE request to delete an existing employee.
    //http://localhost:8080/deleteVideoGameLabel/1
    @DeleteMapping("/deleteVideoGameLabel/{VideoGameLabelId}")
    public String deleteVideoGameLabel(@PathVariable int VideoGameLabelId) {

        //Creating a tempEmployee to check to see if an employee exists
        VideoGameLabel tempEmployee = videoGameLabelDaoimpl.findById(VideoGameLabelId);

        //This will throw an exception if the VideoGameLabel is null
        if(tempEmployee == null) {
            throw new RuntimeException("VideoGameLabel is not found : " + VideoGameLabelId);
        }

        //This will execute the deleteByID method in the employeeDaoImpl.
        videoGameLabelDaoimpl.deleteById(VideoGameLabelId);
        return "Deleted VideoGameLabel id : " + VideoGameLabelId;
    }

}
