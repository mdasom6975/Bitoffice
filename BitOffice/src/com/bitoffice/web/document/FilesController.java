package com.bitoffice.web.document;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.bitoffice.common.Search;
import com.bitoffice.service.document.FilesService;
import com.bitoffice.service.domain.Files;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/document/*")
public class FilesController extends MultiActionController {
    
	@Autowired
	@Qualifier("fileServiceImpl")
	private FilesService filesService;
	
	public FilesController() {
		
		System.out.println(this.getClass());
	}
 
    public void setFilesService(FilesService filesService) {
        this.filesService = filesService;
    }

    @RequestMapping(value="upload")
    public ModelAndView upload(HttpServletRequest request,
        HttpServletResponse response, ModelAndView modelAndView) throws Exception {
 
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
 
        Files file = new Files();
        file.setFilename(multipartFile.getOriginalFilename());
        file.setNotes(ServletRequestUtils.getStringParameter(request, "notes"));
        file.setType(multipartFile.getContentType());
        file.setFile(multipartFile.getBytes());
 
        this.filesService.save(file);

        return new ModelAndView("forward:/document/list");
    }

    @RequestMapping(value="download")
    public ModelAndView download(HttpServletRequest request,
        HttpServletResponse response, ModelAndView modelAndView) throws Exception {
        int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
 
        Files file = this.filesService.find(id);
 
        response.setContentType(file.getType());
        response.setContentLength(file.getFile().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + file.getFilename() +"\"");
 
        FileCopyUtils.copy(file.getFile(), response.getOutputStream());
 
        return null;
 
    }

    @RequestMapping(value="delete")
    public ModelAndView delete(HttpServletRequest request,
        HttpServletResponse response, ModelAndView modelAndView) throws Exception {
        int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
 
        this.filesService.delete(id);
 
        return new ModelAndView("redirect:/document/list");
    }
    
    @RequestMapping(value="list")
    public String listFile(@ModelAttribute("search") Search search, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
    	
		Map<String, Object> map = filesService.listAll(search);
    	
    	System.out.println("파일목록@@"+map);
    	
    	model.addAttribute("list", map.get("list"));
    	model.addAttribute("search", search);
    	System.out.println("리스트@@@"+map.get("list"));
    	
    	return "forward:/document/document.jsp";
    }
}