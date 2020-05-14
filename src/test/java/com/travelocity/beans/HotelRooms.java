package com.travelocity.beans;

public class HotelRooms {
	
		private String description;
		private String price;
		private String numberOfGuests;
		private String square;
		private String bed;
		
		public HotelRooms(String description, String price, String numberOfGuests, String square, String bed) {
			super();
			this.description = description;
			this.price = price;
			this.numberOfGuests = numberOfGuests;
			this.square = square;
			this.bed = bed;
		}
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getNumberOfGuests() {
			return numberOfGuests;
		}
		public void setNumberOfGuests(String numberOfGuests) {
			this.numberOfGuests = numberOfGuests;
		}
		public String getSquare() {
			return square;
		}
		public void setSquare(String square) {
			this.square = square;
		}
		public String getBed() {
			return bed;
		}
		public void setBed(String bed) {
			this.bed = bed;
		}
		
		
		

	


}
