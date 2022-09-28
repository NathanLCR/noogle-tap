package main;

import main.models.Link;
import main.models.PageInformations;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkFinder {
    private final String LINK_PATTERN = "<a[^(href)]+href\\s*=\\s*[\"']([^\"']+)[\"'][^>]+>([^(<)]*)<[\\s]*\\/[\\s]*a[\\s]*>";

    final Pattern pattern = Pattern.compile(LINK_PATTERN, Pattern.MULTILINE);

    Matcher matcher;

    public List<String> findLinks(PageInformations page, List<Link> links) {
        matcher = pattern.matcher(page.getPageContent());
        List<String> urls = new ArrayList<>();

        while (matcher.find()) {
            String titulo = matcher.group(2);
            String url = matcher.group(1);
            if(url.startsWith("/")) {
                url = page.getProtocol() + "://" + page.getHost() + url;
            }
            if(!url.startsWith("#")) {
                links.add(new Link(titulo, url));
                urls.add(url);
            }
        }

        return urls;
    }

}
