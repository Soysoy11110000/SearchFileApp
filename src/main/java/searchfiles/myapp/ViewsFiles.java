package searchfiles.myapp;

import org.springframework.stereotype.Controller;

@Controller
@
//フォルダ内に存在するファイルを取得し、ファイル名を表示する
public class ViewsFiles {

	public static void main(String[] args) {

		
//		拡張子の種類を指定
//		String[] suffixList = {"png", "jpg", "txt", "cmc", "clip", ".pdf", "docs", "xlsx"};
		
//		標準入力を受け取る
		UserInput userInput = new UserInput();
		String[] inputs = userInput.getUserInput();

        // 入力値を変数に格納
        String folderpath = inputs[0];
        String selectSuffix = inputs[1];
        String targetString = inputs[2];

		//		確認用メッセージ出力
		System.out.format("【入力パス】: %s%n", folderpath);
		System.out.format("【指定した拡張子】: %s%n", selectSuffix);
		System.out.format("【検索文字列】: %s%n", targetString);

		
		System.out.format("【  %s の検索結果】: %n", folderpath);
		// 入力値からファイル・フォルダを検索
		SearchFiles result = SearchFiles.getPath(folderpath, selectSuffix,targetString);
		
		int totalCount = result.totalCount;
		int suffixCount = result.suffixCount;
//	　　　　メッセージ表示
		if(totalCount == 0){
			System.out.print("誠に遺憾でありますが、検索結果はありませんでした。");
		}else{
			System.out.format("%n計：　%d件ヒット", totalCount);
		}
		if(suffixCount == 0){
			System.out.println("\r\n拡張子は未設定です");
		}else{
			System.out.format("%n拡張子%s：　%d件ヒット", selectSuffix, suffixCount);
		}
		
	}

}
