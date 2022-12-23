package homework.verify;

public class TestIdValidate {

    public static void main(String[] args) {
        String filepath = "C:\\practice\\HW\\src\\homework\\verify\\idList3.txt";
        IdVerifyHelper idVerifyHelper = new IdVerifyHelper("");
        IdVerifyHelper idVerifyHelper1 = new VerifyHelperC01("");
        IdVerifyHelper idVerifyHelper2 = new VerifyHelperC02("");

        System.out.println(idVerifyHelper.validate(filepath));
        System.out.println(idVerifyHelper1.validate(filepath));
        System.out.println(idVerifyHelper2.validate(filepath));
    }
}
