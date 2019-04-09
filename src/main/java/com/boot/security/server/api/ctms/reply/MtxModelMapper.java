package com.boot.security.server.api.ctms.reply;

import java.util.Date;

import com.boot.security.server.model.Screeninfo;

public class MtxModelMapper {
	 public static Screeninfo MapToEntity(MtxGetHallResult.ResBean.HallsBean.HallBean model, Screeninfo entity)
     {
         entity.setSCode(model.getHallNo());
         entity.setSName(model.getHallName());
         entity.setUpdateTime(new Date());
         return entity;
     }

}
