package com.hry.component.httpclient.consistencyhash;

import java.security.MessageDigest;

/*
 * 实现一致性哈希算法中使用的哈希函数,使用MD5算法来保证一致性哈希的平衡性
 */
public class HashFunction implements IHashFunction {
	private MessageDigest md5 = null;

	/* (non-Javadoc)
	 * @see study.hry.tool.consistencyhash.IHashFunction#hash(java.lang.String)
	 */
	public long hash(String key) {
		final int p = 16777619;
		int hash = (int) 2166136261L;
		for (int i = 0; i < key.length(); i++)
			hash = (hash ^ key.charAt(i)) * p;
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;

		// 如果算出来的值为负数则取其绝对值
		if (hash < 0)
			hash = Math.abs(hash);
		return hash;
	}
}