package id.web.sahir.tutorial.springboot.mvc.controller.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder(alphabetic=true)
//@JsonPropertyOrder(alphabetic=false)
@JsonPropertyOrder({ "rrNo", "tourCode","pnr","amount","remark","words" })
public class DokuDTU {
    String tourCode;
    String rrNo;
    String pnr;
    String amount;
    String remark;
    String words;

    public DokuDTU(String tourCode, String rrNo, String pnr, String amount, String remark, String words) {
        this.tourCode = tourCode;
        this.rrNo = rrNo;
        this.pnr = pnr;
        this.amount = amount;
        this.remark = remark;
        this.words = words;
    }

    public DokuDTU() {

    }

    public String getTourCode() {
        return tourCode;
    }

    public void setTourCode(String tourCode) {
        this.tourCode = tourCode;
    }

    public String getRrNo() {
        return rrNo;
    }

    public void setRrNo(String rrNo) {
        this.rrNo = rrNo;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "DokuDTU : {" +
                "tourCode='" + tourCode + '\'' +
                ", rrNo='" + rrNo + '\'' +
                ", pnr='" + pnr + '\'' +
                ", amount='" + amount + '\'' +
                ", remark='" + remark + '\'' +
                ", words='" + words + '\'' +
                '}';
    }
}
