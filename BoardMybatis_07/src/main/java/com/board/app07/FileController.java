package com.board.app07;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.board.dto.FileBoardDTO;
import com.board.model.BoardService;



@Controller
public class FileController {
	@Autowired
	private BoardService bservice;
	
	@GetMapping("fileInsert")
	public String fileInsert() {
		return "fileboardInsert";
	}
	
	@PostMapping("fileInsert")
	public String fileInsert(FileBoardDTO fboard,HttpSession session,Model model) {
		String uploadFolder=session.getServletContext().getRealPath("/")+"\\resources\\img";
			System.out.println(uploadFolder);
			UUID uuid = UUID.randomUUID();
			MultipartFile f = fboard.getUpload();
			
			String uploadFileName="";
			if(!f.isEmpty()) {
				uploadFileName=uuid.toString()+"_"+f.getOriginalFilename();
				File saveFile = new File(uploadFolder,uploadFileName);
			
			
			try {
				f.transferTo(saveFile);
				fboard.setFileImage(uploadFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			}
			bservice.fileInsert(fboard);
		
		return "redirect:fileList";
	}
	@GetMapping("fileList")
	public void fileList(Model model) {
		List<FileBoardDTO> lists = bservice.fileList();
		model.addAttribute("files",lists);
	}
	@GetMapping("uploadForm")
	public void uploadForm() {		
	}
	
	@PostMapping("fileAction")
	public String upload(MultipartFile[] uploads,Model modle) {
		String uploadFolder="C:\\Users\\admin\\git\\Spring\\BoardMybatis_07\\src\\main\\webapp\\resources";
		ArrayList<String> arr = new ArrayList<String>();
		for(MultipartFile multipartFile:uploads) {
			//System.out.println(multipartFile.getOriginalFilename());
			UUID uuid = UUID.randomUUID();
			String uploadFileName=uuid.toString()+"_"+multipartFile.getOriginalFilename();
			//System.out.println(multipartFile.getOriginalFilename());
			File saveFile = new File(uploadFolder,uploadFileName);
			try {
				multipartFile.transferTo(saveFile);
				arr.add(multipartFile.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			modle.addAttribute("uploadFileName",arr);
		}
		return"fileResult";
	}
	
	

}
