package com.aiit.utils;

import com.aiit.baidu.FaceAdd;
import com.aiit.baidu.FaceSearch;
import com.aiit.model.Admin;
import com.aiit.service.AdminService;
import com.aiit.service.impl.AdminServiceImpl;
import com.aiit.view.AdminLoginFrame;
import com.aiit.view.AdminRegisterFrame;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WebCam {
	static AdminService as = new AdminServiceImpl();
	private static JFrame window;
	static String fileName;

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * 
	 * getFace(); }
	 */

	public static String getFace(String path, Admin a) {
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());

		WebcamPanel panel = new WebcamPanel(webcam);
		panel.setFPSDisplayed(true);
		panel.setDisplayDebugInfo(true);
		panel.setImageSizeDisplayed(true);
		panel.setMirrored(true);

		JFrame window = new JFrame("面部识别");
		window.add(panel);
		window.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLoginFrame.class.getResource("/img/admin.png")));
		window.setResizable(true);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		final JButton button = new JButton("点击拍照注册");
		window.add(panel, BorderLayout.CENTER);
		window.add(button, BorderLayout.SOUTH);
		window.setResizable(true);
		window.pack();
		window.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				button.setEnabled(false); // 设置按钮不可点击

				// 实现拍照保存-------start
				fileName = path; // 保存路径即图片名称（不用加后缀）
				System.out.println("fileName" + path);
				WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						FaceAdd.add(fileName +".png", a);
						System.out.println(a.toString());
						
						int i = as.AdminRegister(a);
						if (i != 0) {
							int result = JOptionPane.showConfirmDialog(null, MsgConstant.REG_OK_LOGIN);
							if (result == 0) {
								webcam.close();
								window.dispose();
								new AdminLoginFrame().setVisible(true);
							}else {
								webcam.close();
								window.dispose();
								new AdminRegisterFrame().setVisible(true);
							}
							return;
						}
						//button.setEnabled(true); // 设置按钮可点击
					}
				});
				// 实现拍照保存-------end
			}
		});

		return path + ".png";
	}

	public static String getFace2(String tempPath) {
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		String fileName = tempPath; // 保存路径即图片名称（不用加后缀）
		System.out.println("准备拍照！");
		WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
		String result=FaceSearch.faceSearch(fileName+".png");
		webcam.close();
		return result;
		/*
		 * WebcamPanel panel = new WebcamPanel(webcam); panel.setFPSDisplayed(true);
		 * panel.setDisplayDebugInfo(true); panel.setImageSizeDisplayed(true);
		 * panel.setMirrored(true);
		 * 
		 * JFrame window = new JFrame("面部识别"); window.add(panel);
		 * window.setResizable(true);
		 * window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); window.pack();
		 * window.setVisible(true); //实现拍照保存-------start String fileName = tempPath;
		 * //保存路径即图片名称（不用加后缀） WebcamUtils.capture(webcam, fileName,
		 * ImageUtils.FORMAT_PNG); SwingUtilities.invokeLater(new Runnable() {
		 */

		/*
		 * @Override public void run() { JOptionPane.showMessageDialog(null, "ok");
		 * 
		 * } });
		 */
		// 实现拍照保存-------end
	}
}
