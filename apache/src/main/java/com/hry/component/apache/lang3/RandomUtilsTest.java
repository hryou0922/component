package com.hry.component.apache.lang3;

import java.util.Arrays;

import org.apache.commons.lang3.RandomUtils;

public class RandomUtilsTest {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(RandomUtils.nextBytes(2)));
		System.out.println(RandomUtils.nextDouble(10000.1d, 1000000.3d));
		System.out.println(RandomUtils.nextFloat(0f, 10000));
		System.out.println(RandomUtils.nextInt(1000, 30000));
		System.out.println(RandomUtils.nextLong(11111111111l, 2222222222222222222l));

	}

}
 