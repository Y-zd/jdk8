package com.yzd.attach;

/***
 *
 * @author : yanzhidong
 * @date : 2020/6/23 
 * @version : V1.0
 *
 */
public class ClassFileInfo {
    private String fileName;
    private byte[] data;

    public ClassFileInfo() {

    }

    public ClassFileInfo(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
