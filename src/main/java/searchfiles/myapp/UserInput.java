package searchfiles.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//		標準入力受け取りクラス
public class UserInput {

    public String[] getUserInput(){
        InputStreamReader isr = new InputStreamReader(System.in); 
        BufferedReader br = new BufferedReader(isr);
        
        String[] messages = {
            "フォルダ名を入力（絶対パス）",
            "拡張子を指定する場合は入力",
            "検索文字列を指定する場合は入力"
            };
            
        // 入力を格納する文字列配列を初期化
        String[] inputs = new String[messages.length];

        // 入力を受け取る
        for(int i = 0; i < messages.length; i++){
            try{
                System.out.println(messages[i]);
                inputs[i] = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        try{
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return inputs;
    }
}

