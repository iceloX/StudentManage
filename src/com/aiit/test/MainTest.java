package com.aiit.test;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.aiit.view.AdminLoginFrame;

public class MainTest {
	public static void main(String[] args) {
		
		 try {
	            ////////////////////////---------------程序入口-------------------
	            JFrame.setDefaultLookAndFeelDecorated(true);
	            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
	            ////////////////////////---------------程序入口------------------- 
	            AdminLoginFrame  admin_login=new AdminLoginFrame();
	            admin_login.setVisible(true);
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    } // end main
	   
	} // end class MinFrame