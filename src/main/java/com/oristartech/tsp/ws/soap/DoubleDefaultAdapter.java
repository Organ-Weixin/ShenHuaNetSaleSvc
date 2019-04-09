package com.oristartech.tsp.ws.soap;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by dongjingjun
 * 2017/6/13.
 * Gson  Double 适配器
 */
public class DoubleDefaultAdapter implements JsonSerializer<Double>, JsonDeserializer<Double> {
    @Override
    public Double deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.getAsString().equals("") || jsonElement.getAsString().equals("null")) {//定义为double类型,如果后台返回""或者null,则返回0.00
            return 0.00;
        }
        return jsonElement.getAsDouble();
    }

    @Override
    public JsonElement serialize(Double aDouble, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(aDouble);
    }
}
