package homework.verify;

import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC01 extends IdVerifyHelper {

    public VerifyHelperC01(String filename) {
        super(filename);
    }

    public boolean isNumber(String idStr) {
        for (int i = 1; i <= idStr.length(); i++) {
            int chr = idStr.charAt(i);
            if (chr < 48 || chr > 57) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<VerifyResult> validate(String filename) {
        List<VerifyResult> resultsList = new ArrayList<>();
        List<String> list = readFile(filename);

        for (String idStr : list) {
            VerifyResult verifyResult = new VerifyResult();
            verifyResult.setId(idStr);

            int data[] = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
            int index = idStr.charAt(0) - 'A';

            if (0 > index || index > 25) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setMessage("證號格式錯誤");
            } else {
                try {
                    int val = data[index]; //利用charAt取得idStr的第一個字母，與A相減取得相應的index
                    int total = (val / 10) + (9 * (val % 10)); //p為放加權後相加結果的變數，先計算第一個字母的值
                    int count = 1;
                    // 用一個for迴圈去計算字母之後8個位數的加權
                    for (int i = 8; i >= 1; i--) {
                        total += i * Integer.parseInt(idStr.substring(count, count + 1));
                        count++;
                    }

                    int checkCode = (10 - (total % 10)) % 10;//取得驗證碼
                    if (idStr.length() != 10) {
                        verifyResult.setVerifySuccess(false);
                        verifyResult.setMessage("證號長度不為10");
                    } else if (isNumber(idStr)) {   //驗證後八碼是否數字
                        verifyResult.setVerifySuccess(false);
                        verifyResult.setMessage("證號格式錯誤");
                    } else if (String.valueOf(idStr.charAt(9)).equals(String.valueOf(checkCode))) {
                        verifyResult.setVerifySuccess(true);
                        verifyResult.setMessage("驗證成功");
                    } else {
                        verifyResult.setVerifySuccess(false);
                        verifyResult.setMessage("驗證失敗");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw e;
                }
            }
            resultsList.add(verifyResult);
        }
        return resultsList;
    }
}