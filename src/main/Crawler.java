package main;

import main.models.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Crawler {

    private UrlDownloader urlDownloader = new UrlDownloader();
    private LinkFinder linkFinder = new LinkFinder();
    private List<Link> links = new ArrayList<>();
    private final Integer MAX_LINKS_SIZE = 10000;
    private ExecutorService threadPool = Executors.newFixedThreadPool(4);
    CountDownLatch latch = new CountDownLatch(1);


    private static final String URL_INICIAL = "https://pt.wikipedia.org/wiki/Capivara#:~:text=A%20capivara%20ou%20capincho%20(nome,classificada%20em%20uma%20fam%C3%ADlia%20pr%C3%B3pria.";

    public List<Link> start() throws InterruptedException {
        crawl(URL_INICIAL);
        latch.await();
        return links;
    }

    private void crawl(String url) {

        List<String> newUrls = linkFinder.findLinks(urlDownloader.getPage(url), links);

        //Evitar o site bloquear
        try {
            Thread.sleep(500);
        }catch (Exception e) {

        };
        if (links.size() < MAX_LINKS_SIZE){
            for (String u : newUrls) {
                if (!links.contains(u)) {
                    threadPool.submit(() -> crawl(u));
                }
            }
        } else {
            latch.countDown();
            threadPool.shutdownNow();
        }
    }
}
