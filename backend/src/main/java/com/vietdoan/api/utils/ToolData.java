package com.vietdoan.api.utils;

import java.util.Map;

public class ToolData {
    public static Integer reqInt(Map<String, String> json, String col, Integer valDef) {
        try {
            if (json.get(col) != null)
                return Integer.valueOf(Integer.parseInt(json.get(col).toString()));
        } catch (Exception exception) {
        }
        return valDef;
    }

    public static String reqStr(Map<String, String> json, String col, String valDef) {
        if (json.get(col) != null)
            return json.get(col).toString();

        return valDef;
    }
}
