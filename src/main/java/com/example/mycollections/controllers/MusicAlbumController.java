package com.example.mycollections.controllers;
import com.example.mycollections.models.MusicAlbum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/MusicAlbums")
public class MusicAlbumController {
    private final List<MusicAlbum> musicAlbums = new ArrayList<>() {{
        add(new MusicAlbum("Thriller", 1982, 9, "Michael Jackson"));
        add(new MusicAlbum("21", 2011, 11, "Adele"));
        add(new MusicAlbum("Abbey Road", 1969, 17, "The Beatles"));
    }};

    @GetMapping("/json")
    public List<MusicAlbum> getMusicAlbumsJson() {
        return musicAlbums;
    }

    @GetMapping("/html")
    public String getMusicAlbumsHtml() {
        String musicAlbumList = "<ul>";
        for (MusicAlbum album : musicAlbums) {
            musicAlbumList += "<li>" + album + "</li>";
        }
        musicAlbumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>MusicAlbums</h1>
                        <ul>
                """ +
                musicAlbumList +
                """
                    </body>
                </html>
                """;
    }
}
