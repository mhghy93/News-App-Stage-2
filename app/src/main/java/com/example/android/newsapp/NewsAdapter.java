package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID news_title
        TextView newsTitleView = (TextView) convertView.findViewById(R.id.news_title);
        // Display the news title of the current news in that TextView
        newsTitleView.setText(currentNews.getTitle());

        // Find the TextView with view ID news_section_name
        TextView newsSectionNameView = (TextView) convertView.findViewById(R.id.news_section_name);
        // Display the news section name of the current news in that TextView
        newsSectionNameView.setText(currentNews.getSectionName());

        // Find the TextView with view ID news_author_name
        TextView newsAuthorNameView = (TextView) convertView.findViewById(R.id.news_author_name);
        // Display the news author name of the current news in that TextView
        newsAuthorNameView.setText(currentNews.getAuthorName());

        //Variable that holds the date and time in the format (yyyy-mm-ddThh:mm:ssZ)
        String newsPublishedDateAndTime = currentNews.getDatePublished();
        //String array that hols the date and time
        String[] newsPublishedDateAndTimeArray;
        //Removes Z from newsPublishedDateAndTime
        if (newsPublishedDateAndTime.contains("Z")) {
            newsPublishedDateAndTimeArray = newsPublishedDateAndTime.split("Z");
            newsPublishedDateAndTime = newsPublishedDateAndTimeArray[0];
        }
        //Splits date and time
        newsPublishedDateAndTimeArray = newsPublishedDateAndTime.split("T");
        //Holds the date
        String publishedDate = newsPublishedDateAndTimeArray[0];
        //Holds the time
        String publishedTime = newsPublishedDateAndTimeArray[1];

        // Find the TextView with view ID date_published
        TextView datePublishedDateView = (TextView) convertView.findViewById(R.id.date_published);
        // Display the date on which the news was published of the current news in that TextView
        datePublishedDateView.setText(publishedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) convertView.findViewById(R.id.time);
        // Display the time on which the news was published of the current news in that TextView
        timeView.setText(publishedTime);

        // Return the list item view that is now showing the appropriate data
        return convertView;
    }

}