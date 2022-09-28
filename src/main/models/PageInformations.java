package main.models;

public class PageInformations {
    private String pageContent;
    private String protocol;
    private String host;

    public PageInformations(String pageContent, String protocol, String host) {
        this.pageContent = pageContent;
        this.protocol = protocol;
        this.host = host;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String page) {
        this.pageContent = page;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
