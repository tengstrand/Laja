package net.sf.laja.parser.cdd.creator;

public class PackageStatement implements CreatorParser.IPackageStatement {
    public String packagename;
    public String content;

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
