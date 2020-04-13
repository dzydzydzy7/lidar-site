package com.dzy.controller;

import com.dzy.utils.ProgramUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;


@Controller
public class PictureController {
    @Autowired
    private ProgramUtils programUtils;

    @RequestMapping(value = "/png/{image_name}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImagePng(@PathVariable("image_name") String image_name) throws Exception{

        byte[] imageContent ;
        String path = programUtils.getPicFolder() + image_name + ".png";
        imageContent = fileToByte(new File(path), "png");

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/jpg/{image_name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImageJpg(@PathVariable("image_name") String image_name) throws Exception{

        byte[] imageContent ;
        String path = programUtils.getPicFolder() + image_name + ".jpg";
        imageContent = fileToByte(new File(path), "jpeg");

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/jpeg/{image_name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImageJpeg(@PathVariable("image_name") String image_name) throws Exception{

        byte[] imageContent ;
        String path = programUtils.getPicFolder() + image_name + ".jpeg";
        imageContent = fileToByte(new File(path), "jpeg");

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/gif/{image_name}", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> getImageGif(@PathVariable("image_name") String image_name) throws Exception{

        byte[] imageContent ;
        String path = programUtils.getPicFolder() + image_name + ".gif";
        imageContent = fileToByte(new File(path), "gif");

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_GIF);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }

    public static byte[] fileToByte(File img, String formatName) throws Exception {
        byte[] bytes = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            BufferedImage bi;
            bi = ImageIO.read(img);
            ImageIO.write(bi, formatName, baos);
            bytes = baos.toByteArray();
        } catch (Exception e) {
            System.out.println(img.getAbsolutePath());
            e.printStackTrace();
        }
        return bytes;
    }
}
