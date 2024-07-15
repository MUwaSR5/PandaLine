package com.example.gxymavenspringboot1.unti;

public class DateDealUntil {

    public static String removeSecondsFromTimeString(String timeString) {
        // 使用正则表达式匹配时分秒部分
        String pattern = "(\\d{2}):(\\d{2}):(\\d{2})";
        String replacement = "$1:$2"; // 保留小时和分钟部分

        // 使用replaceAll方法替换匹配的部分
        String result = timeString.replaceAll(pattern, replacement);

        return result;
    }
}
