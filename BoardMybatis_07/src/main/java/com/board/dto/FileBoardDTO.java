package com.board.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class FileBoardDTO {
 private int num;
 private String title;
 private String writer;
 private String content;
 private MultipartFile upload;
 private String fileImage;
}
