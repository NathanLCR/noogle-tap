package main;

import main.models.Link;
import java.util.List;

public class NoogleMain {
    public static void main(String[] args) throws InterruptedException {
        Crawler crawler = new Crawler();
        List<Link> links = crawler.start();

        links.forEach(e -> System.out.println("Titulo: " + e.getTitle() + "Link: " + e.getUrl()));
    }
}
