package com.shishuo.cms.entity.vo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MemcacheMapVO implements Serializable {
	private Object value;

	private Long expires;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}

	public int size() {
		try {
			ByteArrayOutputStream buf = new ByteArrayOutputStream();
			ObjectOutputStream o = new ObjectOutputStream(buf);
			o.writeObject(this.value);
			byte[] bytes = buf.toByteArray();
			return bytes.length * 8;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
