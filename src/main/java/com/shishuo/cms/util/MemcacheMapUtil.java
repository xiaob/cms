package com.shishuo.cms.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.shishuo.cms.entity.vo.MemcacheMapVO;

public class MemcacheMapUtil {
	public static final int MINUTES = 60;

	private static final long MAXSIZE = 3000;

	private static final long SAFESIZE = 2800;

	private static final int MAXTIME = 24 * 60 * 60 * 1000;

	private static HashMap<String, MemcacheMapVO> memcacheMap = new HashMap<String, MemcacheMapVO>();

	public static Object get(final String key) {
		MemcacheMapVO memcacheMapVO = memcacheMap.get(key);
		long now = new Date().getTime();
		// 判断是否有这个值存在
		if (memcacheMapVO == null) {
			return null;
			// 判断保存的值是否过期
		} else if (now >= memcacheMapVO.getExpires()) {
			memcacheMap.remove(key);
			return null;
		} else {
			return memcacheMapVO.getValue();
		}
	}

	public static void delete(final String key) {
		memcacheMap.remove(key);
	}

	public static void set(final String key, final Object value,
			final int seconds) {
		// 清理工作
		int count = memcacheMap.size();
		if (count <= MemcacheMapUtil.SAFESIZE) {
			// 小于安全个数，不需要清理
		} else if (count > MemcacheMapUtil.SAFESIZE) {
			// 大于安全个数，按时间清理
			checkMemcacheMap();
			if (count >= MemcacheMapUtil.MAXSIZE) {
				// 清理后无效，进行强制清理
				clearMemcacheMap();
			}
		}
		// 增加值的工作
		MemcacheMapVO memcacheMapVO = new MemcacheMapVO();
		memcacheMapVO.setValue(value);
		long now = new Date().getTime();

		long expires = seconds * 1000;
		if (expires >= MAXTIME) {
			expires = MAXTIME;
		}
		expires += now;
		memcacheMapVO.setExpires(expires);
		memcacheMap.put(key, memcacheMapVO);
	}

	public static void set(final String key, final Object value) {
		set(key, value, 12 * 60 * 60);
	}

	public static String createKey(String methodName, Object... parameters) {
		String str = methodName;
		for (Object obj : parameters) {
			str += "_" + obj.toString();
		}
		return str;
	}

	private static void clearMemcacheMap() {
		// 清除
		long clearCount = MemcacheMapUtil.MAXSIZE - MemcacheMapUtil.SAFESIZE;
		String[] keys = (String[]) memcacheMap.keySet().toArray();
		int keyCount = keys.length;
		Random random = new Random();
		for (int i = 0; i < clearCount; i++) {
			int randomIndex = random.nextInt(keyCount);
			String key = keys[randomIndex];
			delete(key);
		}
	}

	private static void checkMemcacheMap() {
		// 这种迭代的方式节约了一次迭代
		Iterator<Entry<String, MemcacheMapVO>> iterator = memcacheMap
				.entrySet().iterator();
		long now = new Date().getTime();
		while (iterator.hasNext()) {
			Map.Entry<String, MemcacheMapVO> entry = (Map.Entry<String, MemcacheMapVO>) iterator
					.next();
			String key = (String) entry.getKey();
			MemcacheMapVO memcacheMapVO = entry.getValue();
			if (now >= memcacheMapVO.getExpires()) {
				memcacheMap.remove(key);
			}
		}
	}
}
