package searchfiles.myapp;

import java.io.File;

class SearchFiles {
	// 二つの値を返すため、クラスを作成してそれらの値をフィールドに格納する
	// privateにしてたら呼び出せなかった
	int totalCount;
    int suffixCount;

	// コンストラクタ
	SearchFiles(int totalCount, int suffixCount){
		this.totalCount = totalCount;
		this.suffixCount = suffixCount;
	}

	// 静的メソッドは、クラス自体に関連付けられており、インスタンスを作成することなく呼び出すことができ
	public static SearchFiles getPath(String folderpath, String selectSuffix, String targetString){

        //		フォルダ内にあるフォルダ・ファイル名をすべて取得(パス込み)
		File file = new File(folderpath);
		File[] dirs_files = file.listFiles();

        //		検索結果件数のカウント用
		int totalCount = 0;
		int suffixCount = 0;

        for(File dir_file:dirs_files){
            //		フォルダ・ファイル名を取得
			String dir_filename = dir_file.getName();
			//		検索文字列が指定されていない場合
			if(targetString.length() == 0){
				if(selectSuffix.length() != 0){
					//		　指定拡張子があればそのファイルを表示
					if(dir_filename.endsWith(selectSuffix)){
						System.out.format("・　%s%n", dir_filename);
					//		  指定拡張子のファイルの件数をカウント
						suffixCount++;
					}
				}
				System.out.format("・　%s%n", dir_filename);
				totalCount++;
			//		検索文字列が指定されている場合
			}else{
			//		検索文字列が含まれている場合
				if(dir_filename.contains(targetString)){
					if(selectSuffix.length() != 0){
			//			　　　　指定拡張子があればそのファイルを表示
						if(dir_filename.endsWith(selectSuffix)){
							System.out.format("・　%s%n", dir_filename);
			//				指定拡張子のファイルの件数をカウント
							suffixCount++;
						}else{
							System.out.format("・　%s%n", dir_filename);
							totalCount++;
						}
					}
				}
			}
		}

        return new SearchFiles(totalCount, suffixCount);
    }

}
