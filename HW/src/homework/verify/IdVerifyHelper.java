package homework.verify;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IdVerifyHelper {

    public static String path;

    public IdVerifyHelper(String filename){
        this.path = "./HW/src/homework/verify/"+ filename;
    }

    /**
     * 讀取檔案
     * @return myList
     */
    public static List<String> readFile(String filename) {
        List<String> myList = new ArrayList();

        try {
            BufferedReader inFile = new BufferedReader(new FileReader(filename));//用BufferedReader去做檔案的讀取
            String lineTxt;

            while ((lineTxt = inFile.readLine()) != null) {
                //inFile.readLine()是指讀取txt檔的每一行資料,把讀到的資料存到lineTxt
                //再將lineTxt按照順序一行一行的儲存到myList
                myList.add(lineTxt);
            }
        } catch (IOException e) {
            System.out.println("沒找到檔案");
        }
        return myList;
    }

    /**
     * 計算並且驗證
     * @param idStr
     * @return
     */
    public static VerifyResult verify(String idStr) {
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
            if (String.valueOf(idStr.charAt(9)).equals(String.valueOf(checkCode))) {
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
        return verifyResult;
    }

    public static List<VerifyResult> validate(String filename){
        List<VerifyResult> resultsList = new ArrayList<>();
        List<String> list = readFile(filename);

        for (String idStr : list) {
            resultsList.add(verify(idStr));
        }
        return resultsList;
    }
}
