package thread.basic;

import java.io.IOException;

public class Ex01_process {

    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();

        try {
            rt.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        } catch (IOException e) {
            System.out.println("예외: " + e);
        }
        System.out.println("프로그램 실행");

        /*
            명령프롬프트의 명령어를 실행 가능

                > python hello.py
                > 
        */
    }
    
}
