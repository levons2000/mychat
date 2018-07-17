package com.example.levon.chatproject.providers;

import com.example.levon.chatproject.models.UsersListModel;

import java.util.ArrayList;
import java.util.List;

public class UsersDataProvider {
    public static List<UsersListModel> listModels = new ArrayList<>();

    public static void listFill() {
        listModels.add(new UsersListModel("Valve", "We Like Money!!", "https://www.wired.com/images_blogs/gamelife/2013/07/valve-logo.jpg", "093197925", "valve@gmail.com"));
        listModels.add(new UsersListModel("Ubisoft", "Hacker was so cool:))", "http://cdn.themis-media.com/media/global/images/library/deriv/760/760707.jpg", "055118896", "ubisoft@gmail.com"));
        listModels.add(new UsersListModel("Bandai Namco", "Japan games are really hard >.<", "https://apptractor.ru/wp-content/uploads/2017/05/Namco-Bandai-Games.jpg", "094033456", "namcobandai@gmail.com"));
        listModels.add(new UsersListModel("RockStar", "Ok,we make GTA 6523 on next Week", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Rockstar_Games_Logo.svg/1200px-Rockstar_Games_Logo.svg.png", "077759517", "rockstar@gmail.com"));

    }

}
