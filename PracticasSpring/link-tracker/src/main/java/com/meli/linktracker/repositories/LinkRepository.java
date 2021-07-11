package com.meli.linktracker.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LinkRepository implements ILinkRepository{

    private AtomicLong counter;

    public LinkRepository() {
        this.counter = new AtomicLong(0);
    }

    @Override
    public LinkResponseDTO createAndStore(String link, String linkID){
        /*
        todo: Guardo si no se encuentra ya ese id (dificil que haya colisiones, no lo chequeo).
         */
        //List<LinkResponseDTO> linkDTOs = loadDB();
        LinkResponseDTO linkDTO = new LinkResponseDTO(counter.getAndAdd(1), link, linkID);
        storeLink(linkDTO);
        return linkDTO;
    }

    private void storeLink(LinkResponseDTO linkDTO) {
        List<LinkResponseDTO> links = loadDB();
        links.add(linkDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/static/URLs.json");
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            objectMapper.writeValue(out, links);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private List<LinkResponseDTO> loadDB() {
        File file = null;
        try{
            /* Con el "classpath:" busca en la carpeta resources */
            file = ResourceUtils.getFile("src/main/resources/static/URLs.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return mapObject(file);
    }

    private List<LinkResponseDTO> mapObject(File file) {
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<LinkResponseDTO>> typeReference = new TypeReference<>(){};
        List<LinkResponseDTO> linkDTOs = null;
        try {
            linkDTOs = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }
        return linkDTOs;
    }

}
