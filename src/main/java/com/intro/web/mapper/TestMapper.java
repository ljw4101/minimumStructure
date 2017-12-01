package com.intro.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.intro.web.command.Command;

@Repository
public interface TestMapper {
	public String count(Command cmd);
}