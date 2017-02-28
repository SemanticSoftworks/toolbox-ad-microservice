package com.example.controllers;

import com.example.domain.Ad;
import com.example.model.AdDTO;
import com.example.service.AdService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by Teddy on 2017-02-08.
 */
@RestController
@RequestMapping("/ad")
public class AdController {
    @Autowired
    private AdService adService;

    @RequestMapping(value = "/search/{searchString}", method = RequestMethod.GET)
    public ResponseEntity<List<AdDTO>> search(@PathVariable String searchString){

        List<AdDTO> resultList = this.convertToAdDTOList(adService.searchAdWith(searchString));
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AdDTO> getAd(@PathVariable Long id){

        AdDTO ad = toDTO(adService.findAdById(id));
        if(ad == null){ return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes={"application/json"})
    public ResponseEntity<AdDTO> addAd(@RequestBody String adRecieved)
    {
        //System.out.println("adRecieved: " + adRecieved);
        AdDTO adDTO = new Gson().fromJson(adRecieved, AdDTO.class);
        if(adDTO == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ad ad = toAd(adDTO);
        ad.setDate(Calendar.getInstance());
        adService.addAd(ad);
        return new ResponseEntity<>(adDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/getpage/{pageNr}", method = RequestMethod.GET)
    public ResponseEntity<List<AdDTO>> getAllAds(@PathVariable int pageNr)
    {
        List<AdDTO> resultList = convertToAdDTOList(adService.getAllAds(pageNr));
        if(resultList == null || resultList.isEmpty()) { resultList = new ArrayList<>(); }
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    private List<Ad> convertToAdList(List<AdDTO> adList)
    {
        ArrayList<Ad> resultList = new ArrayList<Ad>();
        for(AdDTO ad : adList)
        {
            resultList.add(toAd(ad));
        }
        return resultList;
    }

    private List<AdDTO> convertToAdDTOList(List<Ad> adList)
    {
        ArrayList<AdDTO> resultList = new ArrayList<AdDTO>();
        for(Ad ad : adList)
        {
            resultList.add(toDTO(ad));
        }

        return resultList;
    }

    private AdDTO toDTO(Ad ad)
    {
        if(ad == null)
        {
            return null;
        }
        return new AdDTO(ad.getAdId(), ad.getUserId(), ad.getCategoryId(), ad.getTitle(), ad.getDescription(), ad.getDate(), ad.getPhotosIds());
    }

    private Ad toAd(AdDTO adDTO)
    {
        if(adDTO == null)
        {
            return null;
        }

        return new Ad(adDTO.getUser(), adDTO.getCategoryId(), adDTO.getTitle(), adDTO.getDescription(), adDTO.getDate(), adDTO.getPhotosId());
    }
}