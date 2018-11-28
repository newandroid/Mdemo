package com.css.kotlintest.bean;

import com.css.kotlintest.HH;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 协议
 * cmd  datalen  data
 * 0x81  0x01    0x00
 */
public class ByteProtocolBean implements Serializable {
    @HH
    public byte id;
    @HH
    public byte datalen;
    @HH
    public byte[] payload;

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getDatalen() {
        return datalen;
    }

    public void setDatalen(byte datalen) {
        this.datalen = datalen;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ByteProtocolBean{" +
                "id=" + id +
                ", datalen=" + datalen +
                ", payload=" + Arrays.toString(payload) +
                '}';
    }
}
