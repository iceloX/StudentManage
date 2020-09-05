package com.aiit.utils;

import java.lang.Thread.State;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.iflytek.yuyin.MyYuyin;
/**
 * 使用讯飞语音合成
 * @author icelo
 *
 */
public class Helper {
	
	private static boolean voiceTip = false;// 语音提示的指示变量
	private static Queue<String> messageQue = new ArrayDeque<String>();// 消息队列
	
	public static int hintConfirmMessage(String message, JFrame context) {
		int res=1;
		if (!voiceTip) {
			res= JOptionPane.showConfirmDialog(null,message);
			return res;
		} else {
			MyYuyin.init(MsgConstant.APPID);
			MyYuyin.speak(message+"请根据语音回答确定和取消");
			//MyYuyin.speak("请根据语音回答确定和取消！");
			MyYuyin.startKeepListening(); // 开始持续监听
			while (true) {
				if (MyYuyin.hasNext()) { // 有识别结果
					String string = MyYuyin.getFirstListen(); // 获取队列中第一个识别结果
					System.out.println(string);
					if(string.contains("确")||string.contains("定")||string.contains("确定")) {
						res=0;
						return res;
					} else if(string.contains("取")||string.contains("消息")||string.contains("取消")) {
						res=1;
						return res;
					}else {
						MyYuyin.speak("识别错误");
						res=1;
						return res;
					}
				} else {
					try {
						Thread.sleep(10); // 防止CPU占用过高
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void setVoiceTip(boolean voiceTip) {
		Helper.voiceTip = voiceTip;
	}
	public static void hintshowMessage(String message, JFrame context) {
		if (!voiceTip) {
			JOptionPane.showMessageDialog(context, message);
		} else {
			MyYuyin.init(MsgConstant.APPID);
			MyYuyin.speak(message);
		}
	}
}
