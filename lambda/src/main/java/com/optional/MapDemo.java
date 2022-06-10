package com.optional;

import java.util.Optional;

/**
 * @version : V1.0
 * @date : 2022/6/6 17:25
 * @Author : LLH
 * @Desc :
 */
public class MapDemo {
    public static void main(String[] args) {
        PictureCondition pictureCondition = new PictureCondition();

        if(pictureCondition==null||pictureCondition.getUrl()==null||"".equals(pictureCondition.getUrl().trim())){
            throw new RuntimeException("出错啦");
        }

        Optional.ofNullable(pictureCondition)
                .map(PictureCondition::getUrl)
                .map(String::trim)
                .filter(x -> !"".equals(x))
                .orElseThrow(() -> new RuntimeException("出错啦"));

        Optional.ofNullable(pictureCondition).orElse(new PictureCondition());
    }


    public static class PictureCondition {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
}
