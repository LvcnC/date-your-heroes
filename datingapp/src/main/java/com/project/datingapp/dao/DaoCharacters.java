package com.project.datingapp.dao;

public class DaoCharacters {

    // dio cane
    // magari prendi solo l'id del personaggoi, e poi lo cerchi
    /* 
SELECT 
    character_interest.character_id as character_id,
    COUNT(character_interest.character_id) AS character_count  -- how often the name appears...
FROM 
    user_interest
INNER JOIN character_interest
    ON user_interest.interest_id = character_interest.interest_id
INNER JOIN users
    ON users.user_id = user_interest.user_id
INNER JOIN characters
    ON characters.character_id = character_interest.character_id
INNER JOIN interests
    ON interests.interest_id = user_interest.interest_id
WHERE 
    users.user_id = 1  -- Filter by the specific user (user_id = 1)
GROUP BY 
    characters.character_id   -- Group by user and character
ORDER BY 
	character_count DESC;*/

}
