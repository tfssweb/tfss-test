package com.zhongziyue.video.service.dto;

public class CkPlayerDto {

	private String path;
	private String type;
	private String version;
	private int priority;
	
	public CkPlayerDto(String path, String type, String version, int priority) {
		this.path = path;
		this.type = type;
		this.version = version;
		this.priority = priority;
	}
	
	public CkPlayerDto() {
		
	}

	public CkPlayerDto(VideoPlayDto videoPlayDto) {
		this.path = videoPlayDto.getPath() + "/" + videoPlayDto.getName();
		System.out.println(path);
		this.type = "video/mp4";
		this.version = "高清";
		this.priority = 10;
	}

	public String getPath() {
		return path;
	}

	public CkPlayerDto setPath(String path) {
		this.path = path;
		return this;
	}

	public String getType() {
		return type;
	}

	public CkPlayerDto setType(String type) {
		this.type = type;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public CkPlayerDto setVersion(String version) {
		this.version = version;
		return this;
	}

	public int getPriority() {
		return priority;
	}

	public CkPlayerDto setPriority(int priority) {
		this.priority = priority;
		return this;
	}
}
