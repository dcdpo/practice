package com.example.demo.entity;

public class Message {

    public static String createSuccess(){
        return "新增成功";
    }

    public static String createFail(){
        return "Id重複，新增失敗";
    }

    public static String updateFail(){
        return "沒有這筆資料可以修改";
    }

    public static String deleteSuccess(){
        return "刪除成功";
    }

    public static String deleteFail(){
        return "沒有資料可以刪除";
    }
}
