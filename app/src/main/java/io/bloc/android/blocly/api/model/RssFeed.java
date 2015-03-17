package io.bloc.android.blocly.api.model;

/**
 * Created by jayapriya on 01/03/15.
 */
public class RssFeed {
    private String title;
    private String description;
    private String siteUrl;
    private String feedUrl;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RssFeed(String title, String description, String siteUrl, String feedUrl,String imageUrl) {

        this.title = title;
        this.description = description;
        this.siteUrl = siteUrl;
        this.feedUrl = feedUrl;
        this.imageUrl = imageUrl;


    }
}
