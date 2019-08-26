package dev.tinyz.excel;

import java.util.Date;

public class BleData {
    //private int CCId;//序号
    private String CCName;//尺寸名称
    private String testName;//产品名称
    private String testerName;//测试人
    private float CCStandard;//检测尺寸
    private float CCTolerance;//尺寸公差
    private float CCSize;//尺寸测量值
    private boolean CCQualified;//是否合格
    private Date date;//测试时间

    public String getCCName() {
        return CCName;
    }

    public void setCCName(String CCName) {
        this.CCName = CCName;
    }

    public float getCCStandard() {
        return CCStandard;
    }

    public void setCCStandard(float CCStandard) {
        this.CCStandard = CCStandard;
    }

    public float getCCTolerance() {
        return CCTolerance;
    }

    public void setCCTolerance(float CCTolerance) {
        this.CCTolerance = CCTolerance;
    }

    public float getCCSize() {
        return CCSize;
    }

    public void setCCSize(float CCSize) {
        this.CCSize = CCSize;
    }

    public boolean isCCQualified() {
        return CCQualified;
    }

    public void setCCQualified(boolean CCQualified) {
        this.CCQualified = CCQualified;
    }

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BleData(String cCName, String testName, float cCStandard, float cCTolerance, float cCSize,
                   boolean cCQualified, String testerName, Date date) {
        super();
        CCName = cCName;
        this.testName = testName;
        CCStandard = cCStandard;
        CCTolerance = cCTolerance;
        CCSize = cCSize;
        CCQualified = cCQualified;
        this.testerName = testerName;
        this.date = date;
    }
}
