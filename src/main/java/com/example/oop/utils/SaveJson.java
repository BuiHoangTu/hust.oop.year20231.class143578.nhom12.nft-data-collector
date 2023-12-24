package com.example.oop.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveJson {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void writeJson(String fileName, Object data) {
        String homeDirectory = System.getProperty("user.home");
        Path path = Paths.get(homeDirectory).resolve("hust").resolve("nft");
        try {
            Files.createDirectories(path);

            File file = path.resolve(fileName).toFile();

            if (!file.exists()) file.createNewFile();

            FileWriter writer = new FileWriter(file);

            gson.toJson(data, writer);
        } catch (Exception ignored) {

        }

    }
}
