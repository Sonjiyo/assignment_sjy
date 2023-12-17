package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dao.ItemDAO;
import dao.UserDAO;

public class FileManager {
	private static File file;
	private static String filePath = System.getProperty("user.dir") + "\\src\\";
	private static FileManager instance = new FileManager();
	
	private FileManager(){
		filePath += this.getClass().getPackageName()+"\\";
	}

	public static void dataFileSave(UserDAO userDAO, ItemDAO itemDAO) {
		fileSave("user.txt",userDAO.userDataSave());
		fileSave("item.txt",itemDAO.itemDataSave());
		
		System.out.println("[저장 완료]");
	}

	private static void fileSave(String fileName, String data) {
		file = new File(filePath+fileName);
		
		try(FileWriter fw = new FileWriter(file)){
			fw.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dataFileLoad(UserDAO userDAO, ItemDAO itemDAO) {
		String userData = fileLoad("user.txt");
		String itemData = fileLoad("item.txt");
		
		userDAO.userDataLoad(userData);
		itemDAO.itemDataLoad(itemData);
		
		System.out.println("[데이터 불러옴]");
	}
	
	private static String fileLoad(String fileName) {
		String data = "";
		file = new File(filePath+fileName);
		
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);){
			String str = "";
			while(true) {
				str = br.readLine();
				if(str==null) break;
				data += str+"\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
}
