package com.boot.security.server.apicontroller.reply;

import com.boot.security.server.apicontroller.reply.QueryScreensReply.QueryScreensReplyScreens.QueryScreensReplyScreen;
import com.boot.security.server.model.Screeninfo;

public class ModelMapper {
	public static QueryScreensReplyScreen MapFrom(QueryScreensReplyScreen screen, Screeninfo entity)
    {
        screen.setScreenId(entity.getId());
        screen.setCinemaCode(entity.getCCode());
        screen.setScreenCode(entity.getSCode());
        screen.setScreenName(entity.getSName());
        screen.setSeatCount(entity.getSeatCount());
        screen.setType(entity.getType());
        return screen;
    }
}
