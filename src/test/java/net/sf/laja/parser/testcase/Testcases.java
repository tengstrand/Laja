
package net.sf.laja.parser.testcase;

import net.sf.laja.parser.testcase.TestcaseParser.ITestcase;
import net.sf.laja.parser.testcase.TestcaseParser.ITestcaseFactory;

import org.junit.Ignore;

@Ignore
public class Testcases implements TestcaseParser.ITestcase {
	private int phase;
	
	private int ok = 0;
	
	private int t113cnt = 0;
	private int t114cnt = 0;
	private int t123cnt = 0;
	private int t124cnt = 0;
	private int t141cnt = 0;
	private int t142cnt = 0;
	private int t143cnt = 0;
	private int t144cnt = 0;
	private int t153cnt = 0;
	private int t154cnt = 0;
	private int t161cnt = 0;
	private int t162cnt = 0;
	private int t163cnt = 0;
	private int t164cnt = 0;
	private int t214abcnt = 0;
	private int t214cdcnt = 0;
	private int t311cnt = 0;
	private int t312cnt = 0;
	private int t313cnt = 0;
	
	private String t511a; 

	public Testcases(int phase) {
		this.phase = phase;
	}
	
	static class TestcaseFactory implements ITestcaseFactory {
		int phase;
		
		public TestcaseFactory(int phase) {
			this.phase = phase;
		}
		
		public ITestcase createTestcase() {
			return new Testcases(phase);
		}
	}	
	
	// T111
	private static final int T111_1 = 1;
	
