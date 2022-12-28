package com.nagarro.constant;

public class Constant {
	public static final String SOURCE_FOLDER = "D:\\vishal-deswal\\Advaced Java Assignment 4\\t-shirtSearchUsingSpringMVC\\src\\main\\resources";

	public static final String SORT_BY_RATING = "Rating";
	public static final String SORT_BY_PRICE = "Price";

	public static final long DELAY = 1000;

	public static final long PERIOD = 5000;

	public static final String SOURCE_FILE_FORMAT = ".csv";
	
	public static final String UNIVERSAL_GENDER = "U";
	
	public static final String SEARCH_QUERY ="from Tshirt where color = :color and size = :size and (genderRecommendation = :gender or genderRecommendation = :universal) ";
}
