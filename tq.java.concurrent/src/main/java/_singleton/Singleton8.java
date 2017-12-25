package com.design.singleton.me;

/**
 * 编写一个包含单个元素的枚举类型
 * ps:从Java1.5开始支持；无偿提供序列化机制，绝对防止多次实例化，即使在面对复杂的序列化或者反射攻击的时候。
 * @author tangqing
 *
 */
public enum Singleton8 {
	INSTANCE;
}
