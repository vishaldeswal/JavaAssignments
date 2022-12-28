package com.nagarro.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.nagarro.constant.Constant;
import com.nagarro.model.Tshirt;;

public class ReadCSVFiles {
	/**
	 * This method reads the csv files and stores them in different list
	 * @return The List stored with csv files data
	 */
	public static void readCSVFiles() {
		Tshirt product;
		List<Tshirt> files = new ArrayList<Tshirt>();
		File sourceFolder = new File(Constant.SOURCE_FOLDER);
		File[] fileList = sourceFolder.listFiles();

		for (File sourceFile : fileList) {
			String fileName = sourceFile.getName();
			if (sourceFile.isFile() && fileName.endsWith(Constant.SOURCE_FILE_FORMAT)) {
				try {
					@SuppressWarnings("resource")
					Scanner scanner = new Scanner(sourceFile);
					scanner.nextLine();
					String input;

					while (scanner.hasNextLine()) {
						product = new Tshirt();
						input = scanner.nextLine();
						String[] data = input.split(Pattern.quote("|"));

						product.setiD(data[0]);
						product.setName(data[1]);
						product.setColor(data[2]);
						product.setGenderRecommendation(data[3]);
						product.setSize(data[4]);
						product.setPrice(Double.parseDouble(data[5]));
						product.setRating(Double.parseDouble(data[6]));
						product.setTshirtAvailability(data[7]);

						files.add(product);
					}

				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}

		AddToDataBase add = new AddToDataBase();
		add.addToDataBase(files);
	}


}

