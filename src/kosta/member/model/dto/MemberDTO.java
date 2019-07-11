package kosta.member.model.dto;

public class MemberDTO {
	private String memberId;
	private String memberPass;
	private String memberName;
	private String memberEmail;
	private String memberCellphone;
	private String memberAddr;
	private String memberDate;
	private String memberGrade;
	private int memberAge;
	
	public MemberDTO() {}
	
	public MemberDTO(String memberId, String memberPass, String memberName, String memberEmail,
			String memberCellphone, String memberAddr, int memberAge) {    //insert
		
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberCellphone = memberCellphone;
		this.memberAddr = memberAddr;
		this.memberAge = memberAge;
	}



	public MemberDTO(String memberId, String memberPass) {     //삭제
		this.memberId = memberId;
		this.memberPass = memberPass;
	}
	
	public MemberDTO(String memberId, String memberPass, String memberEmail, String memberCellphone,
			String memberAddr) {												//수정
		super();
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberEmail = memberEmail;
		this.memberCellphone = memberCellphone;
		this.memberAddr = memberAddr;
	}

	public MemberDTO(String memberId, String memberPass, String memberName, String memberEmail,
			String memberCellphone, String memberAddr, String memberDate, String memberGrade,  int memberAge) {
		super();
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberCellphone = memberCellphone;
		this.memberAddr = memberAddr;
		this.memberDate = memberDate;
		this.memberGrade = memberGrade;
		this.memberAge = memberAge;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPass() {
		return memberPass;
	}


	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberCellphone() {
		return memberCellphone;
	}


	public void setMemberCellphone(String memberCellphone) {
		this.memberCellphone = memberCellphone;
	}


	public String getMemberAddr() {
		return memberAddr;
	}


	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}


	public String getMemberDate() {
		return memberDate;
	}


	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}


	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
}
