package kr.co.bit.members5;

public class SignOut extends Members {
	public void signOutProcess() { //로그아웃
		if (MembersMain.session == null) {
			System.out.println("로그인중이 아닙니다.");
//			continue;
		}
		MembersMain.session = null;
		System.out.println("로그아웃되었습니다");
	} //로그아웃
}
