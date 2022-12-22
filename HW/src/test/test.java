//package test;
//
//import homework.verify.VerifyResult;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class test {
//        public static String path;
//
//        public test(String filename) {
//            this.path = "./HW/src/homework/verify/" + filename;
//        }
//
//        /**
//         * 讀取檔案
//         *
//         * @return myList
//         */
//        public static List readFile(String filePath) {
//
//            ArrayList myList = null;
//            try {
//                BufferedReader inFile = new BufferedReader(new FileReader(filePath));//用BufferedReader去做檔案的讀取
//                String lineTxt = null;
//                myList = new ArrayList();
//                while ((lineTxt = inFile.readLine()) != null) {
//                    //inFile.readLine()是指讀取txt檔的每一行資料,把讀到的資料存到lineTxt
//                    //再將lineTxt按照順序一行一行的儲存到myList
//                    myList.add(lineTxt);
//                }
//
//
//            } catch (IOException e) {
//                System.out.println("沒找到檔案");
//            }
//            return myList;
//        }
//
//    //身分驗證器
//    public static void Verify(String idStr){
//
//
//            int data[] = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
//            int val = data[idStr.charAt(0) - 'A']; //利用charAt取得idStr的第一個字母，與A相減取得相應的index
//            int p = (val / 10) + (9 * (val % 10)); //p為放加權後相加結果的變數，先計算第一個字母的值
//            int j = 1;
//        try{
//            // 用一個for迴圈去計算字母之後8個位數的加權
//            for (int i = 8; i >= 1; i--) {
//                System.out.println("j ="+j);
//                p += i * Integer.parseInt(idStr.substring(j, j+1));
//                j++;
//            }
//
//
//
//            int checkCode = (10 - (p%10))%10;//取得驗證碼
//
//
//            if (String.valueOf(idStr.charAt(9)).equals(String.valueOf(checkCode))) {
//                System.out.println("====您輸入的身分證字號" + idStr +"====");
//                System.out.println(checkCode);
//                System.out.println("====驗證成功====");
//            }else{
//                System.out.println("====您輸入的身分證字號" + idStr +"====");
//                System.out.println("====驗證失敗====");
//            }
//
//        }catch(ArrayIndexOutOfBoundsException e) {
//            System.out.println("====您輸入的身分證字號" + idStr +"====");
//            System.out.println("====輸入不正確，請再試一次====");
//        }
//
//    }
//    public static void main(String[] args) {
//
//        String filePath = "C:\\Users\\88698\\Downloads\\idList.txt";
//        List list =readFile(filePath);
//        String idStr = null;
//
//        for (int i =0; i<list.size(); i++){
//            idStr = (String) list.get(i);
//            Verify(idStr);
//        }
//
//
//
//
//
//    }
//
//}
//
//
