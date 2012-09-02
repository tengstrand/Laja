package net.sf.laja.parser.template;

import java.util.ArrayList;
import java.util.List;

public class Out {
	private int phase;
	private boolean isReceive;
	private boolean isPushPop;
	private String className;
	private String argClass;
	private List<String> commentList = new ArrayList<String>();
    private List statementList = new ArrayList();
	
	public Out(int phase, String className, String argClass, List<String> commentList, boolean isReceive, boolean isPushPop) {
		this.phase = phase;
		this.className = className;
		this.argClass = argClass;
		this.commentList = commentList;
		this.isReceive = isReceive;
		this.isPushPop = isPushPop;
	}

    public void addStatement(Object obj) {
        statementList.add(obj);
    }
    
	/**
	 * @return the phase
	 */
	public int getPhase() {
		return phase;
	}
	
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @return the argClass
	 */
	public String getArgClass() {
		return argClass;
	}

	/**
	 * @return the commentList
	 */
	public List<String> getCommentList() {
		return commentList;
	}

	/**
	 * @return the isReceive
	 */
	public boolean isReceive() {
		return isReceive;
	}

	/**
	 * @return the isPushPop
	 */
	public boolean isPushPop() {
		return isPushPop;
	}

    /**
     * @return the statementList
     */
    public List getStatementList() {
        return statementList;
    }

	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer(500);
        String comments = "[";
        String comma = "";
        for (String comment : commentList) {
            comments = comments + comma + comment;
            comma = ", ";
        }
        comments += "]";

        // TODO: add statements
        String statements = "[";
        comma = "";
        
        for (Object statement : statementList) {
            statements += comma + statement;
            comma = ", ";
        }
        statements += "]";
        
        sb.append("Out{")
          .append("phase=").append(phase)
          .append(", className=").append(className)
          .append(", argClass=").append(argClass)
          .append(", comments=").append(comments)
          .append(", statements=").append(statements)
          .append(", isReceive=").append(isReceive)
          .append(", isPushPop=").append(isPushPop)
          .append("}");
        
        return sb.toString();
    }
}
