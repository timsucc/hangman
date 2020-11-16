/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author timsucc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //* Declare String answer
        StringBuilder answer = new StringBuilder();

        //Step 1: 先決定隨機的號碼，這邊先以10個字為例
        //
        //* Declare randomNum = new Random()
        Random randomNum = new Random();

        //* Declare int lineNo = random(1,10)
        int lineno = randomNum.nextInt(10) + 1; //因為產生0~9, 故要加1, 產生1~10        

        //Step 2: 讀取檔案內容，決定答案
        //
        //* Open inputFile "guessName.dat"
        Scanner inputFile = new Scanner(new File("guessName.dat"));

        //* Declare int counter = 0
        int counter = 0;

        //* While NOT eof(inputFile)
        while (inputFile.hasNext()) {

            //* Set counter = counter + 1
            counter += 1;

            //* Declare String inputRecord
            //* Set inputRecord = inputFile.nextLine()
            String inputRecord = inputFile.nextLine();

            //* If counter == lineno then
            if (counter == lineno) {

                //* answer = inpurtRecord
                answer.append(inputRecord.trim());

                //* End while: 讀到資料之後，不需要再往下讀其他用不到的資訊了
                break;

            }//* End if

        }//* End while               

        //Step 3: 開始猜題
        //
        //這個宣告純粹是Java讀畫面使用的，虛擬碼可以不用寫        
        //* Declare Scanner keyboard
        //* Set keyboard = new Scanner(System.in)
        Scanner keyboard = new Scanner(System.in);

        //* Declare integer iFault to 0: 計算錯誤幾次
        int iFault = 0;

        //* Declare iCorrectCount = 0: 計算答對幾次
        int iCorrectCount = 0;

        //* Declare boolean isAllMatched = false: 預設全部都尚未答到
        boolean isAllMatched = false;

        //* Decalre HangMan hungman: 選告要使用HangMan小圖和計算Fault的屬性
        //* Set hangman = new HangMan()
        HangMan hangman = new HangMan();

        //* Display "This word has N letters:"
        System.out.println("This word has " + answer.length() + " letters.");
        System.out.println("");

        //* Declare String response = ""
        StringBuilder response = new StringBuilder();

        //* Dclare String sbResponse
        StringBuilder sbResponse = new StringBuilder();

        //* Set sbresponse = ""
        sbResponse.delete(0, sbResponse.length());

        //* Declare String showAnswer: 用來顯示目前答對的位置
        StringBuilder showAnswer = new StringBuilder();

        //* Set showAnswer = ""
        showAnswer.delete(0, showAnswer.length());

        //* For index = 0 to answerSize
        for (int i = 0; i < answer.length(); i++) {

            //* Set showAnswer[index] = "_": 沒有猜出來的字以底線表示
            showAnswer.append(("_"));
        }

        //* Declare boolean isNotEnd
        boolean isNotEnd = true;

        //* While (isNotEnd)
        while (isNotEnd) //先把答案拆解成字元的陣列
        {

            //* Display "Progess: " + showAnswer: 顯示目前的答題進度
            System.out.println("**********************************");
            System.out.println("Progress: " + showAnswer.toString());
            System.out.println("**********************************");
            System.out.println("");

            //* Display "Fault: " + iFault + " times": 顯示目前答錯的次數
            System.out.println("Fault: " + iFault + " times");

            //* Call hangman.setFault(iFault)
            hangman.setFault(iFault);

            //* Call hanman.showHangMan: 顯示目前的圖
            hangman.showHnagMan();
            System.out.println("");

            //* Display "Enter your guest (Only One Letter)"
            System.out.println("Enter your guest (Only one letter)");

            //* Input response
            sbResponse.delete(0, sbResponse.length());
            sbResponse.append(keyboard.nextLine());

            //* While length(sbResponse) > 1
            while (sbResponse.length() > 1) {

                //* Display "Please enter only one letter per guests:"
                System.out.println("Please enter only one letter per guest:");

                //* Input response
                sbResponse.delete(0, sbResponse.length());
                sbResponse.append(keyboard.nextLine());

            }//* End While

            //* Declare upperRespone = toUpperCase(sbResponse)
            String upperResponse = sbResponse.toString().toUpperCase().trim();

            //* Set sbResponse = upperResponse
            sbResponse.delete(0, sbResponse.length());
            sbResponse.append(upperResponse);

            //* Declare isMatched = false
            boolean isMatched = false;

            //* If answer contains response
            if (answer.toString().contains(sbResponse.toString())) {

                //* For index = 0 to length(answer)
                for (int i = 0; i < answer.length(); i++) {

                    //* If showAnswer[index] == "_"  AND answer[index] == response
                    if (showAnswer.charAt(i) == '_' && answer.charAt(i) == sbResponse.charAt(0)) {

                        //* Set isMatch = true
                        isMatched = true;

                        //* Set showAnwer[index] = answer[index]
                        showAnswer.setCharAt(i, answer.charAt(i));

                        //* Set iCorrectCount = iCorrectCount + 1
                        iCorrectCount += 1;
                    }//* End if

                    //* If iCorrectCount == length(answer)
                    if (iCorrectCount == answer.length()) {

                        //* Set isAllMatched = true
                        isAllMatched = true;

                        //* Set isNotEnd = false                  
                        isNotEnd = false;

                    }//* End if

                }//* End if

                //* Else
            } else {

                //* Set isMatched = false
                isMatched = false;

                //* If iFault < 6
                if (iFault < 6) {
                    
                    //* Set iFault = iFault + 1
                    iFault += 1;

                } else {//* Else
                    
                    //* Set isNotEnd = false
                    isNotEnd = false;
                }//* End if

            }//* End if

            System.out.println(""); //排版留空格而已，可以不用寫

        }//*End While

        /*
            Final Result!
         */
        //*If iFault > 5: Only 6 will be here!
        if (iFault > 5) {

            //*Display "Progress :" + showAnswer
            System.out.println("**********************************");
            System.out.println("Progress : " + showAnswer.toString());
            System.out.println("**********************************");
            System.out.println("");
            //*Display "Answer is: " + answer
            System.out.println("Answer is: " + answer.toString());
            System.out.println("");

            System.out.println("I am Sorry! You Failed!");

            //*Display "Fault: " + iFault + " times"
            System.out.println("Fault: " + iFault + " times");
            //*Call hangman.setFault(iFault)
            hangman.setFault(iFault);
            //*Call hangman.showHangMan()
            hangman.showHnagMan();

        } else { //*Else

            System.out.println("");

            //* Display "*** Bingo! ***"
            System.out.println("*** Bingo! ***");

            //* Display "Congradulation: " + answer
            System.out.println("Congradulation: " + showAnswer.toString());

            //* Display "Guess Count: " + (iCorrectCount + iFault) + ", Fault: " + iFault
            System.out.println("Guess Count: " + (iCorrectCount + iFault) + ", Fault: " + iFault);

        }//* End if

        System.out.println("");

    }

}
