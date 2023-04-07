package hkAiRpaProject.service.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hkAiRpaProject.command.FileInfoCommand;
import jakarta.servlet.http.HttpSession;

@Service
public class FileDelService {
	public String execute(FileInfoCommand fileInfoCommand, HttpSession session) {
		String num = "0";
		Boolean newFile = true;
		List<FileInfoCommand> list = (List<FileInfoCommand>)session.getAttribute("fileList");
		if(list == null) {
			list = new ArrayList<FileInfoCommand>();
		}
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).getStoreFile().equals(fileInfoCommand.getStoreFile())) {
				list.remove(i);
				newFile = false;
				num = "0";
			}
		}
		if(newFile) {
			System.out.println("삭제");
			list.add(fileInfoCommand);
			num = "1";
		}
		System.out.println(list.size());
		session.setAttribute("fileList", list);
		return num;
	}
}