package com.rocketleague.itemmanager.domain.vo;

public class ImagemVO {

    private String src;

    public ImagemVO() {
    }

    public ImagemVO(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "ImagemRequest{" +
                ", src='" + src + '\'' +
                '}';
    }
}