	public void setT111ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
		}
		if (ok != T111_1) {
			throw new RuntimeException("Error in setT111ab. ok=" + ok + ", arg=" + ab);
		}
	}
	
	private static final int T111_2 = T111_1 + 1;

	public void setT111all(String t111) {
		if (t111.equals("ab")) {
			ok++;
		}
		if (ok != T111_2) {
			throw new RuntimeException("Error in setT111all. ok=" + ok + ", arg=" + t111);
		}
	}

	
	// T112
	private static final int T112_1 = T111_2 + 1;
	
	public void setT112notab(String ab) {
		if (ab.equals("b")) {
			ok++;
		}
		if (ok != T112_1) {
			throw new RuntimeException("Error in setT112notab. ok=" + ok + ", arg=" + ab);
		}
	}

	private static final int T112_2 = T112_1 + 1;

	public void setT112all(String t112) {
		if (t112.equals("b")) {
			ok++;
		}
		if (ok != T112_2) {
			throw new RuntimeException("Error in setT112all. ok=" + ok + ", arg=" + t112);
		}
	}

	// T113
	public void setT113ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
			t113cnt++;
		}
	}

	private static final int T113_1 = T112_2 + 4;
	
	public void setT113all(String t113) {
		if (t113cnt != 3) {
			throw new RuntimeException("Error in setT113ab: t113cnt=" + t113cnt);
		}
		if (t113.equals("ababab")) {
			ok++;
		}
		if (ok != T113_1) {
			throw new RuntimeException("Error in setT113all. ok=" + ok + ", arg=" + t113);
		}
	}

	// T114
	public void setT114notab(String notab) {
		if (!notab.equals("ab") && notab.length() == 1) {
			ok++;
			t114cnt++;
		}
	}

	private static final int T114_1 = T113_1 + 4;
	
	public void setT114all(String t114) {
		if (t114cnt != 3) {
			throw new RuntimeException("Error in setT114notab: t114cnt=" + t114cnt);
		}
		if (t114.equals("axbab")) {
			ok++;
		}
		if (ok != T114_1) {
			throw new RuntimeException("Error in setT114all. ok=" + ok + ", arg=" + t114);
		}
	}

	// T121
	private static final int T121_1 = T114_1 + 1;
	
	public void setT121ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
		}
		if (ok != T121_1) {
			throw new RuntimeException("Error in setT121ab. ok=" + ok + ", arg=" + ab);
		}
	}

	private static final int T121_2 = T121_1 + 1;
	
	public void setT121all(String t121) {
		if (t121.equals("ab")) {
			ok++;
		}
		if (ok != T121_2) {
			throw new RuntimeException("Error in setT121all. ok=" + ok + ", arg=" + t121);
		}
	}

	// T122
	private static final int T122_1 = T121_2 + 1;
	
	public void setT122notab(String b) {
		if (b.equals("b")) {
			ok++;
		}
		if (ok != T122_1) {
			throw new RuntimeException("Error in setT122notab. ok=" + ok + ", arg=" + b);
		}
	}

	private static final int T122_2 = T122_1 + 1;
	
	public void setT122all(String t122) {
		if (t122.equals("b")) {
			ok++;
		}
		if (ok != T122_2) {
			throw new RuntimeException("Error in setT122all. ok=" + ok + ", arg=" + t122);
		}
	}

	// T123
	public void setT123ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
			t123cnt++;
		}
	}

	private static final int T123_1 = T122_2 + 4;
	
	public void setT123all(String t123) {
		if (t123cnt != 3) {
			throw new RuntimeException("Error in setT123ab: t123=" + t123);
		}
		if (t123.equals("ababab")) {
			ok++;
		}
		if (ok != T123_1) {
			throw new RuntimeException("Error in setT123all. ok=" + ok + ", arg=" + t123);
		}
	}

	// T124
	public void setT124notab(String notab) {
		if (!notab.equals("ab") && notab.length() == 1) {
			ok++;
			t124cnt++;
		}
	}

	private static final int T124_1 = T123_1 + 4;
	
	public void setT124all(String t124) {
		if (t124cnt != 3) {
			throw new RuntimeException("Error in setT124notab: t124=" + t124);
		}
		if (t124.equals("axbab")) {
			ok++;
		}
		if (ok != T124_1) {
			throw new RuntimeException("Error in setT124all. ok=" + ok + ", arg=" + t124);
		}
	}

	// T131
	public void setT131ab(String t131) {
		throw new RuntimeException("Error in setT131ab. This method should never be called. t131=" + t131);
	}

	private static final int T131_1 = T124_1 + 1;
	
	public void setT131x(String x) {
		if (!x.equals("ab") && x.length() == 1) {
			ok++;
		}
		if (ok != T131_1) {
			throw new RuntimeException("Error in setT131x. ok=" + ok + ", arg=" + x);
		}
	}

	// T132
	public void setT132a(String a) {
		throw new RuntimeException("Error in setT132a. This method should never be called. a=" + a);
	}

	private static final int T132_1 = T131_1 + 1;
	
	public void setT132x(String x) {
		if (x.equals("a")) {
			ok++;
		}
		if (ok != T132_1) {
			throw new RuntimeException("Error in setT132x. ok=" + ok + ", arg=" + x);
		}
	}

	// T133
	private static final int T133_1 = T132_1 + 1;
	
	public void setT133x(String x) {
		if (x.equals("b")) {
			ok++;
		}
		if (ok != T133_1) {
			throw new RuntimeException("Error in setT133x. ok=" + ok + ", arg=" + x);
		}
	}

	private static final int T133_2 = T133_1 + 1;
	
	public void setT133all(String t133) {
		if (t133.equals("b")) {
			ok++;
		}
		if (ok != T133_2) {
			throw new RuntimeException("Error in setT133all. ok=" + ok + ", arg=" + t133);
		}
	}

	// T134
	private static final int T134_1 = T133_2 + 1;

	public void setT134x(String x) {
		if (x.equals("a")) {
			ok++;
		}
		if (ok != T134_1) {
			throw new RuntimeException("Error in setT134x. ok=" + ok + ", arg=" + x);
		}
	}

	private static final int T134_2 = T134_1 + 1;
	
	public void setT134all(String t134) {
		if (t134.equals("a")) {
			ok++;
		}
		if (ok != T134_2) {
			throw new RuntimeException("Error in setT134all. ok=" + ok + ", arg=" + t134);
		}
	}

	// T141
	public void setT141notab(String notab) {
		throw new RuntimeException("Error in setT141notab. This method should never be called. notab=" + notab);
	}

	public void setT141x(String x) {
		if (x.equals("x")) {
			ok++;
			t141cnt++;
		}
	}

	private static final int T141_1 = T134_2 + 4;
	
	public void setT141ab(String ab) {
		if (t141cnt != 3) {
			throw new RuntimeException("Error in setT141x: ab=" + ab);
		}
		if (ab.equals("ab")) {
			ok++;
		}
		if (ok != T141_1) {
			throw new RuntimeException("Error in setT141ab. ok=" + ok + ", arg=" + ab);
		}
	}

	private static final int T141_2 = T141_1 + 1;
	
	public void setT141all(String t141) {
		if (t141.equals("xxxab")) {
			ok++;
		}
		if (ok != T141_2) {
			throw new RuntimeException("Error in setT141all. ok=" + ok + ", arg=" + t141);
		}
	}

	// T142
	public void setT142a(String a) {
		throw new RuntimeException("Error in setT142a. This method should never be called. a=" + a);
	}

	public void setT142x(String x) {
		if (x.equals("a")) {
			ok++;
			t142cnt++;
		}
	}

	private static final int T142_1 = T141_2 + 4;
	
	public void setT142all(String t142) {
		if (t142cnt != 3) {
			throw new RuntimeException("Error in setT142x: ab=" + t142);
		}
		if (t142.equals("aaa")) {
			ok++;
		}
		if (ok != T142_1) {
			throw new RuntimeException("Error in setT142all. ok=" + ok + ", arg=" + t142);
		}
	}

	// T143
	public void setT143notab(String notab) {
		throw new RuntimeException("Error in setT143notab. This method should never be called. notab=" + notab);
	}

	public void setT143x(String x) {
		if (x.equals("x")) {
			ok++;
			t143cnt++;
		}
	}

	private static final int T143_1 = T142_1 + 4;
	
	public void setT143ab(String ab) {
		if (t143cnt != 3) {
			throw new RuntimeException("Error in setT143x: ab=" + ab);
		}
		if (ab.equals("ab")) {
			ok++;
		}
		if (ok != T143_1) {
			throw new RuntimeException("Error in setT143ab. ok=" + ok + ", arg=" + ab);
		}
	}

	private static final int T143_2 = T143_1 + 1;
	
	public void setT143all(String t143) {
		if (t143.equals("xxxab")) {
			ok++;
		}
		if (ok != T143_2) {
			throw new RuntimeException("Error in setT143all. ok=" + ok + ", arg=" + t143);
		}
	}

	// T144
	public void setT144a(String a) {
		throw new RuntimeException("Error in setT144a. This method should never be called. a=" + a);
	}

	public void setT144x(String x) {
		if (x.equals("a")) {
			ok++;
			t144cnt++;
		}
	}

	private static final int T144_1 = T143_2 + 4;
	
	public void setT144all(String t144) {
		if (t144cnt != 3) {
			throw new RuntimeException("Error in setT141x: t144=" + t144);
		}
		if (t144.equals("aaa")) {
			ok++;
		}
		if (ok != T144_1) {
			throw new RuntimeException("Error in setT144all. ok=" + ok + ", arg=" + t144);
		}
	}

	// T151
	private static final int T151_1 = T144_1 + 1;

	public void setT151empty(String t151empty) {
		if (t151empty.equals("")) {
			ok++;
		}
		if (ok != T151_1) {
			throw new RuntimeException("Error in setT151empty. ok=" + ok + ", arg=" + t151empty);
		}
	}

	private static final int T151_2 = T151_1 + 1;
	
	public void setT151ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
		}
		if (ok != T151_2) {
			throw new RuntimeException("Error in setT151ab. ok=" + ok + ", arg=" + ab);
		}
	}

	private static final int T151_3 = T151_2 + 1;
	
	public void setT151all(String t151) {
		if (t151.equals("ab")) {
			ok++;
		}
		if (ok != T151_3) {
			throw new RuntimeException("Error in setT151all. ok=" + ok + ", arg=" + t151);
		}
	}

	// T152
	private static final int T152_1 = T151_3 + 1;

	public void setT152empty(String t152empty) {
		if (t152empty.equals("ab")) {
			ok++;
		}
		if (ok != T152_1) {
			throw new RuntimeException("Error in setT152empty. ok=" + ok + ", arg=" + t152empty);
		}
	}

	private static final int T152_2 = T152_1 + 1;
	
	public void setT152notab(String notab) {
		if (notab.equals("b")) {
			ok++;
		}
		if (ok != T152_2) {
			throw new RuntimeException("Error in setT152notab. ok=" + ok + ", arg=" + notab);
		}
	}

	private static final int T152_3 = T152_2 + 1;
	
	public void setT152all(String t152) {
		if (t152.equals("bab")) {
			ok++;
		}
		if (ok != T152_3) {
			throw new RuntimeException("Error in setT152all. ok=" + ok + ", arg=" + t152);
		}
	}

	// T153
	private static final int T153_1 = T152_3 + 1;

	public void setT153empty(String t153empty) {
		if (t153empty.equals("")) {
			ok++;
		}
		if (ok != T153_1) {
			throw new RuntimeException("Error in setT153empty. ok=" + ok + ", arg=" + t153empty);
		}
	}

	public void setT153ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
			t153cnt++;
		}
	}

	private static final int T153_2 = T153_1 + 4;
	
	public void setT153all(String t153) {
		if (t153cnt != 3) {
			throw new RuntimeException("Error in setT153ab: t153=" + t153);
		}
		if (t153.equals("ababab")) {
			ok++;
		}
		if (ok != T153_2) {
			throw new RuntimeException("Error in setT153all. ok=" + ok + ", arg=" + t153);
		}
	}

	// T154
	private static final int T154_1 = T153_2 + 1;
	
	public void setT154empty(String t154empty) {
		if (t154empty.equals("ab")) {
			ok++;
		}
		if (ok != T154_1) {
			throw new RuntimeException("Error in setT154empty. ok=" + ok + ", arg=" + t154empty);
		}
	}

	public void setT154notab(String notab) {
		if (!notab.equals("ab") && notab.length() == 1) {
			ok++;
			t154cnt++;
		}
	}

	private static final int T154_2 = T154_1 + 4;
	
	public void setT154all(String t154) {
		if (t154cnt != 3) {
			throw new RuntimeException("Error in setT154notab: t154=" + t154);
		}
		if (t154.equals("axbab")) {
			ok++;
		}
		if (ok != T154_2) {
			throw new RuntimeException("Error in setT154all. ok=" + ok + ", arg=" + t154);
		}
	}

	// T161
	private static final int T161_1 = T154_2 + 1;
	
	public void setT161empty(String t161empty) {
		if (t161empty.equals("")) {
			ok++;
		}
		if (ok != T161_1) {
			throw new RuntimeException("Error in setT161empty. ok=" + ok + ", arg=" + t161empty);
		}
	}

	public void setT161ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
			t161cnt++;
		}
	}

	private static final int T161_2 = T161_1 + 4;
	
	public void setT161all(String t161) {
		if (t161cnt != 3) {
			throw new RuntimeException("Error in setT161ab: t161=" + t161);
		}
		if (t161.equals("ababab")) {
			ok++;
		}
		if (ok != T161_2) {
			throw new RuntimeException("Error in setT161all. ok=" + ok + ", arg=" + t161);
		}
	}

	// T162
	private static final int T162_1 = T161_2 + 1;
	
	public void setT162empty(String t162empty) {
		if (t162empty.equals("ab")) {
			ok++;
		}
		if (ok != T162_1) {
			throw new RuntimeException("Error in setT162empty. ok=" + ok + ", arg=" + t162empty);
		}
	}

	public void setT162notab(String notab) {
		if (notab.equals("b")) {
			ok++;
			t162cnt++;
		}
	}

	private static final int T162_2 = T162_1 + 4;
	
	public void setT162all(String t162) {
		if (t162cnt != 3) {
			throw new RuntimeException("Error in setT162notab: t162=" + t162);
		}
		if (t162.equals("bbbab")) {
			ok++;
		}
		if (ok != T162_2) {
			throw new RuntimeException("Error in setT162all. ok=" + ok + ", arg=" + t162);
		}
	}

	// T163
	private static final int T163_1 = T162_2 + 1;
	
	public void setT163empty(String t163empty) {
		if (t163empty.equals("")) {
			ok++;
		}
		if (ok != T163_1) {
			throw new RuntimeException("Error in setT163empty. ok=" + ok + ", arg=" + t163empty);
		}
	}

	public void setT163ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
			t163cnt++;
		}
	}

	private static final int T163_2 = T163_1 + 4;
	
	public void setT163all(String t163) {
		if (t163cnt != 3) {
			throw new RuntimeException("Error in setT163ab: ab=" + t163);
		}
		if (t163.equals("ababab")) {
			ok++;
		}
		if (ok != T163_2) {
			throw new RuntimeException("Error in setT163all. ok=" + ok + ", arg=" + t163);
		}
	}

	// T164
	private static final int T164_1 = T163_2 + 1;
	
	public void setT164empty(String t164empty) {
		if (t164empty.equals("ab")) {
			ok++;
		}
		if (ok != T164_1) {
			throw new RuntimeException("Error in setT164empty. ok=" + ok + ", arg=" + t164empty);
		}
	}

	public void setT164notab(String notab) {
		if (notab.equals("b")) {
			ok++;
			t164cnt++;
		}
	}

	private static final int T164_2 = T164_1 + 4;
	
	public void setT164all(String t164) {
		if (t164cnt != 3) {
			throw new RuntimeException("Error in setT164notab: ab=" + t164);
		}
		if (t164.equals("bbbab")) {
			ok++;
		}
		if (ok != T164_2) {
			throw new RuntimeException("Error in setT164all. ok=" + ok + ", arg=" + t164);
		}
	}

	// T165
	private static final int T165_1 = T164_2 + 1;
	
	public void setT165(String x) {
		if (x.equals("ab")) {
			ok++;
		}
		if (ok != T165_1) {
			throw new RuntimeException("Error in setT165. ok=" + ok + ", arg=" + x);
		}
	}
	
	
	// T211
	private static final int T211_1 = T165_1 + 1;
	
	public void setT211ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
		}
		if (ok != T211_1) {
			throw new RuntimeException("Error in setT211ab. ok=" + ok + ", arg=" + ab);
		}
	}

	private static final int T211_2 = T211_1 + 1;
	
	public void setT211cd(String cd) {
		if (cd.equals("cd")) {
			ok++;
		}
		if (ok != T211_2) {
			throw new RuntimeException("Error in setT211cd. ok=" + ok + ", arg=" + cd);
		}
	}

	private static final int T211_3 = T211_2 + 1;
	
	public void setT211all(String t211) {
		if (t211.equals("abcd")) {
			ok++;
		}
		if (ok != T211_3) {
			throw new RuntimeException("Error in setT211all. ok=" + ok + ", arg=" + t211);
		}
	}

	// T212
	private static final int T212_1 = T211_3 + 1;
	
	public void setT212ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
		}
		if (ok != T212_1) {
			throw new RuntimeException("Error in setT212ab. ok=" + ok + ", arg=" + ab);
		}
	}

	private static final int T212_2 = T212_1 + 1;
	
	public void setT212cd(String cd) {
		if (cd.equals("cd")) {
			ok++;
		}
		if (ok != T212_2) {
			throw new RuntimeException("Error in setT212cd. ok=" + ok + ", arg=" + cd);
		}
	}

	private static final int T212_3 = T212_2 + 1;
	
	public void setT212all(String t211) {
		if (t211.equals("abcd")) {
			ok++;
		}
		if (ok != T212_3) {
			throw new RuntimeException("Error in setT212all. ok=" + ok + ", arg=" + t211);
		}
	}

	// T213
	private static final int T213_1 = T212_3 + 1;
	
	public void setT213empty(String t213empty) {
		if (t213empty.equals("")) {
			ok++;
		}
		if (ok != T213_1) {
			throw new RuntimeException("Error in setT213empty. ok=" + ok + ", arg=" + t213empty);
		}
	}

	private static final int T213_2 = T213_1 + 1;
	
	public void setT213ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
		}
		if (ok != T213_2) {
			throw new RuntimeException("Error in setT213ab. ok=" + ok + ", arg=" + ab);
		}
	}

	private static final int T213_3 = T213_2 + 1;
	
	public void setT213cd(String cd) {
		if (cd.equals("cd")) {
			ok++;
		}
		if (ok != T213_3) {
			throw new RuntimeException("Error in setT213cd. ok=" + ok + ", arg=" + cd);
		}
	}

	private static final int T213_4 = T213_3 + 1;
	
	public void setT213all(String t213) {
		if (t213.equals("abcd")) {
			ok++;
		}
		if (ok != T213_4) {
			throw new RuntimeException("Error in setT213all. ok=" + ok + ", arg=" + t213);
		}
	}

	// T214
	private static final int T214_1 = T213_4 + 1;
	
	public void setT214empty(String t214empty) {
		if (t214empty.equals("")) {
			ok++;
		}
		if (ok != T214_1) {
			throw new RuntimeException("Error in setT214empty. ok=" + ok + ", arg=" + t214empty);
		}
	}

	public void setT214ab(String ab) {
		if (ab.equals("ab")) {
			ok++;
			t214abcnt++;
		}
	}

	public void setT214cd(String cd) {
		if (cd.equals("cd")) {
			ok++;
			t214cdcnt++;
		}
	}

	private static final int T214_2 = T214_1 + 5;
	
	public void setT214all(String t214) {
		if (t214abcnt != 2 || t214cdcnt != 2) {
			throw new RuntimeException("Error in setT214ab or setT214cd: t214=" + t214);
		}
		if (t214.equals("abcdabcd")) {
			ok++;
		}
		if (ok != T214_2) {
			throw new RuntimeException("Error in setT214all. ok=" + ok + ", arg=" + t214);
		}
	}

	
	// T311
	private static final int T311 = T214_2 + 3;
	
	public void setT311(String str) {
		if (str != null && str.equals("a")) {
			ok++;
			t311cnt++;
		}
	}

	// T312
	private static final int T312 = T311 + 4;
	
	public void setT312(String str) {
		if (t311cnt != 3) {
			throw new RuntimeException("Error in setT311: t311cnt=" + t311cnt);
		}
		if (str != null && str.equals("a")) {
			ok++;
			t312cnt++;
		}
	}
	
	// T313
	private static final int T313 = T312 + 2;
	
	public void setT313(String str) {
		if (t312cnt != 4) {
			throw new RuntimeException("Error in setT312: t312cnt=" + t312cnt);
		}
		if (str != null && str.equals("a")) {
			ok++;
			t313cnt++;
		}
	}

	// T411
	private static final int T411 = T313 + 3;

	public void setT411x(String x) {
		if (t313cnt != 2) {
			throw new RuntimeException("Error in setT313: t313cnt=" + t313cnt);
		}
		if (ok != T313) {
			throw new RuntimeException("Error in setT411x. ok=" + ok + ", arg=" + x);
		}
		if ("".equals(x)) {
			ok++;
		}
	}
	
	public void setT411a(String a) {
		if ("a".equals(a)) {
			ok++;
		}
	}

	public void setT411y(String y) {
		if ("".equals(y)) {
			ok++;
		}
	}

	// T511
	private static final int T511 = T411 + 1;
	
	public void setT511a(String t511a) {
		if (phase == 2) {
			if (ok != T411) {
				throw new RuntimeException("Error in setT511a. ok=" + ok + ", arg=" + t511a);
			}
			if ("aaa".equals(t511a)) {
				ok++;
			}
		}
		this.t511a = t511a;
	}
	
	public String getT511a() {
		return t511a;
	}

	// T511
	private static final int T512 = T511 + 2;
	
	
	public boolean getTrue() {
		if (phase == 2) {
			if (ok != T511) {
				throw new RuntimeException("Error in setT511a. ok=" + ok + ", arg=" + t511a);
			}
			ok++;
		}
		return true;
	}
	
	public boolean getFalse() {
		if (phase == 2) {
			ok++;
		}
		return false;
	}
	
	public void setEnd() {
		if (ok != T512) {
			throw new RuntimeException("Error!, ok=" + ok);
		}
	}
}
