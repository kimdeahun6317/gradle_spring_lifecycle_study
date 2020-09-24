package gradle_spring_lifecycle_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle_spring_lifecycle_study.spring.ChangePaswordService;
import gradle_spring_lifecycle_study.spring.MemberDao;
import gradle_spring_lifecycle_study.spring.MemberInfoPrinter;
import gradle_spring_lifecycle_study.spring.MemberListPrinter;
import gradle_spring_lifecycle_study.spring.MemberPrinter;
import gradle_spring_lifecycle_study.spring.MemberRegisterService;
import gradle_spring_lifecycle_study.spring.VersionPrinter;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePaswordService changePwdSvc() {
		ChangePaswordService pwdSvc = new ChangePaswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(),memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
		
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
