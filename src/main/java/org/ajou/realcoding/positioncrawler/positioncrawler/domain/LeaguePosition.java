package org.ajou.realcoding.positioncrawler.positioncrawler.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LeaguePosition {
    private String queueType;
    private String summonerName;
    private boolean hotStreak;

    private int wins;
    private boolean veteran;
    private int losses;

    private String tier;
    private String summonerId;
    private int leaguePoints;


}