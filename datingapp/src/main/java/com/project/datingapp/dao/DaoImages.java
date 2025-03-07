package com.project.datingapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.project.datingapp.entities.Image;

public class DaoImages
{
    @Autowired
    private Database db = new Database();

    @Autowired
    private ApplicationContext context;

    public ArrayList<Image> getImages(int ownerId, String ownerType){

        List<Map<String,String>> listImages = new ArrayList<>();
        String query = "select *\n" + //
                        "from images\n" + //
                        "where owner_id = ?\n" + //
                        "\tand\n" + //
                        "\towner_type = ?";

        listImages = db.rows(query, ownerId + "", ownerType);

        ArrayList<Image> images = new ArrayList<>();
        Image im;
        for(Map<String,String> m : listImages){

            im = (Image) context.getBean("imageFromMap", m);

            images.add(im);
        }

        return images;
    }

}
