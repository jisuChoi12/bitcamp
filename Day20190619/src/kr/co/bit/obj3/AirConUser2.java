package kr.co.bit.obj3;

public class AirConUser2 {

	public static void main(String[] args) {
		
		AirCon airCon1 = new AirCon();
		
		airCon1.color="White";
		airCon1.temp=10;
		airCon1.price=10000;
		airCon1.tempUp();
		System.out.println("airCon1.temp="+airCon1.temp+" airCon1.color="+airCon1.color+" airCon1.price="
				+airCon1.price+"원");
		
		airCon1.powerOn();
		airCon1.powerOff();
		airCon1.tempDown();
		System.out.println("airCon1.temp="+airCon1.temp+" airCon1.color="+airCon1.color+" airCon1.price="
				+airCon1.price+"원");
		
		// constructor가 자동으로 초기값 셋팅
		AirCon airCon2 = new AirCon();
		System.out.println("airCon2.temp="+airCon2.temp+" airCon2.color="+airCon2.color+" airCon2.price="
				+airCon2.price+"원");
	}

}
