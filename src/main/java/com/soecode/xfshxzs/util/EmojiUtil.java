package com.soecode.xfshxzs.util;

/**
 * <pre>
 * Emoji表情工具类
 * 
 * {@link http://www.oicqzone.com/tool/emoji/}
 * </pre>
 */
public class EmojiUtil {

	// 十字架
	public static final int CROSS = 0x274C;

	// 右手
	public static final int RIGHT_HAND = 0x1F449;

	// 公交
	public static final int BUS = 0x1F68C;

	// 天气
	public static final int WEATHER = 0x26C5;

	// 货车（快递）
	public static final int TRUCK = 0x1F69A;

	// 游戏
	public static final int GAME = 0x1F3AE;

	// 笔（测试）
	public static final int PENCEIL = 0x270F;

	// 电影
	public static final int MOVIE = 0x1F3A5;

	// 阅读
	public static final int ARTICLE = 0x1F4D6;

	// 问答
	public static final int QUESTION = 0x2753;

	// 音乐
	public static final int MUSIC = 0x1F3B5;

	// 猴子（来一发）
	public static final int MONKEY = 0x1F648;

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
	
}
