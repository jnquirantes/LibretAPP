package com.app.programacion_multimedia.tema6;

import com.amrdeveloper.reactbutton.Reaction;
import com.app.programacion_multimedia.R;

import mehdi.sakout.aboutpage.AboutPage;

public class T6_FbReaction {

    public static Reaction defaultReact = new Reaction(
            ReactConstants.LIKE,
            ReactConstants.DEFAULT,
            ReactConstants.ORANGE,
            R.drawable.ic_orange_like);

    public static Reaction[] reactions = {
            new Reaction(ReactConstants.LIKE, ReactConstants.BLUE, R.drawable.ic_like),
            new Reaction(ReactConstants.LOVE, ReactConstants.RED_LOVE, R.drawable.ic_heart),
            new Reaction(ReactConstants.SMILE, ReactConstants.YELLOW_WOW, R.drawable.ic_happy),
            new Reaction(ReactConstants.WOW, ReactConstants.YELLOW_WOW, R.drawable.ic_surprise),
            new Reaction(ReactConstants.SAD, ReactConstants.YELLOW_HAHA, R.drawable.ic_sad),
            new Reaction(ReactConstants.ANGRY, ReactConstants.RED_ANGRY, R.drawable.ic_angry),
    };

    public static Reaction defaultComment = new Reaction(
            ReactConstants.COMMENT,
            ReactConstants.DEFAULT,
            ReactConstants.ORANGE,
            R.drawable.ic_orange_coment);

    public static Reaction[] comentar = {
            new Reaction(ReactConstants.COMMENT, ReactConstants.GREEN, R.drawable.ic_green_coment),
    };

    public static Reaction defaultShare = new Reaction(
            ReactConstants.SHARE,
            ReactConstants.DEFAULT,
            ReactConstants.ORANGE,
            R.drawable.ic_orange_share);


    public static Reaction[] compartir = {
            new Reaction(ReactConstants.SHARE, ReactConstants.DEFAULT, ReactConstants.ORANGE, R.drawable.ic_orange_share),
            new Reaction(ReactConstants.SHARED, ReactConstants.BLUE, R.drawable.ic_facebook),
            new Reaction(ReactConstants.SHARED, ReactConstants.PURPURE, R.drawable.ic_instagram),
            new Reaction(ReactConstants.SHARED, ReactConstants.RED_ANGRY, R.drawable.ic_email),
            new Reaction(ReactConstants.SHARED, ReactConstants.GRAY, R.drawable.ic_github),
            new Reaction(ReactConstants.SHARED, ReactConstants.BLUE_LIGHT, R.drawable.ic_twitter),
            new Reaction(ReactConstants.SHARED, ReactConstants.GREEN_DARK, R.drawable.ic_link),






    };
}
