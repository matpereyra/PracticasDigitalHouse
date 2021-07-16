package com.meli.linktracker.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.linktracker.DTOs.StoredLinkDTO;
import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LinkRepository implements ILinkRepository{

    private AtomicLong id;

    public LinkRepository() {
        this.id = new AtomicLong(0);
    }

    @Override
    public LinkResponseDTO createAndStore(String link, String linkID, String hash){
        /*
        todo: Guardo si no se encuentra ya ese id (dificil que haya colisiones, no lo chequeo).
         */
        LinkResponseDTO linkDTO = new LinkResponseDTO(id.getAndAdd(1), link, linkID);
        StoredLinkDTO storedLinkDTO = new StoredLinkDTO(linkDTO, hash);
        storeLink(storedLinkDTO);
        return linkDTO;
    }

    @Override
    public String getURL(String linkId) {
        List<StoredLinkDTO> links = loadDB();
        Optional<StoredLinkDTO> storedLink = null;
        try {
            storedLink = links.stream().filter(l -> l.getLinkID().equals(linkId)).findFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        storedLink.get().addCall();
        storeDB(links);
        return storedLink.get().getUrl();
    }

    private void storeDB(List<StoredLinkDTO> links) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/static/URLs.json");
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            objectMapper.writeValue(out, links);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getMetrics(String linkId) {
        return findFirst(linkId).getCalls();
    }

    public StoredLinkDTO findFirst(String linkId) {
        List<StoredLinkDTO> links = loadDB();
        Optional<StoredLinkDTO> storedLink = null;
        try {
            storedLink = links.stream().filter(l -> l.getLinkID().equals(linkId)).findFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storedLink.get();
    }


    private void storeLink(StoredLinkDTO storedLinkDTO) {
        List<StoredLinkDTO> links = loadDB();
        links.add(storedLinkDTO);
        storeDB(links);
    }

    private File openFile(String path) {
        File file = null;
        try{
            /* Con el "classpath:" busca en la carpeta resources... a veces */
            file = ResourceUtils.getFile("classpath:static/URLs.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return file;
    }

    private List<StoredLinkDTO> loadDB() {
        File file = null;
        try{
            /* Con el "classpath:" busca en la carpeta resources */
            file = ResourceUtils.getFile("src/main/resources/static/URLs.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return mapObject(file);
    }

    private List<StoredLinkDTO> mapObject(File file) {
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<StoredLinkDTO>> typeReference = new TypeReference<>(){};
        List<StoredLinkDTO> linkDTOs = null;
        try {
            linkDTOs = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }
        return linkDTOs;
    }

}
