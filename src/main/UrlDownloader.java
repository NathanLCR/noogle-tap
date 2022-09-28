package main;

import main.models.PageInformations;

import java.net.URL;
import java.util.Scanner;

public class UrlDownloader {
    public PageInformations getPage(String url) {
        try {
            URL u = new URL(url);
            Scanner entrada = new Scanner(u.openStream());
            StringBuilder page = new StringBuilder();
            while (entrada.hasNextLine()) {
                page.append(entrada.nextLine());
            }

            return new PageInformations(page.toString(), u.getProtocol(),u.getHost());
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

}
