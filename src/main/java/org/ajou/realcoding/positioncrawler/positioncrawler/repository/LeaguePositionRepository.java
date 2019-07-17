package org.ajou.realcoding.positioncrawler.positioncrawler.repository;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.LeaguePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class LeaguePositionRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertLeaguePosition(List<LeaguePosition> leaguePosition) {
        mongoTemplate.insert(leaguePosition, LeaguePosition.class);
    }

    public List<LeaguePosition> findLeaguePosition(String encryptedSummonerId) {
        List<LeaguePosition> leaguePositionList = mongoTemplate.find(Query.query(Criteria.where("summonerId").is(encryptedSummonerId)), LeaguePosition.class);
        return leaguePositionList;
    }

    public boolean isExistLeaguePosition(List<LeaguePosition> leaguePosition) {
        if (mongoTemplate.exists(Query.query(Criteria.where("summonerId").is(leaguePosition.get(0).getSummonerId())), LeaguePosition.class)) {
            return true;
        }
        return false;
    }
}
