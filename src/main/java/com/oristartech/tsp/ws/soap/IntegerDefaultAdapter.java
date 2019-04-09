package com.oristartech.tsp.ws.soap;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by dongjingjun
 * 2017/6/13.
 * Gson  Integer 适配器
 */
public class IntegerDefaultAdapter implements JsonSerializer<Integer>, JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.getAsString().equals("") || jsonElement.getAsString().equals("null")) {//定义为int类型,如果后台返回""或者null,则返回0
            return 0;
        }
        return jsonElement.getAsInt();
    }

    @Override
    public JsonElement serialize(Integer integer, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(integer);
    }
}

