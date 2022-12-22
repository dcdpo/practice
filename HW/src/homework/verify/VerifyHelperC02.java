package homework.verify;

import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC02 extends IdVerifyHelper {
    public VerifyHelperC02(String filename) {
        super(filename);
    }

//    public VerifyResult verifyFormat2(String idStr) {
//        VerifyResult verifyResult = new VerifyResult();
//        verifyResult.setId(idStr);
//
//        for (int i = 0; i <= idStr.length(); i++) {
////            int chr = idStr.charAt(i);
//        if (idStr.matches("[a-zA-Z0-9]*")) {
//            verifyResult.setVerifySuccess(false);
//            verifyResult.setMessage("證號格式錯誤*");
//        } else {
//            validate(idStr);
//        }
//        }
//        return verifyResult;
//    }

    @Override
    public List<VerifyResult> validate(String filename) {
        List<VerifyResult> resultsList = new ArrayList<>();
        List<String> list = readFile(filename);

        for (String idStr : list) {

            VerifyResult verifyResult = new VerifyResult();
            verifyResult.setId(idStr);
            try {
                int data[] = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
                int val = data[idStr.charAt(0) - 'A']; //利用charAt取得idStr的第一個字母，與A相減取得相應的index
                int total = (val / 10) + (9 * (val % 10)); //p為放加權後相加結果的變數，先計算第一個字母的值
                int count = 1;
                // 用一個for迴圈去計算字母之後8個位數的加權
                for (int i = 8; i >= 1; i--) {
                    total += i * Integer.parseInt(idStr.substring(count, count + 1));
                    count++;
                }

                int checkCode = (10 - (total % 10)) % 10;//取得驗證碼
                if (idStr.matches("[a-zA-Z0-9]")) {
                    verifyResult.setVerifySuccess(false);
                    verifyResult.setMessage("證號格式錯誤*");
                } else if (String.valueOf(idStr.charAt(9)).equals(String.valueOf(checkCode))) {
                    verifyResult.setVerifySuccess(true);
                    verifyResult.setMessage("驗證成功");
                } else {
                    verifyResult.setVerifySuccess(false);
                    verifyResult.setMessage("驗證失敗");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setMessage("驗證失敗");
            }
            resultsList.add(verifyResult);
        }
        return resultsList;
    }
}
