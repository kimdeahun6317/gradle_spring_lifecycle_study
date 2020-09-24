package gradle_spring_lifecycle_study.assembler;

import gradle_spring_lifecycle_study.spring.ChangePaswordService;
import gradle_spring_lifecycle_study.spring.MemberDao;
import gradle_spring_lifecycle_study.spring.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePaswordService pwdSvc;

	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePaswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePaswordService getChangePaswordService() {
		return pwdSvc;
	}

}
