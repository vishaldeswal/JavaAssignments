package com.nagarro.advancejava.assignment1.training.tshirtcontroller;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import com.nagarro.advancejava.assignment1.training.constants.Constant;
import com.nagarro.advancejava.assignment1.training.tshirtcontroller.CsvReader;
import com.nagarro.advancejava.assignment1.training.*;

import java.util.HashMap;
import java.util.HashSet;

/***
* Author: Vishal Deswal
* Email: vishal.deswal@nagarro.com
* 
* Description: Read CSV files from java Program and search the required data for user.
* 
* UpdationCheck Class : This class checks updates in source folder. It record changes in the source folder 
						and do changes in running program data accordingly.
* 
* ***/



public class UpdationCheck implements Runnable {
	/*Stores all File present and  their lastmodified time of these files when last time data inserted in tshirtinfo. */
	HashMap<String, Long> FileLastModified = new HashMap<String, Long>();
	
	public void run() {
		
		File file= new File(Constant.SOURCE_FOLDER);
		File files[]= file.listFiles();
		
		ArrayList<String> list = new ArrayList<String>(); //Current files present in folder.
		
		for(File t: files)
		{	
			String fileName= t.getName();
			  // check file contain .csv format                   // check is new file arrived                        // check if old file is updated
			if(fileName.endsWith(Constant.SOURCE_FILE_FORMAT)&&((!(FileLastModified.containsKey(t.getName())) ) || (t.lastModified() > FileLastModified.get(t.getName()))) ){
				
				FileLastModified.put(t.getName(), t.lastModified());
				
				synchronized (App.tshirtinfo) {
					App.tshirtinfo.put(t.getName(), CsvReader.readFile(t));
				}
			}
			list.add(t.getName());  //add all present file in list 
			
		}
		
		Set <String> tc = FileLastModified.keySet();
		
		Set <String> tname= new HashSet<String>();
		tname.addAll(tc);  // contains file name present during last insertion.
		
		if(tc.size() == list.size()) //if any file removed checked.
			return;
		for(String s: tname) { // if removed , renove its corresponding data from tshirtinfo.
			if(!(list.contains(s))) {
				FileLastModified.remove(s);
				synchronized (App.tshirtinfo)
				{
					App.tshirtinfo.remove(s);
				}
			}
		}
			
	}

}
