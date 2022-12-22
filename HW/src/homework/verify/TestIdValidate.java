package homework.verify;

public class TestIdValidate {

    public static void main(String[] args) {
        IdVerifyHelper idVerifyHelper = new IdVerifyHelper("");
        System.out.println(idVerifyHelper.validate("C:\\practice\\HW\\src\\homework\\verify\\idList3.txt"));
        IdVerifyHelper idVerifyHelper1 = new VerifyHelperC01("");
        IdVerifyHelper idVerifyHelper2 = new VerifyHelperC02("");
        System.out.println(idVerifyHelper1.validate("C:\\practice\\HW\\src\\homework\\verify\\idList3.txt"));
        System.out.println(idVerifyHelper2.validate("C:\\practice\\HW\\src\\homework\\verify\\idList3.txt"));
    }

}
