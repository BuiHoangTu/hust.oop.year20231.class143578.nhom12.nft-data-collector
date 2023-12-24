package com.example.oop.service;

import com.example.oop.model.ModelTwitter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlerTwitter implements Crawler{
    Document document = Jsoup.connect("https://getdaytrends.com/").get();
    Elements elms = document.getElementsByClass("trends");

    public CrawlerTwitter() throws IOException {
    }


    @Override
    public List<ModelTwitter> crawlData() {
        List<ModelTwitter> modelTwitterList =new ArrayList<>();
        for (Element e:
             elms) {
            Elements elms = document.getElementsByTag("tbody");
            for (Element elm : elms) {
                Elements elm_row = elm.getElementsByClass("main");
                for (Element element : elm_row) {
                    ModelTwitter model = new ModelTwitter();
                    Elements elm_row_td_first = element.getElementsByTag("a");
                    model.setLink(elm_row_td_first.first().absUrl("href"));
                    model.setHashTag(elm_row_td_first.first().text());
                    modelTwitterList.add(model);

                }

            }

        }
       return modelTwitterList;

    }

}
