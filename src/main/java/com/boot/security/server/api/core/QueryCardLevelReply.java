package com.boot.security.server.api.core;

import java.util.List;

public class QueryCardLevelReply extends BaseReply {
	public QueryCardLevelReply()
    {
        Id = ID_QueryCardLevelReply;
    }
	public String CinemaCode;
	public QueryCardLevelReplyLevels Levels;
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public QueryCardLevelReplyLevels getLevels() {
		return Levels;
	}
	public void setLevels(QueryCardLevelReplyLevels levels) {
		Levels = levels;
	}
	public class QueryCardLevelReplyLevels{
		public List<QueryCardLevelReplyLevel> Level;

		public List<QueryCardLevelReplyLevel> getLevel() {
			return Level;
		}

		public void setLevel(List<QueryCardLevelReplyLevel> level) {
			Level = level;
		}
		public class QueryCardLevelReplyLevel{
			public String LevelCode;
			public String LevelName;
			public String getLevelCode() {
				return LevelCode;
			}
			public void setLevelCode(String levelCode) {
				LevelCode = levelCode;
			}
			public String getLevelName() {
				return LevelName;
			}
			public void setLevelName(String levelName) {
				LevelName = levelName;
			}
			
		}
		
	}
	

}
