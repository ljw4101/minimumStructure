package com.intro.web.command;

//param 전달 없는 단순 page이동
public class MoveCommand extends Command{
	public MoveCommand(String dir,String action, String page){
		super.dir=dir;
		super.action=action;
		super.page=page; 
		super.process();
	}
}
