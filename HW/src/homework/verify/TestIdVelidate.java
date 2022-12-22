package org.example;


import homework.verify.IdVerifyHelper;


public class TestIdVelidate {

    public class TestIdValidate {
        public static void main(String[] args) {
            IdVerifyHelper idVerifyHelper = new IdVerifyHelper("");
            System.out.println(idVerifyHelper.validate("C:\\practice\\HW\\src\\homework\\verify\\idList2.txt"));

        }
    }
}
