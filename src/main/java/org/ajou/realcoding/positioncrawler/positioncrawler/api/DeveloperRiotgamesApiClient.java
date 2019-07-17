package org.ajou.realcoding.positioncrawler.positioncrawler.api;

import org.ajou.realcoding.positioncrawler.positioncrawler.domain.EncryptedSummonerId;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.LeaguePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DeveloperRiotgamesApiClient {
    private final String appid = "RGAPI-fa3f76d0-89ae-436c-a84a-9347d6f5c2f9";
    private final String developerRiotgamesSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={appid}";
    private final String developerRiotgamesLeagueUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={appid}";

    @Autowired
    RestTemplate restTemplate;

    public EncryptedSummonerId requestEncryptedSummonerId (String summonerName) {
        return restTemplate.exchange(developerRiotgamesSummonerUrl, HttpMethod.GET, null, EncryptedSummonerId.class, summonerName, appid).getBody();
    }

    public List<LeaguePosition> requestLeaguePosition (String encryptedSummonerId) {
        return restTemplate.exchange(developerRiotgamesLeagueUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<LeaguePosition>>() {}, encryptedSummonerId, appid).getBody();
    }
}
