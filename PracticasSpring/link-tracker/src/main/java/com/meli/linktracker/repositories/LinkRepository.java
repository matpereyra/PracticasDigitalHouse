package com.meli.linktracker.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    @Override
    public LinkResponseDTO createAndStore(String link, String linkID) throws IOException{
        /*
        todo: Guardo si no se encuentra ya ese id (dificil que haya colisiones, no lo chequeo).
         */
        //List<LinkResponseDTO> linkDTOs = loadDB();
        LinkResponseDTO linkDTO = new LinkResponseDTO(link, linkID);
        storeLink(linkDTO);
        return linkDTO;
    }

    /*
    TODO: que ande. por que no puedo dsirectamente hacer un append al archivo? deberia loadear TODO el archivo,
     y ahi recien guardar al final el nuevo link que me mandaorn?????? 
     */
    private void storeLink(LinkResponseDTO linkDTO) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File("classpath:static/URLs.json");
            String path = file.getAbsolutePath(); // todo: BORRAR ESTA LINEA
            //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true))); // append mode file writer
            //objectMapper.writeValue(out, linkDTO);
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
            file = ResourceUtils.getFile("classpath:static/URLs.json");

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
