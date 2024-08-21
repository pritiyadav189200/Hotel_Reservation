package Database;

public class hotel_dbmain {

	public static void main(String[] args)throws Exception {
		 HotelReservation hr=new  HotelReservation();
		 hr.connection();
		//hr. newreservation();
		//hr.chackreservation();
		//hr.updatereservation();
		hr.delete() ;
		hr.chackreservation();
		
	}

}
