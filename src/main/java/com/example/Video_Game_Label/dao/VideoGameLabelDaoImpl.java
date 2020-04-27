package com.example.Video_Game_Label.dao;

//IMPORTANT If your code is not working your imports might be incorrect
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VideoGameLabelDaoImpl implements VideoGameLabelDAO {

    //Define field for entity manager
    private EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public VideoGameLabelDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<com.example.Video_Game_Label.entity.VideoGameLabel> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<com.example.Video_Game_Label.entity.VideoGameLabel> myQuery = currentSession.createQuery("from VideoGameLabel");
        List<com.example.Video_Game_Label.entity.VideoGameLabel> videoGameLabels = myQuery.getResultList();
        return videoGameLabels;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public com.example.Video_Game_Label.entity.VideoGameLabel findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        com.example.Video_Game_Label.entity.VideoGameLabel theVideoGameLabel = currentSession.get(com.example.Video_Game_Label.entity.VideoGameLabel.class, theId);
        return theVideoGameLabel;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void save(com.example.Video_Game_Label.entity.VideoGameLabel theVideoGameLabel) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theVideoGameLabel);

    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<com.example.Video_Game_Label.entity.VideoGameLabel> theQuery = currentSession.createQuery("delete from VideoGameLabel where id=:VideoGameLabelId");
        theQuery.setParameter("VideoGameLabelId", theId);
        theQuery.executeUpdate();
    }
}
