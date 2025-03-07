package com.project.datingapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.project.datingapp.entities.HistoryCharacter;

public class DaoCharacters {

    @Autowired
    private Database db;
    
    @Autowired
    private ApplicationContext context;

    
    private ArrayList<HistoryCharacter> swipeableCharacters;
    private ArrayList<Integer> usedCharacter;

    /*
    public ArrayList<HistoryCharacter> swipeableCharacters1(int idUser){
        
        // inizializziamo
        swipeableCharacters = new ArrayList<>();
        usedIndex = new ArrayList<>();

        String query ="SELECT character_interest.character_id\n" + //
                        "FROM user_interest\n" + //
                        "INNER JOIN character_interest ON user_interest.interest_id = character_interest.interest_id\n" + //
                        "INNER JOIN characters ON characters.character_id = character_interest.character_id\n" + //
                        "INNER JOIN users ON users.user_id = user_interest.user_id\n" + //
                        "WHERE users.user_id = ?\n";

        // return swipeable characters' ID as maps
        List<Map<String,String>> listCharactersId = db.rows(query, idUser  + "");
        
        HistoryCharacter character;

        // for every characters' ID in the list of characters
        for(Map<String,String> m : listCharactersId){
            
            int idCharacter = Integer.parseInt(m.get("character_id"));
            // save index
            usedIndex.add(idCharacter);

            // search for character with that ID
            character = searchForId(idCharacter);
            // and create it

            // then save the character found through its ID
            swipeableCharacters.add(character);

        }
        return swipeableCharacters;
    }
    */

    public ArrayList<HistoryCharacter> swipeableCharacters(int idUser){
        
        // inizializziamo
        swipeableCharacters = new ArrayList<>();
        usedCharacter = new ArrayList<>();

        String query ="SELECT    characters.character_id,\n" + //
                        "        characters.name,\n" + //
                        "        characters.surname,\n" + //
                        "        characters.username,\n" + //
                        "        characters.dob,\n" + //
                        "        characters.sex,\n" + //
                        "        characters.historical_period\n" + //
                        "FROM user_interest\n" + //
                        "INNER JOIN character_interest ON user_interest.interest_id = character_interest.interest_id\n" + //
                        "INNER JOIN characters ON characters.character_id = character_interest.character_id\n" + //
                        "INNER JOIN users ON users.user_id = user_interest.user_id\n" + //
                        "WHERE users.user_id = ?" +
                        "GROUP BY character_id";

        // return swipeable characters as MAPS
        List<Map<String,String>> listCharacters = db.rows(query, idUser  + "");
        
        HistoryCharacter character;

        // for every characters' ID in the list of characters
        for(Map<String,String> m : listCharacters){

            // save id character
            usedCharacter.add(Integer.parseInt(m.get("character_id")));

            // create the character with the mapp
            character = (HistoryCharacter) context.getBean("characterFromMap",m);

            // then save the character found through its ID
            swipeableCharacters.add(character);

        }
        return swipeableCharacters;
    }

    public HistoryCharacter searchForId(int idCharacter){

        String query = "SELECT * FROM characters WHERE character_id = ?";
        Map<String,String> map = new HashMap<>();

        map = db.row(query, idCharacter + "");
        
        HistoryCharacter character = (HistoryCharacter) context.getBean("characterFromMap", map);

        return character;
    }

    
}
